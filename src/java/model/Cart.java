/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Bảo Châu Bống
 */
public class Cart {

    private int cartId;
    private String username;
    private double totalPrice;
    private String status;
    private Date orderDate ;

    public Cart() {
    }

    public Cart(String username, double totalPrice, String status) {
        this.username = username;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    
    public Cart(int cartId, String username, double totalPrice, String status, Date orderDate) {
        this.cartId = cartId;
        this.username = username;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

   
    

}
