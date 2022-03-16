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
    private String price;
    private String img;
    

    public FoodAndDrink() {
    }

    public FoodAndDrink(int foodId, String category, String name, String price, String img) {
        this.foodId = foodId;
        this.category = category;
        this.name = name;
        this.price = price;
        this.img = img;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

   

}
