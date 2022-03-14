/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
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
public interface IOrder {
    public ArrayList<Cart> getMyOrderByName(String user);
    public ArrayList<FastFoodCart> getOrderFoodById(int cartId);
    public ArrayList<SeatRoomCart> getOrderSeatById(int cartId);
    public SeatRoom getSeatById(int id);
    public FoodAndDrink getFoodById(int id);
    
}
