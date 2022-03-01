/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * ViewFoodController
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Thái Trần    First Implement
 */
package controller;

import dao.impl.FeedbackDAO;
import dao.IFeedbackDAO;
import dao.impl.MovieDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Feedback;
import model.Movie;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the detail info of the movie
 * /movie is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Thái Trần
 */
public class ViewMovieController extends HttpServlet {

    MovieDAO movieDao = new MovieDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        IFeedbackDAO feedbackDAO = new FeedbackDAO();
        /*Get movie*/
        int mid = 0;
        String movieId = request.getParameter("mid");
         try {
           mid  = Integer.parseInt(movieId);
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        /*Pagging and sorting feedback*/
        int sortId = 0;
        int pageIndex = 1;
        int pageSize = 8;
        int totalFeedback = feedbackDAO.countTotalFeedback();
        int totalPage = 0;
        int page = 0;
        try {
            sortId = Integer.parseInt(request.getParameter("sortId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        /*pagging*/
        if (totalFeedback > 0) {
            page = totalFeedback % pageSize;
            totalPage = totalFeedback / pageSize;
            if (page == 0) {
                totalPage += 0;
            } else {
                totalPage += 1;
            }
        }
        int next = pageIndex + 1;
        int back = pageIndex - 1;
        Movie m = movieDao.getMovieById(mid);
        ArrayList<Feedback> listFeedback = feedbackDAO.getAllFeedbackPaggingAndSorting(pageIndex, pageSize, sortId);
        /*Attach attribute and redirect it to MovieDetail.jsp*/
        request.setAttribute("next", next);
        request.setAttribute("back", back);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("listFeedback", listFeedback);
        request.setAttribute("sortId", sortId);
        request.setAttribute("movie", m);
        request.getRequestDispatcher("MovieDetail.jsp").forward(request, response);
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
