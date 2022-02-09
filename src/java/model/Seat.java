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
public class Seat {

    private String seatId;
    private int seatNumber;
    private String seatRow;
    private String price;

    public Seat() {
    }

    public Seat(String seatId, int seatNumber, String seatRow, String price) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.price = price;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatId=" + seatId + ", seatNumber=" + seatNumber + ", seatRow=" + seatRow + ", price=" + price + '}';
    }

}
