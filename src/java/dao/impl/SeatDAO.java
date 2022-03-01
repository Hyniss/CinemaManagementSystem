/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * SeatDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.ISeatDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seat;

/**
 * This class contain method to find Seat information from database Implement
 * ISeatDAO Interface
 *
 * @author Nguyen Nam
 */
public class SeatDAO extends DBContext implements ISeatDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    /**
     * getSeatPriceBySeatId method implement from ISeatDAO
     *
     * @param seatId ID of the Seat.
     * @return chapter <code>model.Seat</code> object
     */
    @Override
    public Seat getSeatInfoBySeatId(String seatId) {
        Seat seat = new Seat();
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "SELECT * FROM dbo.Seat WHERE seatId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, seatId);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            /*Assign data to an Seat Model*/
            while (rs.next()) {
                seat.setSeatId(rs.getString("seatId"));
                seat.setSeatNumber(rs.getInt("seatNumber"));
                seat.setSeatRow(rs.getString("seatRow"));
                seat.setPrice(rs.getString("price"));
            }
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(SeatDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return seat;
    }
}
