/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * AdminViewModalMovieRoom
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list movie room
 * /adminViewModalMovieRoom is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AdminViewModalMovieRoom", urlPatterns = {"/adminViewModalMovieRoom"})
public class AdminViewModalMovieRoom extends HttpServlet {

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
        int movieRoomId = 0;
        int timeId = 0;
        int timeRoomId = 0;
        int movieId = 0;

        String roomId = request.getParameter("roomId");
        String viewAdd = request.getParameter("viewAdd");
        String viewUpdate = request.getParameter("viewUpdate");

        try {
            movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminViewModalMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            timeId = Integer.parseInt(request.getParameter("timeId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminViewModalMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            timeRoomId = Integer.parseInt(request.getParameter("timeRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminViewModalMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            movieId = Integer.parseInt(request.getParameter("movieId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminViewModalMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }

        request.setAttribute("addMovieRoomId", movieRoomId);
        request.setAttribute("addTimeId", timeId);
        request.setAttribute("addRoomId", roomId);
        request.setAttribute("addTimeRoomId", timeRoomId);
        if(movieId !=0) {
        request.setAttribute("movieId", movieId);
        }
        request.setAttribute("viewAdd", viewAdd);
        request.setAttribute("viewUpdate", viewUpdate);
        request.getRequestDispatcher("adminListMovieRoom").forward(request, response);
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
