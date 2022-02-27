/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IFoodDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package dao;

import java.util.ArrayList;
import model.Feedback;

/**
 * This is the interface class that declares the methods to access the data of
 * the Feedback object Abstract method getAllFeedback used to retrieve all
 * feedback
 *
 *
 * @author Nguyen Nam
 */
public interface IFeedbackDAO {

    // List all feedback, pagging and sorting feedback
    public ArrayList<Feedback> getAllFeedbackPaggingAndSorting(int pageIndex, int pageSize, int sortId);

    public int countTotalFeedback();// count all feedback from database

    public boolean addFeeback(Feedback feedback);//add object into database

    public boolean updateFeeback(Feedback feedback);//update object into database

    public boolean deleteFeeback(int feedbackId);//remove object into database
}
