/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieDate {

    private int dateId;
    private int movieRoomId;
    private Time time;
    private int roomId;

    public MovieDate() {
    }

    public MovieDate(int dateId, int movieRoomId, Time time, int roomId) {
        this.dateId = dateId;
        this.movieRoomId = movieRoomId;
        this.time = time;
        this.roomId = roomId;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public int getMovieRoomId() {
        return movieRoomId;
    }

    public void setMovieRoomId(int movieRoomId) {
        this.movieRoomId = movieRoomId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTimeFormatted() {
        SimpleDateFormat df = new SimpleDateFormat(" hh:mm aa");
        String strDate = ((df.format(time)));
        //System.out.println(strDate);
        return strDate;
    }

    @Override
    public String toString() {
        return "MovieDate{" + "dateId=" + dateId + ", movieRoomId=" + movieRoomId + ", time=" + time + ", roomId=" + roomId + '}';
    }

}
