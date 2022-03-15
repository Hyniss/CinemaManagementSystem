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
    public ArrayList<Cart> getMyOrderByName(String user,int pageIndex) {
        ArrayList<Cart> cartList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            
            query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY cartId desc) AS Seq\n" +
                    "FROM Cart where username = ?)t WHERE Seq BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,user);
            ps.setInt(2,(pageIndex - 1) * 3 + 1);
            ps.setInt(3,(pageIndex - 1) * 3 + 3);
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
                       rs.getInt("cartId"),
                        rs.getDouble("price")
                        
                       
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
                       rs.getString("status"),
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
   

    public int getTotalOrder(String user) {
         try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Cart where username = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,user);
            /*Excute query and store it to check*/
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

  
 public static void main(String[] args) {
        OrderDAO or = new OrderDAO();
        FoodAndDrink s = or.getFoodById(1);
        System.out.println(s.getPrice());
    }

    @Override
    public ArrayList<Cart> getMyOrderByDate(String user,String date, int pageIndex) {
         ArrayList<Cart> cartList = new ArrayList<>();
        try {
            /*Set up connection and Sql statement for Query*/
            
            query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY cartId desc) AS Seq\n" +
                    "FROM Cart where orderDate like ? and username = ?)t WHERE Seq BETWEEN ? AND ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,"%"+date.trim()+"%");
            ps.setString(2,user);
            ps.setInt(3,(pageIndex - 1) * 3 + 1);
            ps.setInt(4,(pageIndex - 1) * 3 + 3);
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
    public int getTotalOrderByDate(String user,String date) {
        try {
            /*Set up connection and Sql statement for Query*/
            query = "select count(*) from Cart where orderDate like ? and username =?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,"%"+date.trim()+"%");
             ps.setString(2,user);
            /*Excute query and store it to check*/
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            /*Exeption Handle*/
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return 0;
    }

}
