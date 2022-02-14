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

    private int foodId;
    private String category;
    private String name;
    private float price;

    public FoodAndDrink() {
    }

    public FoodAndDrink(int foodId, String category, String name, float price) {
        this.foodId = foodId;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodAndDrink{" + "foodId=" + foodId + ", category=" + category + ", name=" + name + '}';
    }

}
