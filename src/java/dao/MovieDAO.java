/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Movie;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    public ArrayList<Movie> getAllMovie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Movie";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Movie(
                        rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("image"),
                        rs.getString("categoryMovie"),
                        rs.getString("describe"),
                        rs.getString("trailer"),
                        rs.getString("author"),
                        rs.getString("actor"),
                        rs.getString("duration"),
                        rs.getDate("premiere")
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Movie> getTop6Movie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            query = "SELECT top(6) * FROM dbo.Movie";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("image"),
                        rs.getString("categoryMovie"),
                        rs.getString("describe"),
                        rs.getString("trailer"),
                        rs.getString("author"),
                        rs.getString("actor"),
                        rs.getString("duration"),
                        rs.getDate("premiere")
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public Movie getMovieById(int mId) {
        try {
            query = "SELECT * FROM dbo.Movie where movieId=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, mId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Movie m = new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("image"),
                        rs.getString("categoryMovie"),
                        rs.getString("describe"),
                        rs.getString("trailer"),
                        rs.getString("author"),
                        rs.getString("actor"),
                        rs.getString("duration"),
                        rs.getDate("premiere")
                );
                return m;
            }
        } catch (SQLException e) {
        }
        return null;
    }

public ArrayList<Movie> getMoviePremere() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            query = "select * from Movie\n"
                    + "where (day(premiere) <= day(GETDATE())) "
                    + "and (MONTH(premiere) <= month(GETDATE())) "
                    + "and (YEAR(premiere) <= YEAR(GETDATE()))";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("image"),
                        rs.getString("categoryMovie"),
                        rs.getString("describe"),
                        rs.getString("trailer"),
                        rs.getString("author"),
                        rs.getString("actor"),
                        rs.getString("duration"),
                        rs.getDate("premiere")
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public ArrayList<Movie> getMovieComing() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            query = "select * from Movie\n"
                    + "where (day(premiere) >= day(GETDATE())) "
                    + "and (MONTH(premiere) >= month(GETDATE())) "
                    + "and (YEAR(premiere) >= YEAR(GETDATE()))";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Movie(rs.getInt("movieId"),
                        rs.getString("movieName"),
                        rs.getString("image"),
                        rs.getString("categoryMovie"),
                        rs.getString("describe"),
                        rs.getString("trailer"),
                        rs.getString("author"),
                        rs.getString("actor"),
                        rs.getString("duration"),
                        rs.getDate("premiere")
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        List<Movie> list = dao.getTop6Movie();
        for (Movie o : list) {
            System.out.println(o);
        }
        
        Movie m = dao.getMovieById(7);
        System.out.println(m);
    }
}
