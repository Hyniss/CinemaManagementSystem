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
}
