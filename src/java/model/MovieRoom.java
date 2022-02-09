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
public class MovieRoom {

    private String movieRoomId;
    private String premereMovieRoom;
    private String movieId;
    private String roomId;

    public MovieRoom() {
    }

    public MovieRoom(String movieRoomId, String premereMovieRoom, String movieId, String roomId) {
        this.movieRoomId = movieRoomId;
        this.premereMovieRoom = premereMovieRoom;
        this.movieId = movieId;
        this.roomId = roomId;
    }

    public String getMovieRoomId() {
        return movieRoomId;
    }

    public void setMovieRoomId(String movieRoomId) {
        this.movieRoomId = movieRoomId;
    }

    public String getPremereMovieRoom() {
        return premereMovieRoom;
    }

    public void setPremereMovieRoom(String premereMovieRoom) {
        this.premereMovieRoom = premereMovieRoom;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "MovieRoom{" + "movieRoomId=" + movieRoomId + ", premereMovieRoom=" + premereMovieRoom + ", movieId=" + movieId + ", roomId=" + roomId + '}';
    }

}
