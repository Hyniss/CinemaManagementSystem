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
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            /*Close connection, prepare statement, result set*/
            closeConnection(con);
            closePreparedStatement(ps);
            closeResultSet(rs);
        }
        return cartList;
    }

    

}
