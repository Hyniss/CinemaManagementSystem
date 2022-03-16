/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Class SeatRoomDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.ISeatRoomDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SeatRoom;

/**
 * This class contain method to find SeatRoom information from database
 * Implement ISeatRoomDAO Interface
 *
 * @author Nguyen Nam
 */
public class SeatRoomDAO extends DBContext implements ISeatRoomDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public int addSeatRoom(SeatRoom seatRoom) {
        int id = 0;
        try {
            query = "insert into SeatRoom (seatId,status,timeRoomId) values(?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, seatRoom.getSeatId());
            ps.setBoolean(2, seatRoom.getStatusSeat());
            ps.setInt(3, seatRoom.getTimeRoomId());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(SeatRoomDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return id;
    }

    @Override
    public ArrayList<SeatRoom> getSeatRoomByTimeIdAndMovieId(int timeId, String roomId, int movieId, int movieRoomId) {
        ArrayList<SeatRoom> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select s.*\n"
                    + "from SeatRoom s, TimeRoom t , Room r , Movie m , MovieRoom mr ,MovieTime mt\n"
                    + "where s.timeRoomId = t.timeRoomId and t.roomId = r.roomId and t.movieId = m.movieId\n"
                    + " and t.timeId = mt.timeId and mt.movieRoomId = mr.movieRoomId\n"
                    + "and mt.timeId = ? and r.roomId = ? and m.movieId = ? and mr.movieRoomId =?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, timeId);
            ps.setString(2, roomId);
            ps.setInt(3, movieId);
            ps.setInt(4, movieRoomId);
            /*Query and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                list.add(new SeatRoom(rs.getInt("seatRoomId"),
                        rs.getBoolean("status"),
                        rs.getString("seatId"),
                        rs.getInt("timeRoomId")));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    public static void main(String[] args) {
        ISeatRoomDAO seatRoomDAO = new SeatRoomDAO();
        ArrayList<SeatRoom> list = seatRoomDAO.getSeatRoomByTimeIdAndMovieId(1, "1", 49, 1);
        for (SeatRoom seatRoom : list) {
            System.out.println(seatRoom.getSeatId());
        }
    }

}
