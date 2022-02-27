/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Movie;

/**
 *
 * @author tenhik
 */
public interface IMovieDAO {

    public ArrayList<Movie> getAllMovie();

    public ArrayList<Movie> getTop8Movie();
    
    public ArrayList<Movie> getTop4Movie();
    
    public ArrayList<Movie> getNext4Movie(int amount);

    public Movie getMovieById(int movieId);
    
    public ArrayList<Movie> getMovieByName(String movieName);
    
    public ArrayList<Movie> getMoviePremere();
    
    public ArrayList<Movie> getMovieComing();
    
    public void addMovie(Movie movie);
    
    public void deleteMovie(int id);
    
    public void editMovie(Movie movie);
}
