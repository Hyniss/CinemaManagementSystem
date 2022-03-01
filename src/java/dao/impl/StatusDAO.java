/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IStatusDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Status;

/**
 *
 * @author Bảo Châu Bống
 */
public class StatusDAO extends DBContext implements IStatusDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<Status> getAllStatus() {
        ArrayList<Status> statusList = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Status";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                statusList.add(new Status(
                        rs.getInt("id"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return statusList;
    }

    public static void main(String[] args) {
        StatusDAO dao = new StatusDAO();
        List<Status> roleList = dao.getAllStatus();
        for (Status a : roleList) {
            System.out.println(a);
        }

    }
}
