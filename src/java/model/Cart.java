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
public class Cart {

    private String cartId;
    private String username;
    private String quantity;
    private String totalPrice;

    public Cart() {
    }

    public Cart(String cartId, String username, String quantity, String totalPrice) {
        this.cartId = cartId;
        this.username = username;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", username=" + username + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }

}
