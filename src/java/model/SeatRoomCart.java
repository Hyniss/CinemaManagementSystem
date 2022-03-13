/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TIEN HUY
 */
public class SeatRoomCart {
    private int seatRoomCartId;
     private int seatRoomId;
      private int cartId;

    public SeatRoomCart() {
    }

    public SeatRoomCart(int seatRoomCartId, int seatRoomId, int cartId) {
        this.seatRoomCartId = seatRoomCartId;
        this.seatRoomId = seatRoomId;
        this.cartId = cartId;
    }

    public int getSeatRoomCartId() {
        return seatRoomCartId;
    }

    public void setSeatRoomCartId(int seatRoomCartId) {
        this.seatRoomCartId = seatRoomCartId;
    }

    public int getSeatRoomId() {
        return seatRoomId;
    }

    public void setSeatRoomId(int seatRoomId) {
        this.seatRoomId = seatRoomId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
      
    
    
}
