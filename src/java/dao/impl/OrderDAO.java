/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DBContext;
import dao.IOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Cart;
import model.FastFoodCart;
import model.FoodAndDrink;
import model.FoodAndDrinkCart;
import model.SeatRoom;
import model.SeatRoomCart;

/**
 *
 * @author TIEN HUY
 */
public class OrderDAO extends DBContext implements IOrder {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String query;

    @Override
    public ArrayList<Cart> getMyOrderByName(String user) {
        ArrayList<Cart> cartList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM Cart where username = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,user);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
               cartList.add(new Cart(
                        rs.getInt("cartId"),
                        rs.getString("username"),
                        rs.getDouble("totalPrice"),
                        rs.getString("status"),
                        rs.getDate("orderDate")
                       
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return cartList;
    }

    @Override
    public ArrayList<SeatRoomCart>getOrderSeatById(int cartId) {
         ArrayList<SeatRoomCart> cartSeatList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM SeatRoomCart where cartId = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,cartId);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
               cartSeatList.add(new SeatRoomCart(
                        rs.getInt("seatRoomCartId"),
                       rs.getInt("seatRoomId"),
                       rs.getInt("cartId")
                        
                       
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return cartSeatList;
    }

    @Override
    public ArrayList<FastFoodCart> getOrderFoodById(int cartId) {
        ArrayList<FastFoodCart> cartFoodList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM FastFoodCart where cartId = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,cartId);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
                cartFoodList.add(new FastFoodCart(
                        rs.getInt("fastfoodCartId"),
                       rs.getInt("foodId"),
                       rs.getInt("quantity"),
                       rs.getInt("cartId")
                        
                       
                ));
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return  cartFoodList;
    }

    @Override
    public SeatRoom getSeatById(int id) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM SeatRoom where seatRoomId = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,id);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
               SeatRoom seatRoom = new  SeatRoom(
                        rs.getInt("seatRoomId"),
                       rs.getString("statusSeat"),
                       rs.getString("seatId"),
                       rs.getInt("timeId")
                        
                       
                );
                return  seatRoom;
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return  null;
    }

    @Override
    public FoodAndDrink getFoodById(int id) {
         try {
            /*Set up connection and Sql statement for Query*/
            query = "SELECT * FROM Fastfood where foodId = ? ";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1,id);

            /*Query and save in ResultSet*/
            rs = ps.executeQuery();

            /*Assign data to an arraylist of Account*/
            while (rs.next()) {
               FoodAndDrink foodanddrink = new  FoodAndDrink(
                        rs.getString("foodId"),
                       rs.getString("category"),
                       rs.getString("name"),
                       rs.getString("price"),
                       rs.getString("img")
                        
                       
                );
                return  foodanddrink;
            }
        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return  null;
    }

}
