/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IBannerDAO;
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
public class BannerDAO extends DBContext implements IBannerDAO {

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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
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
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Banner> pagingBanner(int pageIndex) {
        List<Banner> list = new ArrayList<>();
        try {
            query = "SELECT * FROM "
                    + "( SELECT *, ROW_NUMBER() OVER "
                    + "(ORDER BY ID desc) AS Seq\n"
                    + "FROM dbo.Banner)t WHERE Seq BETWEEN ? AND ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, (pageIndex - 1) * 5 + 1);
            ps.setInt(2, (pageIndex - 1) * 5 + 5);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Banner(
                        rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getString("desc")));
            }
        } catch (SQLException e) {
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public int getTotalBanner() {
        try {
            query = "SELECT count(*) FROM dbo.Banner";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

    @Override
    public ArrayList<Banner> getBannerByTitle(String title, int pageIndex) {
        ArrayList<Banner> list = new ArrayList<>();
        try {
            query = "SELECT *\n"
                    + "FROM \n"
                    + "	(SELECT *, ROW_NUMBER() OVER (ORDER BY ID DESC) AS Seq\n"
                    + "	FROM dbo.Banner where Title like ?) \n"
                    + "t WHERE Seq BETWEEN ? AND ?";

            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title.trim() + "%");
            ps.setInt(2, (pageIndex - 1) * 5 + 1);
            ps.setInt(3, (pageIndex - 1) * 5 + 5);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Banner(
                        rs.getInt("id"),
                        rs.getString("img"),
                        rs.getString("title"),
                        rs.getString("desc")));
            }
        } catch (SQLException e) {
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return list;
    }

    @Override
    public int getTotalBannerByTitle(String title) {
        if (title.equals("")) {
            return 0;
        }

        try {
            query = "SELECT COUNT(*) FROM dbo.Banner WHERE Title like ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + title + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(BannerDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

    public static void main(String[] args) {
        BannerDAO dao = new BannerDAO();
        List<Banner> list = dao.pagingBanner(1);
        System.out.println(list);
    }
}
