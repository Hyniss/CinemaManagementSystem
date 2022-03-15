/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * ShowtimesDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.IShowtimesDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MovieRoom;

/**
 * This class contain method to find MovieRoom information from database
 * Implement IMovieRoomDAO Interface
 *
 * @author Nguyen Nam
 */
public class ShowtimesDAO extends DBContext implements IShowtimesDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public int countTotal() {
        int count = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "SELECT COUNT(*) FROM dbo.MovieRoom";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Assign data*/
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

    @Override
    public ArrayList<MovieRoom> getAllDatePaggingAndSearching(int pageIndex, int pageSize, Date searchDate) {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            String query1 = "select * from(\n"
                    + "select ROW_NUMBER() over\n"
                    + "(order by movieRoomId Desc)as r,\n"
                    + "*\n"
                    + "from MovieRoom\n";
            if (searchDate != null) {
                query1 += "where premiere = ?";
            }
            String query2 = ") as t\n"
                    + "where r between(?-1)*?+1\n"
                    + "and ?*?";
            query = query1 + query2;
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            int count = 1;
            if (searchDate != null) {
                ps.setDate(count++, searchDate);
            }
            ps.setInt(count++, pageIndex);
            ps.setInt(count++, pageSize);
            ps.setInt(count++, pageIndex);
            ps.setInt(count++, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere")));
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
    public ArrayList<MovieRoom> getAllDate() {
        ArrayList<MovieRoom> list = new ArrayList<>();
        try {
            query = "select * from dbo.MovieRoom order by premiere desc "; 
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new MovieRoom(
                        rs.getInt("movieRoomId"),
                        rs.getDate("premiere")));
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
    public int addShowtimes(Date date) {
        int id = 0;
        try {
            query = "INSERT INTO dbo.MovieRoom([premiere])  values (?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, date);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return id;
    }

    @Override
    public void editShowtimes(MovieRoom movieRoom) {
        try {
            query = "update dbo.MovieRoom set\n"
                    + "premiere = ?\n "
                    + "WHERE movieRoomId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setDate(1, movieRoom.getPremiere());
            ps.setInt(2, movieRoom.getMovieRoomId());
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
    public MovieRoom getShowtimes(int movieRoomId) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM dbo.MovieRoom WHERE movieRoomId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, movieRoomId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Account*/
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
    public static void main(String[] args) {
     ShowtimesDAO dao = new ShowtimesDAO();
     MovieRoom movieRoom = dao.getShowtimes(1);
        System.out.println(movieRoom);
    }
}
