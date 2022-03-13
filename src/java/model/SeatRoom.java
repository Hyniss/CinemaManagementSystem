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
public class SeatRoom {

    private int seatRoomId;
    private String statusSeat;
     private String seatId;
    private int timeId;
   

    public SeatRoom() {
    }

    public SeatRoom(int seatRoomId, String statusSeat, String seatId, int timeId) {
        this.seatRoomId = seatRoomId;
        this.statusSeat = statusSeat;
        this.seatId = seatId;
        this.timeId = timeId;
    }

    public int getSeatRoomId() {
        return seatRoomId;
    }

    public void setSeatRoomId(int seatRoomId) {
        this.seatRoomId = seatRoomId;
    }

    public String getStatusSeat() {
        return statusSeat;
    }

    public void setStatusSeat(String statusSeat) {
        this.statusSeat = statusSeat;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    
 

}
