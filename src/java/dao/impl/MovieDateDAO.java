/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IMovieDateDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovieDate;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieDateDAO extends DBContext implements IMovieDateDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<MovieDate> getAllMovieDate() {

        ArrayList<MovieDate> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieDate";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieDate(
                        rs.getInt("dateId"),
                        rs.getInt("movieRoomId"),
                        rs.getTime("time"),
                        rs.getInt("roomId")));
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
    public ArrayList<MovieDate> getDateById(int movieRoomId) {
        ArrayList<MovieDate> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.MovieDate WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieDate(
                        rs.getInt("dateId"),
                        rs.getInt("movieRoomId"),
                        rs.getTime("time"),
                        rs.getInt("roomId")));
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

    public ArrayList<MovieDate> getId(ArrayList<MovieRoom> listM) {
       ArrayList<MovieDate> list = new ArrayList<>();
//        query = "select *"
//                + "from MovieRoom m, MovieDate d"
//                + "where ,.movieRoomId = d.movieRoomId "
//                + "and movieId = ?, premiere = ? ";
//        try {
//            con = DBContext.getConnection();
//            ps = con.prepareStatement(query);
//            for (MovieRoom m : listM) {
//                ps = con.prepareStatement(query);
//                ps.setInt(1, m.getMovieId());
//                ps.setDate(2, m.getPremiere());
//                rs = ps.executeQuery();
//                while (rs.next()) {
//                    list.add(new MovieDate(
//                            rs.getInt("dateId"),
//                            rs.getInt("movieRoomId"),
//                            rs.getTime("time"),
//                            rs.getInt("roomId")));
//                }
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(MovieDateDAO.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            /*Close connection, prepare statement, result set*/
//            closeConnection(con);
//            closePreparedStatement(ps);
//            closeResultSet(rs);
//        }
        return list;
   }

    public static void main(String[] args) {
        MovieDateDAO dao = new MovieDateDAO();
        // List<MovieRoom> list = dao.getTimeById("2022-02-18", 48);
        List<MovieDate> list = dao.getDateById(4);
//        for (MovieRoom1 o : list) {
//            System.out.println(o);
//        }
        //MovieRoom m = dao.getTimeById(49);
        System.out.println(list);
    }

}
