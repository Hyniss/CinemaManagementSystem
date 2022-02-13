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
import model.Banner;

/**
 *
 * @author Bảo Châu Bống
 */
public class BannerDAO implements IBannerDAO{

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public Banner getBanner(int id) {
        Banner banner = null;
        try {
            query = "SELECT * FROM dbo.Banner WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                banner = new Banner(rs.getInt("ID"), rs.getString("Img"), rs.getString("Title"), rs.getString("desc"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return banner;
    }
    @Override
    public ArrayList<Banner> getAllBanner() {
        ArrayList<Banner> list = new ArrayList<>();
        try {
            query = "SELECT * FROM dbo.Banner";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Banner(rs.getInt("ID"), rs.getString("Img"), rs.getString("Title"), rs.getString("desc")));
            }
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return list;
    }
    @Override
    public void addBanner(Banner banner) {
        try {
            query = "INSERT INTO dbo.Banner VALUES (?, ?, ?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, banner.getImg());
            ps.setString(2, banner.getTitle());
            ps.setString(3, banner.getDesc());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    
    @Override
    public void editBanner(Banner banner) {
        try {
            query = "UPDATE dbo.Banner SET Img = ?, Title = ? , [desc] = ? WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, banner.getImg());
            ps.setString(2, banner.getTitle());
            ps.setString(3, banner.getDesc());
            ps.setInt(4, banner.getId());
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void deleteBanner(int id) {
        try {
            query = "DELETE FROM dbo.Banner WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public Banner get(int id) {
        try {
            query = "SELECT * FROM dbo.Banner WHERE ID = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Banner banner = new Banner();
                banner.setId(rs.getInt("ID"));
                banner.setTitle(rs.getString("title"));
                banner.setImg(rs.getString("img"));
                banner.setDesc(rs.getString("desc"));
                return banner;
            }
        } catch (SQLException e) {
            Logger.getLogger(Banner.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    public static void main(String[] args) {
        BannerDAO dao = new BannerDAO();
        List<Banner> list = dao.getAllBanner();
        for (Banner o : list) {
            System.out.println(o);
        }
    }
}
