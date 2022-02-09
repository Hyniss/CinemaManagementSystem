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
public class Feedback {

    private String feedbackId;
    private String accoutnId;
    private String movieId;
    private String feedback;
    private int rating;

    private Account account;
    private Movie movie;

    public Feedback() {
    }

    public Feedback(String feedbackId, String accoutnId, String movieId, String feedback, int rating) {
        this.feedbackId = feedbackId;
        this.accoutnId = accoutnId;
        this.movieId = movieId;
        this.feedback = feedback;
        this.rating = rating;
    }

    public Feedback(String feedbackId, String accoutnId, String movieId, String feedback, int rating, Account account, Movie movie) {
        this.feedbackId = feedbackId;
        this.accoutnId = accoutnId;
        this.movieId = movieId;
        this.feedback = feedback;
        this.rating = rating;
        this.account = account;
        this.movie = movie;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getAccoutnId() {
        return accoutnId;
    }

    public void setAccoutnId(String accoutnId) {
        this.accoutnId = accoutnId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Feedback{" + "feedbackId=" + feedbackId + ", accoutnId=" + accoutnId + ", movieId=" + movieId + ", feedback=" + feedback + ", rating=" + rating + ", account=" + account + ", movie=" + movie + '}';
    }

}
