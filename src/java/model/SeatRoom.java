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
    private boolean statusSeat;
     private String seatId;
    private int timeRoomId;
   

    public SeatRoom() {
    }

     public SeatRoom(boolean statusSeat, String seatId, int timeRoomId) {
        this.statusSeat = statusSeat;
        this.seatId = seatId;
        this.timeRoomId = timeRoomId;
    }
    
    public SeatRoom(int seatRoomId, boolean statusSeat, String seatId, int timeRoomId) {
        this.seatRoomId = seatRoomId;
        this.statusSeat = statusSeat;
        this.seatId = seatId;
        this.timeRoomId = timeRoomId;
    }

    public int getSeatRoomId() {
        return seatRoomId;
    }

    public void setSeatRoomId(int seatRoomId) {
        this.seatRoomId = seatRoomId;
    }

    public boolean getStatusSeat() {
        return statusSeat;
    }

    public void setStatusSeat(boolean statusSeat) {
        this.statusSeat = statusSeat;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getTimeRoomId() {
        return timeRoomId;
    }

    public void setTimeRoomId(int timeRoomId) {
        this.timeRoomId = timeRoomId;
    }

    
 

}
