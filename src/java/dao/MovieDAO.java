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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;

/**
 * This class contain method to find Movie information from database Implement
 * IMovieDAO Interface
 *
 * @author Thai Tran
 */
public class MovieDAO implements IMovieDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    /**
     * getAllMovie method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getAllMovie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Movie";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
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
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    /**
     * getTop6Movie newest method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getTop6Movie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT top(6) * FROM dbo.Movie";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
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
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    /**
     * getMovieById method implement from IMovieDAO
     *
     * @param movieId ID of the Movie. <code>java.lang.Integer</code> object
     * @return Movie object
     */
    @Override
    public Movie getMovieById(int movieId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.Movie where movieId=?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieId);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to a Movie*/
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
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    /**
     * getMoviePremere method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getMoviePremere() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from Movie\n"
                    + "where (day(premiere) <= day(GETDATE())) "
                    + "and (MONTH(premiere) <= month(GETDATE())) "
                    + "and (YEAR(premiere) <= YEAR(GETDATE()))";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
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
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    /**
     * getMovieComing method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getMovieComing() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from Movie\n"
                    + "where (day(premiere) >= day(GETDATE())) "
                    + "and (MONTH(premiere) >= month(GETDATE())) "
                    + "and (YEAR(premiere) >= YEAR(GETDATE()))";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
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
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
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
