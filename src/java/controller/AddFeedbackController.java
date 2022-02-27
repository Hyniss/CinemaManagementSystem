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
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
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
 * add the feedback 
 * /add-feedback is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AddFeedbackController", urlPatterns = {"/add-feedback"})
public class AddFeedbackController extends HttpServlet {

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
        //Using for vietnamese
        request.setCharacterEncoding("UTF-8");
        IFeedbackDAO feedbackDAO = new FeedbackDAO();
        /*get all value*/
        String username = request.getParameter("username");
        String movieId = request.getParameter("mid");
        String rate = request.getParameter("rating");
        String reviewMess = request.getParameter("reviewmess");
        
        int mid = 0;
        int rating = 0;
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
        /*Get local date and time*/
        ZoneId zid = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDate ld = LocalDate.now(zid);
        LocalTime lt = LocalTime.now(zid);
        Date date = Date.valueOf(ld);
        Time time = Time.valueOf(lt);
        Feedback feedback = new Feedback(username, mid, review, rating, date, time);
        /*call add function*/
        boolean add  = feedbackDAO.addFeeback(feedback);
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
