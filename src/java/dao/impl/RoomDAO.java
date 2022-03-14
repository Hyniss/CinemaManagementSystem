/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IRoomDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;

/**
 *
 * @author tenhik
 */
public class RoomDAO extends DBContext implements IRoomDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<Room> getAllRoom() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Room";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(
                        rs.getString("roomId"),
                        rs.getString("roomName")
                ));
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
    public static void main(String[] args) {
        RoomDAO d = new RoomDAO();
        ArrayList<Room> list = d.getAllRoom();
        for (Room room : list) {
            System.out.println(room);
        }
    }
}
