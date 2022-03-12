/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IShowtimesDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovieRoom1;

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
    public ArrayList<MovieRoom1> getAllShowtimes() {
        ArrayList<MovieRoom1> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieRoom";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new MovieRoom1(
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
    public ArrayList<MovieRoom1> getTimeByDate(String premiere) {
        ArrayList<MovieRoom1> list = new ArrayList<>();
        try {
            query = "select *"
                    + "from MovieRoom\n"
                    + "where premiere = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, premiere);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom1(
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
    public ArrayList<MovieRoom1> getTimeById(int movieId) {
        ArrayList<MovieRoom1> list = new ArrayList<>();
        try {
            query = "select *"
                    + "from MovieRoom\n"
                    + "where movieId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom1(
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
        List<MovieRoom1> list = dao.getTimeByDateAndId(48, "2022-02-20");
//        for (MovieRoom1 o : list) {
//            System.out.println(o);
//        }
        //MovieRoom m = dao.getTimeById(49);
        System.out.println(list);
    }

    @Override
    public ArrayList<MovieRoom1> getTimeByDateAndId(int movieId, String premiere) {
        ArrayList<MovieRoom1> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE movieId = ? and premiere = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);
            ps.setString(2, premiere);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new MovieRoom1(
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
    public void addShowtimes(MovieRoom1 movieRoom) {
        try {
            query = "INSERT INTO dbo.MovieRoom values (?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setDate(1, movieRoom.getPremiere());
            ps.setTime(2, movieRoom.getTime());
            ps.setInt(3, movieRoom.getMovieId());
            ps.setInt(4, movieRoom.getRoomId());
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
    public void editShowtimes(MovieRoom1 movieRoom) {
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
            ps.setInt(5, movieRoom.getMovieRoomId());
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
            query = "DELETE FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
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
    public MovieRoom1 getShowtimesExist(int movieId, Time time, Date premiere, int roomId) {
        try {
            query = "select * from dbo.MovieRoom\n"
                    + "where movieId = ? and "
                    + "[time] = ? and premiere = ? "
                    + "and roomId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);
            ps.setTime(2, time);
            ps.setDate(3, premiere);
            ps.setInt(4, roomId);

            rs = ps.executeQuery();

            while (rs.next()) {
                MovieRoom1 m = new MovieRoom1(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere"),
                        rs.getTime("time"),
                        rs.getInt("movieId"),
                        rs.getInt("roomId")
                );
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

    @Override
    public MovieRoom1 get(int id) {
        try {
            query = "SELECT * FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                MovieRoom1 movieRoom = new MovieRoom1();
                movieRoom.setMovieRoomId(rs.getInt("movieRoomId"));
                movieRoom.setMovieId(rs.getInt("movieId"));
                movieRoom.setPremiere(rs.getDate("premiere"));
                movieRoom.setTime(rs.getTime("time"));
                movieRoom.setRoomId(rs.getInt("roomId"));
                return movieRoom;
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
