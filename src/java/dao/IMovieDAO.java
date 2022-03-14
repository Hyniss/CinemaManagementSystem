/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IMovieDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Thai tran     First Implement
 */
package dao;

import java.util.ArrayList;
import model.Movie;

/**
 * This is the interface class that declares the methods to access the data of
 * the TimeRoom object Abstract 
 * method getAllTimeRoom used to retrieve all
 * feedback
 *
 * @author Nguyen Nam
 */
public interface IMovieDAO {

    //get all movie
    public ArrayList<Movie> getAllMovie();

    //get top 8 movie
    public ArrayList<Movie> getTop8Movie();
    
    //get top 4 movie
    public ArrayList<Movie> getTop4Movie();
    
    //get next 4 movie
    public ArrayList<Movie> getNext4Movie(int amount);

    //get movie
    public Movie getMovieById(int movieId);
    
    //get movie by name
    public ArrayList<Movie> getMovieByName(String movieName);
    
    //get movie premiere
    public ArrayList<Movie> getMoviePremere();
    
    //get movie coming
    public ArrayList<Movie> getMovieComing();
    
    //get movie by room and movieroom 
    public ArrayList<Movie> getMovieByMovieRoomId(int movieRoomId, String roomId);
    
    //add
    public void addMovie(Movie movie);
    
    //delete
    public void deleteMovie(int id);
    
    //edit
    public void editMovie(Movie movie);
    
    //pagging
    public ArrayList<Movie> getMovieWithPagging(int page,int PAGE_SIZE);
    
    //count total movie
    public int getTotalMovie();
}
