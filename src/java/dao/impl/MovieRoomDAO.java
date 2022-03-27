/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IMovieRoomDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieRoomDAO extends DBContext implements IMovieRoomDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<MovieRoom> getAllMovieRoom() {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "SELECT top(9) * FROM dbo.MovieRoom where (DATEDIFF(DAY,GETDATE(),premiere)) >=0";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere")));
            }
        } catch (SQLException e) {
            Logger.getLogger(MovieRoomDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public ArrayList<MovieRoom> getListById(int movieRoomId) {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere")));
            }
        } catch (SQLException e) {
            Logger.getLogger(MovieRoomDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public MovieRoom getMovieRoomById(int movieRoomId) {
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieRoom m = new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"));
                return m;
            }
        } catch (SQLException e) {
            Logger.getLogger(MovieRoomDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return null;
    }

    @Override
    public MovieRoom getMovieRoomByDate(Date date) {
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE premiere = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setDate(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                MovieRoom m = new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"));
                return m;
            }

        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return null;
    }
}
