/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Recruitment;
import dao.IRecruitmentDAO;

/**
 *
 * @author Bảo Châu Bống
 */
public class RecruitmentDAO extends DBContext implements IRecruitmentDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public Recruitment getRecruitment(int id) {
        Recruitment recruiment = null;
        try {
            query = "SELECT * FROM dbo.Recruitment WHERE ID = ?";
            con = DBContext.getConnection(); // Open 1 connect với Database của mình
            ps = con.prepareStatement(query); // Biên dịch câu SQL ở trên
            ps.setInt(1, id);
            rs = ps.executeQuery(); // Chạy và thực thi câu SQL

            // next từng phần tử khi tìm thấy cho đến khi đến row cuối cùng thì sẽ dừng vòng lặp while
            while (rs.next()) {
                recruiment = new Recruitment(
                        rs.getInt("ID"),
                        rs.getString("img"),
                        rs.getString("Title"),
                        rs.getString("content"),
                        rs.getString("date"));
            }
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return recruiment;
    }

    @Override
    public ArrayList<Recruitment> getAllRecruitment() {
        ArrayList<Recruitment> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Recruitment ORDER BY [id] asc";
            con = DBContext.getConnection(); // Open 1 connect với Database của mình
            ps = con.prepareStatement(query); // Biên dịch câu SQL ở trên
            rs = ps.executeQuery(); // Chạy và thực thi câu SQL

            // next từng phần tử khi tìm thấy cho đến khi đến row cuối cùng thì sẽ dừng vòng lặp while
            while (rs.next()) {
                list.add(new Recruitment(rs.getInt("ID"),
                        rs.getString("img"),
                        rs.getString("Title"),
                        rs.getString("content"),
                        rs.getString("date")));
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

    @Override
    public void addRecruitment(Recruitment recruitment) {
        try {
            query = "INSERT INTO dbo.Recruitment VALUES (?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, recruitment.getImg());
            ps.setString(2, recruitment.getTitle());
            ps.setString(3, recruitment.getContent());
            ps.setString(4, recruitment.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public void editRecruitment(Recruitment recruitment) {
        try {
            query = "UPDATE dbo.Recruitment SET img = ?, Title = ?, content = ?, date = ? WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, recruitment.getImg());
            ps.setString(2, recruitment.getTitle());
            ps.setString(3, recruitment.getContent());
            ps.setString(4, recruitment.getDate());
            ps.setInt(5, recruitment.getID());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public void deleteRecruitment(int id) {
        try {
            query = "DELETE FROM dbo.Recruitment WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }

    @Override
    public Recruitment get(int id) {
        try {
            query = "SELECT * FROM dbo.Recruitment WHERE ID = ? ORDER BY [id] asc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Recruitment recruitment = new Recruitment();
                recruitment.setID(rs.getInt("ID"));
                recruitment.setImg(rs.getString("img"));
                recruitment.setTitle(rs.getString("Title"));
                recruitment.setContent(rs.getString("content"));
                recruitment.setDate(rs.getString("date"));
                return recruitment;
            }
        } catch (SQLException e) {
            Logger.getLogger(RecruitmentDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return null;
    }

    public static void main(String[] args) {
        RecruitmentDAO dao = new RecruitmentDAO();
        List<Recruitment> list = dao.getAllChucVu();
        for (Recruitment o : list) {
            System.out.println(o);
        }
    }

    @Override
    public ArrayList<Recruitment> getAllChucVu() {
        ArrayList<Recruitment> list = new ArrayList<>();
        try {
            query = "select all Title from dbo.Recruitment";
            con = DBContext.getConnection(); // Open 1 connect với Database của mình
            ps = con.prepareStatement(query); // Biên dịch câu SQL ở trên
            rs = ps.executeQuery(); // Chạy và thực thi câu SQL

            // next từng phần tử khi tìm thấy cho đến khi đến row cuối cùng thì sẽ dừng vòng lặp while
            while (rs.next()) {
                list.add(new Recruitment(rs.getString("Title")));
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
