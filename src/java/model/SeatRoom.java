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

    private String seatRoomId;
    private boolean statusSeat;
    private String movieRoomId;
    private String seatId;

    public SeatRoom() {
    }

    public SeatRoom(String seatRoomId, boolean statusSeat, String movieRoomId, String seatId) {
        this.seatRoomId = seatRoomId;
        this.statusSeat = statusSeat;
        this.movieRoomId = movieRoomId;
        this.seatId = seatId;
    }

    public String getSeatRoomId() {
        return seatRoomId;
    }

    public void setSeatRoomId(String seatRoomId) {
        this.seatRoomId = seatRoomId;
    }

    public boolean isStatusSeat() {
        return statusSeat;
    }

    public void setStatusSeat(boolean statusSeat) {
        this.statusSeat = statusSeat;
    }

    public String getMovieRoomId() {
        return movieRoomId;
    }

    public void setMovieRoomId(String movieRoomId) {
        this.movieRoomId = movieRoomId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        return "SeatRoom{" + "seatRoomId=" + seatRoomId + ", statusSeat=" + statusSeat + ", movieRoomId=" + movieRoomId + ", seatId=" + seatId + '}';
    }

}
