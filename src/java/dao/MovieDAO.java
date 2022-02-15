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
     * getTop8Movie newest method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getTop8Movie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT top(8) * FROM dbo.Movie order by MovieId desc";
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
     * getTop4Movie newest method implement from IMovieDAO
     *
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getTop4Movie() {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT top(4) * FROM dbo.Movie order by movieId desc";
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
     * getNext4Movie from amount to amount+4 method implement from IMovieDAO
     * param @amount int
     *
     * @return chapters. <code>java.util.ArrayList</code> object
     */
    @Override
    public ArrayList<Movie> getNext4Movie(int amount) {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT *\n"
                    + "FROM (\n"
                    + "SELECT *, ROW_NUMBER() OVER (ORDER BY MovieId DESC) AS Seq\n"
                    + "FROM Movie\n"
                    + ")t\n"
                    + "WHERE Seq BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, amount + 3);

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
     * getMovieByName method implement from IMovieDAO
     *
     * @param movieName Name of the Movie. <code>java.lang.Integer</code> object
     * @return <List>Movie
     */
    @Override
    public ArrayList<Movie> getMovieByName(String movieName) {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select * from Movie where movieName like ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+movieName.trim()+"%");


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
                    + "where (DATEDIFF(DAY,GETDATE(),premiere)) > -14";
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
                    + "where (DATEDIFF(DAY,GETDATE(),premiere)) >0";
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
        List<Movie> list = dao.getTop8Movie();
        for (Movie o : list) {
            System.out.println(o);
        }

        Movie m = dao.getMovieById(7);
        System.out.println(m);
    }
}
