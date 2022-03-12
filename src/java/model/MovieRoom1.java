/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;


/**
 *
 * @author Bảo Châu Bống
 */
public class MovieRoom1 {

    private int movieRoomId;
    private Date premiere;
    private Time time;
    private int movieId;
    private int roomId;

    public MovieRoom1() {
    }

    public MovieRoom1(Date premiere) {
        this.premiere = premiere;
    }

    public MovieRoom1(Date premiere, Time time, int movieId) {
        this.premiere = premiere;
        this.time = time;
        this.movieId = movieId;
    }

    public MovieRoom1(int movieRoomId, Date premiere, Time time, int movieId, int roomId) {
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

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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
