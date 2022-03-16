/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Class FoodAndDrinkDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao.impl;

import dao.DBContext;
import dao.IFoodCartDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FoodAndDrinkCart;

/**
 * This class contain method to find SeatRoom information from database
 * Implement IFoodCartDAO Interface
 *
 * @author Nguyen Nam
 */
public class FoodCartDAO extends DBContext implements IFoodCartDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public void addFoodCart(FoodAndDrinkCart foodAndDrinkCart) {
        try {
            query = "  insert into FastFoodCart(foodId,quantity,cartId,price) values(?,?,?,?)";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, foodAndDrinkCart.getFoodId());
            ps.setInt(2, foodAndDrinkCart.getQuantity());
            ps.setInt(3, foodAndDrinkCart.getCartId());
            ps.setDouble(4,foodAndDrinkCart.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ShowtimesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
    }
    public static void main(String[] args) {
        FoodAndDrinkCart c = new FoodAndDrinkCart(1,1,20,50000);
        FoodCartDAO d = new FoodCartDAO();
              d.addFoodCart(c);
    }

}
