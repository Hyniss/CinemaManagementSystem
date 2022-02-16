/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Thai Tran
 */
public class AccountDAO implements IAccountDAO{

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;
    
    
    /**
     * getAllAccount method implement from IAccountDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> accountList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Account";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            
            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                accountList.add(new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("avatar"),
                        rs.getString("fullName"),
                        rs.getDate("DOB"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("roleId")
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return accountList;
    }

    /**
     * getAccountByUserName method implement from IAccountDAO
     *
     * @param username is primary key of the Account. String object
     * @return Account object
     */
    @Override
    public Account getAccountByUsername(String username) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Account where username=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an Account*/
            while (rs.next()) {
                Account a = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("avatar"),
                        rs.getString("fullName"),
                        rs.getDate("DOB"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("roleId")
                );
                return a;
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    /**
     * editAccount method implement from IAccountDAO
     *
     * @param Account. Account object
     * @return boolean object to know it executed or not
     */
    @Override
    public boolean editAccount(Account a) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "UPDATE [Account] SET [password] = ?,[avatar]=?,[fullname]=?,[DOB]=?,[email]=?,[phone]=?, [roleId]=? WHERE [username] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            
            /*Set params for Query*/
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getAvatar());
            ps.setString(3, a.getFullName());
            ps.setDate(4, (Date) a.getDob());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getPhone());
            ps.setInt(7, a.getRoleId());
            ps.setString(8, a.getUsername());
            
            /*Excute query and store it to check*/
            check = ps.executeUpdate();
            
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        List<Account> accountList = dao.getAllAccount();
        for (Account a : accountList) {
            System.out.println(a);
        }

        Account a = dao.getAccountByUsername("tranvietdanhthai");
        System.out.println(a);
    }
    
    //hàm đăng nhập
    @Override 
    public Account login(String user, String pass) {

        query = "select * from account where username = ? and password = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //check xem tài khoản có tồn tại ko
    @Override
    public Account checkAccountExist(String user) {

        query = "select * from account where username = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    //hàm kiểm tra xem mật khẩu của tài khoản này có đúng ko nếu đúng thì mới cho đổi mật khẩu
    @Override
    public Account checkPassword(String user,String pass) {

        query = "select * from account where username = ? and password=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    //hàm đăng ký
    @Override
    public void signup(String user,String pass,String fullname,String dob,String email,String phone){
        query= "insert into account values(?,?,'profile-pic.jpg',?,?,?,?,3)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, fullname);
            ps.setString(4, dob);
            ps.setString(5, email);
            ps.setString(6, phone);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
          
    }
    
    //hàm change mật khẩu
    @Override
    public void changePassword(String newpass,String oldpass,String user){
        query="update account set password=? where username=? and password=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, newpass);
            ps.setString(2, user);
            ps.setString(3, oldpass);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
      // hàm check email và user có tồn tại hay không
          public Account checkEmail(String user,String email) {
        
           try {
            query = "SELECT * FROM dbo.Account where username=? and email = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                Account a = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("avatar"),
                        rs.getString("fullName"),
                        rs.getDate("DOB"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("roleId")
                );
                return a;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
     
        
        
    }

