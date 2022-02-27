/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IFoodDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
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
 * This class contain method to find Food and drink information from database
 * Implement IFoodDAO Interface
 *
 * @author Nguyen Nam
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
    public int countTotalFood() {
        int count = 0;
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "SELECT COUNT(*) FROM Fastfood";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Assign data*/
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return 0;
    }

    @Override
    public ArrayList<FoodAndDrink> getAllFoodPagging(int pageIndex, int pageSize) {
        ArrayList<FoodAndDrink> list = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "select * from(\n"
                    + "select ROW_NUMBER() over \n"
                    + "(order by foodId asc\n"
                    + ") as r,*\n"
                    + "from Fastfood \n"
                    + ") as t\n"
                    + "where r between(?-1)*?+1\n"
                    + "and ?*?;";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();

            while (rs.next()) {
                /*Assign data to an arraylist of FoodAndDrink model*/
                list.add(new FoodAndDrink(rs.getString("foodId"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getString("price"),
                        rs.getString("img")));
            }
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public FoodAndDrink getFoodAndDrink(String id) {
        try {
            /*Set up connection and Sql statement for Querry*/
            query = "SELECT * FROM Fastfood WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            /*Querry and save in ResultSet*/
            rs = ps.executeQuery();
            while (rs.next()) {
                /*Assign data to an FoodAndDrink Model*/
                FoodAndDrink fd = new FoodAndDrink();
                fd.setFoodId(rs.getString("foodId"));
                fd.setCategory(rs.getString("category"));
                fd.setImg(rs.getString("img"));
                fd.setPrice(rs.getString("price"));
                fd.setName(rs.getString("name"));
                return fd;
            }
        } catch (SQLException e) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DBContext.close(con, ps, rs);
        }
        return null;
    }

    @Override
    public void addFood(FoodAndDrink food) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "INSERT INTO Fastfood VALUES (?,?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Set params for Query*/
            ps.setString(1, food.getCategory());
            ps.setString(2, food.getName());
            ps.setString(3, food.getPrice());
            ps.setString(4, food.getImg());
            /*Excute query and store it to check*/
            ps.executeUpdate();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void editFood(FoodAndDrink food) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "UPDATE Fastfood SET category = ?, name = ? , price  = ?, img = ? WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Set params for Query*/
            ps.setString(1, food.getCategory());
            ps.setString(2, food.getName());
            ps.setString(3, food.getPrice());
            ps.setString(4, food.getImg());
            ps.setString(5, food.getFoodId());
            /*Excute query and store it to check*/
            ps.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
    }

    @Override
    public void deleteFood(String id) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "DELETE FROM Fastfood WHERE foodId = ?";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            /*Set params for Query*/
            ps.setString(1, id);
            /*Excute query and store it to check*/
            ps.executeQuery();
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(FoodAndDrink.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            DBContext.close(con, ps, rs);
        }
    }
}
