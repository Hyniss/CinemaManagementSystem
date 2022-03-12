/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieTimeDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MovieRoom;
import model.MovieTime;

/**
 *
 * @author tenhik
 */
@WebServlet(name = "AdminViewUpdateListTime", urlPatterns = {"/viewUpdateListTime"})
public class AdminViewUpdateListTime extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            IMovieTimeDAO movieTimeDAO = new MovieTimeDAO();
            IShowtimesDAO showtimesDAO = new ShowtimesDAO();
            String view = request.getParameter("view");
            String getMovieRoomId = request.getParameter("movieRoomId");
            int movieRoomId = 0;
            try {
                movieRoomId = Integer.parseInt(getMovieRoomId);
            } catch (NumberFormatException e) {
                Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
            }
            ArrayList<MovieTime> listTime = movieTimeDAO.getMovieByMovieRoomId(movieRoomId);
            MovieRoom movieRoom = showtimesDAO.getShowtimes(movieRoomId);

            request.setAttribute("listTimeMovieRoom", listTime);
            request.setAttribute("movieRoom", movieRoom);
            request.setAttribute("view", view);
            request.getRequestDispatcher("adminListTime").forward(request, response);
        }
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
