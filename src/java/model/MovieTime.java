/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *
 * @author tenhik
 */
public class MovieTime {

    private int timeId;
    private String slot;
    private Time start;
    private Time end;
    private int movieRoomId;
    private String add;

    public MovieTime() {
    }

    public MovieTime(String slot, int timeId, Time start, Time end, int movieRoomId, String add) {
        this.timeId = timeId;
        this.slot = slot;
        this.start = start;
        this.end = end;
        this.movieRoomId = movieRoomId;
        this.add = add;
    }

    public MovieTime(int timeId, String slot, Time start, Time end, int movieRoomId, String add) {
        this.timeId = timeId;
        this.slot =slot;
        this.start = start;
        this.end = end;
        this.movieRoomId = movieRoomId;
        this.add =add;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getMovieRoomId() {
        return movieRoomId;
    }

    public void setMovieRoomId(int movieRoomId) {
        this.movieRoomId = movieRoomId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    
    @Override
    public String toString() {
        return "MovieTime{" + "timeId=" + timeId + ", slot=" + slot + ", start=" + start + ", end=" + end + ", movieRoomId=" + movieRoomId + ", add=" + add + '}';
    }

}
