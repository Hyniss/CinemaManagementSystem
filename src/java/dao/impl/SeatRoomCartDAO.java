/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Class SeatRoomCartDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.ISeatRoomCartDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SeatRoomCart;

/**
 * This class contain method to find SeatRoomCart information from database
 * Implement ISeatRoomCartDAO Interface
 *
 * @author Nguyen Nam
 */
public class SeatRoomCartDAO extends DBContext implements ISeatRoomCartDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public void addSeatRoomCart(SeatRoomCart seatRoomCart) {
        try {
            query = "  insert into SeatRoomCart(seatRoomId,cartId) values(?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, seatRoomCart.getSeatRoomId());
            ps.setInt(2, seatRoomCart.getCartId());
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

}
