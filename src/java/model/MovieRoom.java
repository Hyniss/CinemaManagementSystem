/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.SimpleTimeZone;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieRoom {

    private int movieRoomId;
    private String premiere;
    private String time;
    private int movieId;
    private int roomId;

    public MovieRoom() {
    }

    public MovieRoom(String premiere) {
        this.premiere = premiere;
    }

    public MovieRoom(String premiere, String time, int movieId) {
        this.premiere = premiere;
        this.time = time;
        this.movieId = movieId;
    }

    public MovieRoom(int movieRoomId, String premiere, String time, int movieId, int roomId) {
        this.movieRoomId = movieRoomId;
        this.premiere = premiere;
        this.time = time;
        this.movieId = movieId;
        this.roomId = roomId;
    }

    public int getMovieRoomId() {
        return movieRoomId;
    }

    public void setMovieRoomId(int movieRoomId) {
        this.movieRoomId = movieRoomId;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

//    public void setNewTime(String time) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ѕѕ");
//        time = time.format(formatter);
//    }

    @Override
    public String toString() {
        return "MovieRoom{" + "movieRoomId=" + movieRoomId + ", premiere=" + premiere + ", time=" + time + ", movieId=" + movieId + ", roomId=" + roomId + '}';
    }

}
