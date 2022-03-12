/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IMovieTimeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovieRoom;
import model.MovieTime;

/**
 *
 * @author tenhik
 */
public class MovieTimeDAO extends DBContext implements IMovieTimeDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<MovieTime> getMovieTimeByMovieRoomId(ArrayList<MovieRoom> movieRoom) {
        ArrayList<MovieTime> list = new ArrayList<>();
        for (MovieRoom m : movieRoom) {
            try {
                query = "SELECT * FROM dbo.MovieTime where movieRoomId =?";
                con = DBContext.getConnection();
                ps = con.prepareStatement(query);
                ps.setInt(1, m.getMovieRoomId());
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new MovieTime(
                            rs.getString("slot"),
                            rs.getInt("timeId"),
                            rs.getTime("start"),
                            rs.getTime("finish"),
                            rs.getInt("movieRoomId"),
                            rs.getString("add")
                    ));
                }
            } catch (SQLException e) {
                Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                /*Close connection, prepare statement, result set*/
                closeConnection(con);
                closePreparedStatement(ps);
                closeResultSet(rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<MovieTime> getMovieByMovieRoomId(int movieRoomId) {
        ArrayList<MovieTime> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieTime where movieRoomId =?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieTime(
                        rs.getString("slot"),
                        rs.getInt("timeId"),
                        rs.getTime("start"),
                        rs.getTime("finish"),
                        rs.getInt("movieRoomId"),
                        rs.getString("add")
                ));
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
    public boolean addMovieTime(String slot, Time start, Time end, int movieRoomId, String add) {
        int check = 0;
        try {
            query = "INSERT INTO dbo.MovieTime ([slot],[start],[finish],[movieRoomId],[add]) values (?,?,?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, slot);
            ps.setTime(2, start);
            ps.setTime(3, end);
            ps.setInt(4, movieRoomId);
            ps.setString(5, add);
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
    public boolean addMovieTimeSlot(String slot, int movieRoomId, String add) {
        int check = 0;
        try {
            query = "INSERT INTO dbo.MovieTime ([slot],[movieRoomId],[add]) values (?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, slot);
            ps.setInt(2, movieRoomId);
            ps.setString(3, add);
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
    public boolean deleteMovieTime(int movieRoomId) {
        int check = 0;
        try {
            query = "DELETE FROM dbo.MovieTime WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
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
    public void editMovieTime(Time start, Time end, int movieRoomId,String slot, String add) {
        try {
            query = "update dbo.MovieTime\n"
                    + "set start=?,\n"
                    + "finish=?,\n"
                    + "[add]=?\n"
                    + "where movieRoomId=? and slot=?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setTime(1, start);
            ps.setTime(2, end);
            ps.setString(3, add);
            ps.setInt(4, movieRoomId);
            ps.setString(5, slot);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public void editMovieTimeSlot(int movieRoomId, String add) {
        try {
            query = "update dbo.MovieTime\n"
                    + "set [add]=?\n"
                    + "where movieRoomId=?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, add);
            ps.setInt(2, movieRoomId);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public MovieTime getMovieTime(int movieroomId, String slot) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.MovieTime WHERE movieRoomId = ? and slot = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieroomId);
            ps.setString(2, slot);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
            while (rs.next()) {
                MovieTime m = new MovieTime(
                        rs.getString("slot"),
                        rs.getInt("timeId"),
                        rs.getTime("start"),
                        rs.getTime("finish"),
                        rs.getInt("movieRoomId"),
                        rs.getString("add")
                );
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
