/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Bảo Châu Bống
 */
public class Feedback {

    private int feedbackId;
    private String username;
    private int movieId;
    private String feedback;
    private int rate;
    private Date feedbackDate;
    private Time feedbackTime;

    public Feedback() {
    }

    public Feedback(String username, int movieId, String feedback, int rate, Date feedbackDate, Time feedbackTime) {
        this.username = username;
        this.movieId = movieId;
        this.feedback = feedback;
        this.rate = rate;
        this.feedbackDate = feedbackDate;
        this.feedbackTime = feedbackTime;
    }

    public Feedback(int feedbackId, String username, int movieId, String feedback, int rate) {
        this.feedbackId = feedbackId;
        this.username = username;
        this.movieId = movieId;
        this.feedback = feedback;
        this.rate = rate;
    }

    public Feedback(int feedbackId, String username, int movieId, String feedback, int rate, Date feedbackDate, Time feedbackTime) {
        this.feedbackId = feedbackId;
        this.username = username;
        this.movieId = movieId;
        this.feedback = feedback;
        this.rate = rate;
        this.feedbackDate = feedbackDate;
        this.feedbackTime = feedbackTime;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public Time getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Time feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

}
