/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * TimeroomDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.ITimeRoomDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TimeRoom;

/**
 * This class contain method to find TimeRoom information from database
 * Implement ITimeRoomDAO Interface
 *
 * @author Nguyen Nam
 */
public class TimeRoomDAO extends DBContext implements ITimeRoomDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<TimeRoom> getAllTimeRoom() {
        ArrayList<TimeRoom> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.TimeRoom";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"))
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }

        return list;
    }

    @Override
    public ArrayList<TimeRoom> getAllTimeRoomByMovieRoom(int movieRoomId) {
        ArrayList<TimeRoom> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.TimeRoom";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"))
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }

        return list;
    }

    @Override
    public TimeRoom getTimeRoom(int timeRoomId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from TimeRoom where timeRoomId = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeRoomId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
            while (rs.next()) {
                TimeRoom m = new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"));
                return m;
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

    @Override
    public boolean addTimeRoom(TimeRoom timeRoom) {
        int check = 0;
        try {
            query = "INSERT INTO dbo.TimeRoom ([roomId],[timeId],[movieId]) values (?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, timeRoom.getRoomId());
            ps.setInt(2, timeRoom.getTimeId());
            ps.setInt(3, timeRoom.getMovieId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return check > 0;
    }

//    public static void main(String[] args) {
//        TimeRoomDAO d = new TimeRoomDAO();
//        TimeRoom timeRoom = new TimeRoom(12, "1", 33);
//        d.addTimeRoom(timeRoom);
//    }
    @Override
    public boolean editTimeRoom(TimeRoom timeRoom) {
        int check = 0;
        try {
            query = "update dbo.TimeRoom\n"
                    + "set movieId =?,\n"
                    + "roomId=?,\n"
                    + "timeId=?\n"
                    + "where timeRoomId=?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeRoom.getMovieId());
            ps.setString(2, timeRoom.getRoomId());
            ps.setInt(3, timeRoom.getTimeId());
            ps.setInt(4, timeRoom.getTimeRoomId());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return check > 0;
    }

    @Override
    public boolean deleteTimeRoom(int timeRoomId) {
        int check = 0;
        try {
            query = "DELETE FROM dbo.TimeRoom WHERE timeRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeRoomId);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return check > 0;
    }

    @Override
    public TimeRoom getTimeRoomByTimeAndRoom(int timeId, String roomId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.TimeRoom WHERE timeId = ? and roomId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeId);
            ps.setString(2, roomId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
            while (rs.next()) {
                TimeRoom m = new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"));
                return m;
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

    @Override
    public TimeRoom getTimeRoomByMovieRoom(int movieRoomId, String roomId, int timeId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.TimeRoom WHERE timeId = ? and roomId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeId);
            ps.setString(2, roomId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
            while (rs.next()) {
                TimeRoom m = new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"));
                return m;
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

    @Override
    public ArrayList<TimeRoom> getByMovieId(int movieId) {
        ArrayList<TimeRoom> list = new ArrayList<>();
        try {
            query = "SELECT top(10) * FROM dbo.TimeRoom WHERE movieId = ? ";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId")));
            }
        } catch (SQLException e) {
            Logger.getLogger(MovieDateDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public TimeRoom getTimeRoomByTimeAndRoom(int timeId, String roomId ,int movieId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.TimeRoom WHERE timeId = ? and roomId = ? and movieId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeId);
            ps.setString(2, roomId);
            ps.setInt(3, movieId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
            while (rs.next()) {
                TimeRoom m = new TimeRoom(
                        rs.getInt("timeRoomId"),
                        rs.getInt("movieId"),
                        rs.getString("roomId"),
                        rs.getInt("timeId"));
                return m;
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

}
