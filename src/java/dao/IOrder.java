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
    ArrayList<Cart> getMyOrderByName(String user,int pageIndex);
    ArrayList<FastFoodCart> getOrderFoodById(int cartId);
    ArrayList<SeatRoomCart> getOrderSeatById(int cartId);
    SeatRoom getSeatById(int id);
     FoodAndDrink getFoodById(int id);
    int getTotalOrder(String user);
     int getTotalOrderByDate(String user,String date);
     ArrayList<Cart> getMyOrderByDate(String user,String date,int pageIndex);
    
}
