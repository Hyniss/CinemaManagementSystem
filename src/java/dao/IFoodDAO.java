/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IFoodDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.ArrayList;
import model.FoodAndDrink;

/**
 * This is the interface class that declares the methods to access the data of
 * the Subject object Abstract method getAllSubject used to retrieve all food
 * and drink
 *
 * @author Nguyen Nam
 */
public interface IFoodDAO {



    public ArrayList<FoodAndDrink> getAllFood(); //List all food and drink from database

    public void addFood(FoodAndDrink food);// insert data into database

    public void editFood(FoodAndDrink food);// update data into database

    public FoodAndDrink getFoodAndDrink(String id);//search id into database

    public void deleteFood(String id);//remove object into database
}
