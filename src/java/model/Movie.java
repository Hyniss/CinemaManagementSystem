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
public class Movie {

    private int movieId;
    private String movieName;
    private String image;
    private String categoryMovie;
    private String description;
    private String trailer;
    private String author;
    private String actor;
    private String duration;
    private Date premiere;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String image, String categoryMovie, String description, String trailer, String author, String actor, String duration, Date premiere) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.image = image;
        this.categoryMovie = categoryMovie;
        this.description = description;
        this.trailer = trailer;
        this.author = author;
        this.actor = actor;
        this.duration = duration;
        this.premiere = premiere;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryMovie() {
        return categoryMovie;
    }

    public void setCategoryMovie(String categoryMovie) {
        this.categoryMovie = categoryMovie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName=" + movieName + ", image=" + image + ", categoryMovie=" + categoryMovie + ", description=" + description + ", trailer=" + trailer + ", author=" + author + ", actor=" + actor + ", duration=" + duration + ", premiere=" + premiere + '}';
    }

}
