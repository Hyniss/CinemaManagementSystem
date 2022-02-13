/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tenhik
 */
public class SeatDAO implements ISeatDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public String getSeatPriceBySeatId(String seatId) {
        String price = "";
        try {
            query = "SELECT price FROM dbo.Seat WHERE seatId = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, seatId);
            rs = ps.executeQuery();
            while (rs.next()) {
                price = rs.getString("price");
                return price;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        ISeatDAO seatDAO = new SeatDAO();
        String price = seatDAO.getSeatPriceBySeatId("A1");
        System.out.println(price);
    }
}
