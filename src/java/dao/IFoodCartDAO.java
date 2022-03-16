/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IFoodCartDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import model.FoodAndDrinkCart;

/**
 * This is the interface class that declares the methods to access the data of
 * the FoodCart object
 *
 * @author Nguyen Nam
 */
public interface IFoodCartDAO {
    public void addFoodCart(FoodAndDrinkCart foodAndDrinkCart);
}
