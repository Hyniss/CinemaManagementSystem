/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

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

    public MovieRoom(Date premiere) {
        this.premiere = premiere;
    }

    public MovieRoom(int movieRoomId, Date premiere) {
        this.movieRoomId = movieRoomId;
        this.premiere = premiere;

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

    @Override
    public String toString() {
        return "MovieRoom{" + "movieRoomId=" + movieRoomId + ", premiere=" + premiere + ", movieId=" + movieId + '}';
    }
}
