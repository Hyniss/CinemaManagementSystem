/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Promotion;

/**
 *
 * @author Bảo Châu Bống
 */
public class PromotionDAO implements IPromotionDAO{

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public Promotion getPromotion(int id) {
        Promotion promotion = null;
        try {
            query = "SELECT * FROM dbo.Promotion WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                promotion = new Promotion(rs.getInt("ID"), rs.getString("Title"), rs.getString("Content"), rs.getString("imageLink"), rs.getDate("date"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return promotion;
    }

    @Override
    public ArrayList<Promotion> getAllPromotion() {
        ArrayList<Promotion> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Promotion ORDER BY [date] desc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Promotion(rs.getInt("ID"), rs.getString("Title"), rs.getString("Content"), rs.getString("imageLink"), rs.getDate("date")));
            }
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public void addPromotion(Promotion promotion) {
        try {
            query = "INSERT INTO dbo.Promotion VALUES (?, ?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, promotion.getTitle());
            ps.setString(2, promotion.getContent());
            ps.setString(3, promotion.getImageLink());
            ps.setString(4, promotion.getFormatedDate());
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void editPromotion(Promotion promotion) {
        try {
            query = "UPDATE dbo.Promotion SET Title = ?, Content = ?, imageLink = ?, date = ? WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, promotion.getTitle());
            ps.setString(2, promotion.getContent());
            ps.setString(3, promotion.getImageLink());
            ps.setString(4, promotion.getFormatedDate());
            ps.setInt(5, promotion.getId());
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void deletePromotion(int id) {
        try {
            query = "DELETE FROM dbo.Promotion WHERE ID = ? ORDER BY [date] desc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public Promotion get(int id) {
        try {
            query = "SELECT * FROM dbo.Promotion WHERE ID = ? ORDER BY [date] desc";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Promotion promotion = new Promotion();
                promotion.setId(rs.getInt("ID"));
                promotion.setTitle(rs.getString("Title"));
                promotion.setContent(rs.getString("Content"));
                promotion.setImageLink(rs.getString("imageLink"));
                promotion.setDate(rs.getDate("date"));
                return promotion;
            }
        } catch (SQLException e) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    public static void main(String[] args) {
        PromotionDAO dao = new PromotionDAO();
        List<Promotion> list = dao.getAllPromotion();
        for (Promotion o : list) {
            System.out.println(o);
        }
    }
}
