/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.INotificationAccountDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NotificationAccount;

/**
 *
 * @author HP
 */
public class NotificationAccountDAO extends DBContext implements INotificationAccountDAO {
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;
    
    /**
     * get5Notification method implement from INotificationAccountDAO
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<NotificationAccount> get5Notification(String username) {
        ArrayList<NotificationAccount> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT top 5 * FROM dbo.NotificationAccount where username = ? order by notificationId desc";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Notification*/
            while (rs.next()) {
                list.add(new NotificationAccount(
                        rs.getInt("notificationId"), 
                        rs.getString("username"), 
                        rs.getBoolean("readed")
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }
    
    /**
     * editReaded method implement from INotificationAccountDAO
     *
     * @param int notificationId, String username object
     * @return boolean object to know it executed or not
     */
    @Override
    public boolean editReaded(int notificationId, String username) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "UPDATE [NotificationAccount] SET [readed] = 1 WHERE [notificationId] = ? and [username] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Set params for Query*/
            ps.setInt(1, notificationId);
            ps.setString(2, username);

            /*Excute query and store it to check*/
            check = ps.executeUpdate();

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return check > 0;
    }
    
}
