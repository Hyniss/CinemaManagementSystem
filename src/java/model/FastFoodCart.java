/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TIEN HUY
 */
public class FastFoodCart {
    private int fastfoodCartId;
    private int foodId;
    private int quantity;
    private int cartId ;
    private double price;

    public FastFoodCart() {
    }

    public FastFoodCart(int fastfoodCartId, int foodId, int quantity, int cartId, double price) {
        this.fastfoodCartId = fastfoodCartId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.cartId = cartId;
        this.price = price;
    }

    public int getFastfoodCartId() {
        return fastfoodCartId;
    }

    public void setFastfoodCartId(int fastfoodCartId) {
        this.fastfoodCartId = fastfoodCartId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
