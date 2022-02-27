/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * Interface IFoodDAO
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.FeedbackDAO;
import dao.IFeedbackDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * edit the feedback 
 * /edit-feedback is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "EditFeedbackController", urlPatterns = {"/edit-feedback"})
public class EditFeedbackController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        IFeedbackDAO feedbackDAO = new FeedbackDAO();
        /*using for vietnamese*/
        request.setCharacterEncoding("UTF-8");
        /*get all value*/
        String feedId = request.getParameter("feedbackId");
        String username = request.getParameter("username");
        String movieId = request.getParameter("mid");
        String rate = request.getParameter("rating");
        String messParam = "mess" + feedId;
        String reviewMess = request.getParameter(messParam);

        int feedbackId = 0;
        int mid = 0;
        int rating = 0;
        try {
            feedbackId = Integer.parseInt(feedId);
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            mid = Integer.parseInt(movieId);
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rating = Integer.parseInt(rate);
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        String review = reviewMess.replaceAll("\\s+", " ").trim();
        Feedback feedback = new Feedback(feedbackId, username, mid,review, rating);
        /*call update function*/
        boolean edit = feedbackDAO.updateFeeback(feedback);
        /*Attach attribute and redirect it to movie with id*/
        request.setAttribute("mid", mid);
        request.getRequestDispatcher("movie").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
