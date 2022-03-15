/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tenhik
 */
public class TimeRoom {
    private int timeRoomId;
    private int movieId;
    private String roomId;
    private int timeId;

    public TimeRoom() {
    }

    public TimeRoom(int timeRoomId, int movieId, String roomId, int timeId) {
        this.timeRoomId = timeRoomId;
        this.movieId = movieId;
        this.roomId = roomId;
        this.timeId = timeId;
    }
        public TimeRoom(int movieId, String roomId, int timeId) {
        this.movieId = movieId;
        this.roomId = roomId;
        this.timeId = timeId;
    }

    public int getTimeRoomId() {
        return timeRoomId;
    }

    public void setTimeRoomId(int timeRoomId) {
        this.timeRoomId = timeRoomId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    @Override
    public String toString() {
        return "TimeRoom{" + "timeRoomId=" + timeRoomId + ", movieId=" + movieId + ", roomId=" + roomId + ", timeId=" + timeId + '}';
    }
    
    
    
}
