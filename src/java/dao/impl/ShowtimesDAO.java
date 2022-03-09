/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IShowtimesDAO;
import java.sql.Connection;
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
public class ShowtimesDAO extends DBContext implements IShowtimesDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<MovieRoom> getAllShowtimes() {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieRoom";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"),
                        rs.getTime("time"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId")));
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
    public ArrayList<MovieRoom> getTimeByDate(String premiere) {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "select *"
                    + "from MovieRoom\n"
                    + "where premiere = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, premiere);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"),
                        rs.getTime("time"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId")));
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
    public ArrayList<MovieRoom> getTimeById(int movieId) {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "select *"
                    + "from MovieRoom\n"
                    + "where movieId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"),
                        rs.getTime("time"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId")));
            };
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

    public static void main(String[] args) {
        ShowtimesDAO dao = new ShowtimesDAO();
        // List<MovieRoom> list = dao.getTimeById("2022-02-18", 48);
        List<MovieRoom> list = dao.getTimeByDateAndId(48, "2022-02-20");
//        for (MovieRoom o : list) {
//            System.out.println(o);
//        }
        //MovieRoom m = dao.getTimeById(49);
        System.out.println(list);
    }

    @Override
    public ArrayList<MovieRoom> getTimeByDateAndId(int movieId, String premiere) {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE movieId = ? and premiere = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);
            ps.setString(2, premiere);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"),
                        rs.getTime("time"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId")));
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
    public void addShowtimes(MovieRoom movieRoom) {
        try {
            query = "INSERT INTO dbo.MovieRoom values (?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setDate(1, movieRoom.getPremiere());
            ps.setTime(2, movieRoom.getTime());
            ps.setInt(3, movieRoom.getMovieId());
            ps.setInt(4, movieRoom.getMovieRoomId());
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
    public void editShowtimes(MovieRoom movieRoom) {
        try {
            query = "update dbo.MovieRoom set\n"
                    + "premiere = ?, "
                    + "[time] = ? , movieId = ?, roomId = ? WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setDate(1, movieRoom.getPremiere());
            ps.setTime(2, movieRoom.getTime());
            ps.setInt(3, movieRoom.getMovieId());
            ps.setInt(4, movieRoom.getRoomId());
            ps.executeQuery();
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
    public void deleteShowtimes(int movieRoomId) {
        try {
            query = "DELETE * FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }
}


