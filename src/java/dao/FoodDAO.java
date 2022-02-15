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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FoodAndDrink;

/**
 *
 * @author tenhik
 */
public class FoodDAO implements IFoodDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;


     @Override
    public ArrayList<FoodAndDrink> getAllFood() {
        ArrayList<FoodAndDrink> list = new ArrayList<>();
        try {
            query = "SELECT * FROM Fastfood";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FoodAndDrink(rs.getString("foodId"), rs.getString("category"), rs.getString("name"), rs.getString("price"), rs.getString("img")));
            }
        } catch (SQLException e) {
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public void addFood(FoodAndDrink food) {
        try {
            query = "INSERT INTO Fastfood VALUES (?,?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, food.getCategory());
            ps.setString(2, food.getName());
            ps.setString(3, food.getPrice());
            ps.setString(4, food.getImg());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void editFood(FoodAndDrink food) {
        try {
            query = "UPDATE Fastfood SET category = ?, name = ? , price  = ?, img = ? WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, food.getCategory());
            ps.setString(2, food.getName());
            ps.setString(3, food.getPrice());
            ps.setString(4, food.getImg());
            ps.setString(5, food.getFoodId());

            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }
      public FoodAndDrink getFoodAndDrink(String id) {
        try {
            query = "SELECT * FROM Fastfood WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
               FoodAndDrink fd = new FoodAndDrink();
               fd.setFoodId(rs.getString("foodId"));
               fd.setCategory(rs.getString("category"));
               fd.setImg(rs.getString("img"));
               fd.setPrice(rs.getString("price"));
               fd.setName(rs.getString("name"));
                return fd;
            }
        } catch (SQLException e) {
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    @Override
    public void deleteFood(String id) {
         try {
            query = "DELETE FROM Fastfood WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
    }

 

}
