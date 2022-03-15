/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * FeedbackDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.IFeedbackDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Feedback;

/**
 * This class contain method to find Feedback information from database
 * Implement IFeebackDAO Interface
 *
 * @author Nguyen Nam
 */
public class FeedbackDAO extends DBContext implements IFeedbackDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<Feedback> getAllFeedbackPaggingAndSorting(int pageIndex, int pageSize, int sortId) {
        ArrayList<Feedback> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            String query1 = "select * from(\n"
                    + "select ROW_NUMBER() over\n"
                    + "(order by\n";
            switch (sortId) {
                case 0:
                    query1 += "feedbackId desc";
                    break;
                case 1:
                    query1 += "feedbackDate desc, feedbackTime desc";
                    break;
                case 2:
                    query1 += "feedbackDate asc, feedbackTime asc";
                    break;
                case 3:
                    query1 += "rate desc";
                    break;
                case 4:
                    query1 += "rate asc";
                    break;
            }
            String query2 = ")as r,*\n"
                    + "from Feedback\n"
                    + ")as t\n"
                    + "where r between(?-1)*?+1\n"
                    + "and ?*?;";
            query = query1 + query2;
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Assign data to an arraylist of FoodAndDrink model*/
                list.add(new Feedback(rs.getInt("feedbackId"),
                        rs.getString("username"),
                        rs.getInt("movieId"),
                        rs.getString("feedback"),
                        rs.getInt("rate"),
                        rs.getDate("feedbackDate"),
                        rs.getTime("feedbackTime")
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public int countTotalFeedback() {
        int count = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "SELECT COUNT(*) FROM Feedback";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Assign data*/
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

    @Override
    public boolean addFeeback(Feedback feedback) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "INSERT INTO Feedback(username,movieId,feedback,rate,feedbackDate,feedbackTime)\n"
                    + "VALUES(?,?,?,?,?,?)";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            /*Set params for Query*/
            ps.setString(1, feedback.getUsername());
            ps.setInt(2, feedback.getMovieId());
            ps.setString(3, feedback.getFeedback());
            ps.setInt(4, feedback.getRate());
            ps.setDate(5, (Date) feedback.getFeedbackDate());
            ps.setTime(6, (Time) feedback.getFeedbackTime());
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

    @Override
    public boolean updateFeeback(Feedback feedback) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "UPDATE Feedback\n"
                    + "set feedback=?,\n"
                    + "rate=?\n"
                    + "where feedbackId = ? \n"
                    + "and username =? \n"
                    + "and movieId =?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            /*Set params for Query*/
            ps.setString(1, feedback.getFeedback());
            ps.setInt(2, feedback.getRate());
            ps.setInt(3, feedback.getFeedbackId());
            ps.setString(4, feedback.getUsername());
            ps.setInt(5, feedback.getMovieId());
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

    @Override
    public boolean deleteFeeback(int feedbackId) {
        int check = 0;
        try {
            /*Set up connection and Sql statement for Query*/
            query = "delete from Feedback where feedbackId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, feedbackId);
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
