/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.INotificationDAO;
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
import model.Notification;

/**
 *
 * @author HP
 */
public class NotificationDAO extends DBContext implements INotificationDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    /**
     * getAllNotification method implement from INotificationDAO
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Notification> getAllNotification() {
        ArrayList<Notification> notificationList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Notification";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                notificationList.add(new Notification(
                        rs.getInt("notificationId"),
                        rs.getString("notificationImg"),
                        rs.getString("notificationTitle"),
                        rs.getString("notificationDescription"),
                        rs.getDate("notificationDate")
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
        return notificationList;
    }

    /**
     * getNotificationById method implement from IAccountDAO
     *
     * @param id is primary key of the Notification.
     * @return Notification object
     */
    @Override
    public Notification getNotificationById(int id) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Notification where notificationId=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an Account*/
            while (rs.next()) {
                Notification a = new Notification(
                        rs.getInt("notificationId"),
                        rs.getString("notificationImg"),
                        rs.getString("notificationTitle"),
                        rs.getString("notificationDescription"),
                        rs.getDate("notificationDate")
                );
                return a;
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
        return null;
    }

    /**
     * pagingNotification implement from INotificationDAO
     *
     * @param pageIndex int, roleId int
     * @return boolean object to know it executed or not
     */
    @Override
    public List<Notification> pagingNotification(int pageIndex) {
        List<Notification> notificationList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY notificationId desc) AS Seq\n"
                    + "FROM dbo.Notification)t WHERE Seq BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, (pageIndex - 1) * 5 + 1);
            ps.setInt(2, (pageIndex - 1) * 5 + 5);

            /*Excute query and store it to check*/
            rs = ps.executeQuery();

            while (rs.next()) {
                notificationList.add(new Notification(
                        rs.getInt("notificationId"),
                        rs.getString("notificationImg"),
                        rs.getString("notificationTitle"),
                        rs.getString("notificationDescription"),
                        rs.getDate("notificationDate")
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
        return notificationList;
    }

    /**
     * getTotalNotification method implement from INotificationDAO
     *
     * @return boolean object to know it executed or not
     */
    @Override
    public int getTotalNotification() {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Notification";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Excute query and store it to check*/
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }

    /**
     * insertNotification method implement from INotificationDAO
     *
     * @param Notification. Notification object
     * @return boolean object to know it executed or not
     */
    @Override
    public boolean insertNotification(Notification a) {

        int check = 0;
        try {
            query = "insert into [notification] values(?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, a.getNotificationImg());
            ps.setString(2, a.getNotificationTitle());
            ps.setString(3, a.getNotificationDescription());
            ps.setDate(4, (Date) a.getNotificationDate());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return check > 0;
    }

    /**
     * editNotifications method implement from INotificationDAO
     *
     * @param Notification. Notification object
     * @return boolean object to know it executed or not
     */
    @Override
    public boolean editNotification(Notification a) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "UPDATE [Notification] SET [notificationImg] = ?,[notificationTitle]=?,[notificationDescription]=?,[notificationDate]=? WHERE [notificationId] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Set params for Query*/
            ps.setString(1, a.getNotificationImg());
            ps.setString(2, a.getNotificationTitle());
            ps.setString(3, a.getNotificationDescription());
            ps.setDate(4, (Date) a.getNotificationDate());

            ps.setInt(5, a.getNotificationId());

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

    /**
     * deleteNotification method implement from INotificationDAO
     *
     * @param notificationId Integer
     * @return boolean object to know it executed or not
     */
    @Override
    public boolean deleteNotification(int notificationId) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "delete from Notification where notificationId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Set params for Query*/
            ps.setInt(1, notificationId);

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

    /**
     * getNotificationByTitle method implement from INotificationDAO
     *
     * @param notificationTitle String
     * @return <ArrayList>Notification
     */
    @Override
    public ArrayList<Notification> getNotificationByTitle(String notificationTitle, int pageIndex) {
        ArrayList<Notification> notificationList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY notificationId desc) AS Seq\n"
                    + "FROM dbo.Notification where notificationTitle like ?)t WHERE Seq BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + notificationTitle.trim() + "%");
            ps.setInt(2, (pageIndex - 1) * 5 + 1);
            ps.setInt(3, (pageIndex - 1) * 5 + 5);


            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
            while (rs.next()) {
                notificationList.add(new Notification(
                        rs.getInt("notificationId"),
                        rs.getString("notificationImg"),
                        rs.getString("notificationTitle"),
                        rs.getString("notificationDescription"),
                        rs.getDate("notificationDate")
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return notificationList;
    }

    /**
     * getTotalNotificationByTitle method implement from INotificationDAO
     *
     * @return boolean object to know it executed or not
     */
    @Override
    public int getTotalNotificationByTitle(String title) {
        if (title.equals("")) {
            return 0;
        }
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Notification where notificationTitle like ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");

            /*Excute query and store it to check*/
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }

    public static void main(String[] args) {
        NotificationDAO dao = new NotificationDAO();
//        List<Notification> notificationList = dao.getNotificationByTitle("lễ",1);
//        for (Notification a : notificationList) {
//            System.out.println(a);
//        }
        List<Notification> list = dao.getNotificationByTitle("BẮT HỔ CHO BÉ", 1);
        System.out.println(list);

    }

}
