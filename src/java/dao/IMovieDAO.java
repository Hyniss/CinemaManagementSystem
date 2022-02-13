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

    public ArrayList<Movie> getTop6Movie();

    public Movie getMovieById(int movieId);
    
    public ArrayList<Movie> getMoviePremere();
    
    public ArrayList<Movie> getMovieComing();

}
