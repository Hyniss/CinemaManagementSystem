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
 * @author HP
 */
public class AccountDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> accountList = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Account";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
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
        }
        return accountList;
    }

    public Account getAccountByUsername(String username) {
        try {
            query = "SELECT * FROM dbo.Account where username=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
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
    
    public void editAccount(Account a) {
        try {
            query = "UPDATE [Account] SET [password] = ?,[avatar]=?,[fullname]=?,[DOB]=?,[email]=?,[phone]=?, [roleId]=? WHERE [username] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getAvatar());
            ps.setString(3, a.getFullName());
            ps.setDate(4, (Date) a.getDob());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getPhone());
            ps.setInt(7, a.getRoleId());
            ps.setString(8, a.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public void signup(String user,String pass,String fullname,String dob,String email,String phone){
        query= "insert into account values(?,?,null,?,?,?,?,3)";
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
}
