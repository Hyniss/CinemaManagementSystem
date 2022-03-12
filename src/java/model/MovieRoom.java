/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieRoom {

    private int movieRoomId;
    private Date premiere;
    private int movieId;

    public MovieRoom() {
    }

    public MovieRoom(int movieRoomId, Date premiere, int movieId) {
        this.movieRoomId = movieRoomId;
        this.premiere = premiere;
        this.movieId = movieId;
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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        int strDate = Integer.parseInt((formatter.format(premiere)));
        //System.out.println(strDate);
        return strDate;
    }

    public int getMonth() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        int strDate = Integer.parseInt((formatter.format(premiere)));
        //System.out.println(strDate);
        return strDate;
    }

    public int getYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int strDate = Integer.parseInt((formatter.format(premiere)));
        //System.out.println(strDate);
        return strDate;
    }
    
    public String getDay(){
        Calendar cal = Calendar.getInstance();
        cal.set(getYear(), getMonth(), getDate());
        DateFormat formatter = new SimpleDateFormat("EE", Locale.getDefault());
        return formatter.format(cal.getTime());
    }

    @Override
    public String toString() {
        return "MovieRoom{" + "movieRoomId=" + movieRoomId + ", premiere=" + premiere + ", movieId=" + movieId + '}';
    }
}
