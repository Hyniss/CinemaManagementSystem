/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * AdminUpdateMovieRoom
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.ITimeRoomDAO;
import dao.impl.TimeRoomDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TimeRoom;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list movie room /adminUpdateMovieRoom is the URL of the web site
 * Extend HttpServlet class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AdminUpdateMovieRoom", urlPatterns = {"/adminUpdateMovieRoom"})
public class AdminUpdateMovieRoom extends HttpServlet {

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

        boolean add = false;
        boolean edit = false;
        int movieRoomId = 0;
        int timeId = 0;
        int movieId = 0;
        int timeRoomId = 0;
        TimeRoom timeRoom;
        String roomId = request.getParameter("addRoomId");
        String function = request.getParameter("function");
        try {
            movieRoomId = Integer.parseInt(request.getParameter("addMovieRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminUpdateMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            timeId = Integer.parseInt(request.getParameter("addTimeId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminUpdateMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            movieId = Integer.parseInt(request.getParameter("addMovieId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminUpdateMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            timeRoomId = Integer.parseInt(request.getParameter("addTimeRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminUpdateMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        TimeRoom timeRoom1 = timeRoomDAO.getTimeRoomByMovieRoom(movieRoomId, roomId, timeId);
        if (function.equals("add")) {
            timeRoom = new TimeRoom(movieId, roomId, timeId);
            add = timeRoomDAO.addTimeRoom(timeRoom);
        } else if (function.equals("update")) {
            timeRoom = new TimeRoom(timeRoomId, movieId, roomId, timeId);
            if (timeRoom1 == null) {
                edit = timeRoomDAO.editTimeRoom(timeRoom);
            } else {
                if (timeRoom1.getRoomId().equals(roomId) && timeRoom1.getTimeId() == timeId) {
                    if (timeRoom1.getTimeRoomId() != timeRoomId) {
                        response.sendRedirect("adminUpdateMovieInRoom?movieRoomId=" + movieRoomId + "&timeId=" + timeId + "&roomId=" + roomId + "&addMovieId=" + movieId + "&timeRoomId=" + timeRoomId + "&viewUpdate=true&updateValid=wrong");
                        return;
                    } else {
                        edit = timeRoomDAO.editTimeRoom(timeRoom);
                    }
                } else {
                    edit = timeRoomDAO.editTimeRoom(timeRoom);
                }
            }
        }
        request.setAttribute("add", add);
        request.setAttribute("edit", edit);
        request.getRequestDispatcher("adminListMovieRoom?movieRoomId="+movieRoomId).forward(request, response);
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
