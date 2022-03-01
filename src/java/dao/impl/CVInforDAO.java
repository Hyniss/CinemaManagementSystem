/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.ICVInforDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CVInfor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bảo Châu Bống
 */
public class CVInforDAO extends DBContext implements ICVInforDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public CVInfor getCV(int id) {
        CVInfor cvinfor = null;
        try {
            query = "select * from dbo.CVInfor where ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                cvinfor = new CVInfor(
                        rs.getInt("ID"),
                        rs.getString("Fullname"),
                        rs.getString("CV"),
                        rs.getString("date"),
                        rs.getString("chucvu"),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            Logger.getLogger(CVInforDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return cvinfor;
    }

    @Override
    public ArrayList<CVInfor> getAllCV() {
        ArrayList<CVInfor> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.CVInfor ORDER BY [date] asc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CVInfor(
                        rs.getInt("ID"),
                        rs.getString("Fullname"),
                        rs.getString("CV"),
                        rs.getString("date"),
                        rs.getString("chucvu"),
                        rs.getString("status")));
            }
        } catch (SQLException e) {
            Logger.getLogger(CVInforDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    public static void main(String[] args) {
        CVInforDAO dao = new CVInforDAO();
        List<CVInfor> list = dao.getAllStatus();
        for (CVInfor o : list) {
            System.out.println(o);
        }
    }

    @Override
    public void addCV(CVInfor cvinfor) {
        try {
            query = "INSERT INTO dbo.CVInfor VALUES (?, ?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, cvinfor.getFullname());
            ps.setString(2, cvinfor.getCV());
            ps.setString(3, cvinfor.getDate());
            ps.setString(4, cvinfor.getChucvu());
            ps.setString(5, cvinfor.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CVInforDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public void editCV(CVInfor cvinfor) {
        try {
            query = "UPDATE dbo.CVInfor SET [status] = ? WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, cvinfor.getStatus());
            ps.setInt(2, cvinfor.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CVInforDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public void deleteCV(int id) {
        try {
            query = "DELETE FROM dbo.CVInfor WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(CVInforDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public ArrayList<CVInfor> getAllStatus() {
        ArrayList<CVInfor> list = new ArrayList<>();
        try {
            query = "select all [status] from dbo.CVInfor";
            con = DBContext.getConnection(); // Open 1 connect với Database của mình
            ps = con.prepareStatement(query); // Biên dịch câu SQL ở trên
            rs = ps.executeQuery(); // Chạy và thực thi câu SQL

            // next từng phần tử khi tìm thấy cho đến khi đến row cuối cùng thì sẽ dừng vòng lặp while
            while (rs.next()) {
                list.add(new CVInfor(rs.getString("status")));
            }
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }
}
