/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * MovieDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Thai Tran    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.IMovieDAO;
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
public class MovieDAO extends DBContext implements IMovieDAO {

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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    /**
     * getNext4Movie from amount to amount+4 method implement from IMovieDAO
     * param @amount int
     *
     * @param amount
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
    public Movie getMovieById(int movieId) {///////////////////////////////////////////////////////////////////////////////////////
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            ps.setString(1, "%" + movieName.trim() + "%");


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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            query = "select * from Movie\n";
//                    + "where (DATEDIFF(DAY,GETDATE(),premiere)) > -14 and (DATEDIFF(DAY,GETDATE(),premiere))<=0";
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    //get movie with pagging
    @Override
    public ArrayList<Movie> getMovieWithPagging(int page, int PAGE_SIZE) {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "Select * from movie order by movieId\n"
                    + "offset (?-1)*? row fetch next ? rows only";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public ArrayList<Movie> getMovieByMovieRoomId(int movieRoomId, String roomId) {
        ArrayList<Movie> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select M.*\n"
                    + "from Movie M join MovieTime MT\n"
                    + "on M.movieId = MT.movieId\n"
                    + "where MT.movieRoomId = ? and roomId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            ps.setInt(1, movieRoomId);
            ps.setString(2, roomId);
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
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    //count total movie
    @Override
    public int getTotalMovie() {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(MovieId) from Movie";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Movie*/
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

    //add movie
    @Override
    public void addMovie(Movie movie) {
        try {

            query
                    = "insert into Movie(movieName,image,categoryMovie,"
                    + "describe,trailer,author,actor,duration,[premiere]) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, movie.getMovieName());
            ps.setString(2, movie.getImage());
            ps.setString(3, movie.getCategoryMovie());
            ps.setString(4, movie.getDescription());
            ps.setString(5, movie.getTrailer());
            ps.setString(6, movie.getAuthor());
            ps.setString(7, movie.getActor());
            ps.setString(8, movie.getDuration());
            ps.setDate(9, movie.getPremiere());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    //delete movie
    @Override
    public void deleteMovie(int id) {
        try {
            query = "DELETE FROM dbo.Movie WHERE movieId = ? ";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    //update movie
    @Override
    public void editMovie(Movie movie) {
        try {
            query = "UPDATE Movie SET movieName = ?, image = ?, categoryMovie = ?, describe = ?, "
                    + "trailer=?, author=?, actor=?, duration=?, premiere=? WHERE movieId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, movie.getMovieName());
            ps.setString(2, movie.getImage());
            ps.setString(3, movie.getCategoryMovie());
            ps.setString(4, movie.getDescription());
            ps.setString(5, movie.getTrailer());
            ps.setString(6, movie.getAuthor());
            ps.setString(7, movie.getActor());
            ps.setString(8, movie.getDuration());
            ps.setDate(9, movie.getPremiere());
            ps.setInt(10, movie.getMovieId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    public static void main(String[] args) {
        MovieDAO dao = new MovieDAO();
        List<Movie> list = dao.getMovieWithPagging(3, 4);
        for (Movie o : list) {
            System.out.println(o);
        }

//        Movie m = dao.getMovieById(7);
//        System.out.println(m);
    }
}
