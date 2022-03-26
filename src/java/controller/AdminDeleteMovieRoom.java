/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * AdminDeleteMovieRoom
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.ITimeRoomDAO;
import dao.impl.TimeRoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * /adminDeleteMovieRoom is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AdminDeleteMovieRoom", urlPatterns = {"/adminDeleteMovieRoom"})
public class AdminDeleteMovieRoom extends HttpServlet {

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
        ITimeRoomDAO timeRoomDAO = new TimeRoomDAO();
        boolean delete = false;
        int timeRoomId = 0;
        int movieRoomId = 0;

        try {
            timeRoomId = Integer.parseInt(request.getParameter("timeRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminUpdateMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminViewModalMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }

        delete = timeRoomDAO.deleteTimeRoom(timeRoomId);
        request.setAttribute("movieRoomId", movieRoomId);
        request.setAttribute("delete",delete);
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
