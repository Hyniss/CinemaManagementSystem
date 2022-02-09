/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bảo Châu Bống
 */
public class FoodAndDrink {

    private String foodId;
    private String category;
    private String name;

    public FoodAndDrink() {
    }

    public FoodAndDrink(String foodId, String category, String name) {
        this.foodId = foodId;
        this.category = category;
        this.name = name;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FoodAndDrink{" + "foodId=" + foodId + ", category=" + category + ", name=" + name + '}';
    }

}
