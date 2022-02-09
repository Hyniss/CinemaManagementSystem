/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Bảo Châu Bống
 */
public class CartDetail {

    private String cartDetailId;
    private String accountId;
    private String seatRoomId;
    private String foodId;
    private String price;
    private Date bookingDate;
    private String cartId;

    public CartDetail() {
    }

    public CartDetail(String cartDetailId, String accountId, String seatRoomId, String foodId, String price, Date bookingDate, String cartId) {
        this.cartDetailId = cartDetailId;
        this.accountId = accountId;
        this.seatRoomId = seatRoomId;
        this.foodId = foodId;
        this.price = price;
        this.bookingDate = bookingDate;
        this.cartId = cartId;
    }

    public String getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(String cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSeatRoomId() {
        return seatRoomId;
    }

    public void setSeatRoomId(String seatRoomId) {
        this.seatRoomId = seatRoomId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartDetail{" + "cartDetailId=" + cartDetailId + ", accountId=" + accountId + ", seatRoomId=" + seatRoomId + ", foodId=" + foodId + ", price=" + price + ", bookingDate=" + bookingDate + ", cartId=" + cartId + '}';
    }

}
