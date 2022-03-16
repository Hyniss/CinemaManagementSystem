/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tenhik
 */
public class FoodAndDrinkCart {

    private int FoodAndDrinkId;
    private int foodId;
    private int quantity;
    private int cartId;
    private double price;

    public FoodAndDrinkCart() {
    }
    
    public FoodAndDrinkCart(int foodId, int quantity, int cartId, double price) {
        this.foodId = foodId;
        this.quantity = quantity;
        this.cartId = cartId;
        this.price = price;
    }
    public FoodAndDrinkCart(int foodId, int quantity, double price) {
        this.foodId = foodId;
        this.quantity = quantity;
        this.price = price;
    }

    public FoodAndDrinkCart(int FoodAndDrinkId, int foodId, int quantity, int cartId, double price) {
        this.FoodAndDrinkId = FoodAndDrinkId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.cartId = cartId;
        this.price = price;
    }

    public int getFoodAndDrinkId() {
        return FoodAndDrinkId;
    }

    public void setFoodAndDrinkId(int FoodAndDrinkId) {
        this.FoodAndDrinkId = FoodAndDrinkId;
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
