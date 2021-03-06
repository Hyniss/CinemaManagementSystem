/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * AdminUpdateListTime
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.IMovieTimeDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MovieRoom;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list movie room
 * /updateListTime is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AdminUpdateListTime", urlPatterns = {"/updateListTime"})
public class AdminUpdateListTime extends HttpServlet {

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
        IShowtimesDAO showtimesDAO = new ShowtimesDAO();
        IMovieTimeDAO movieTimeDAO = new MovieTimeDAO();
        String movieRoomTxt = request.getParameter("movieRoomId");
        String datetxt = request.getParameter("datetxte");
        String[] slot = request.getParameterValues("slot");
        int movieRoomId = 0;
        Date date = null;
        Time start;
        Time end;
        boolean edit = false;
        
        try {
            movieRoomId = Integer.parseInt(movieRoomTxt);
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            date = Date.valueOf(datetxt);
        } catch (Exception e) {
            Logger.getLogger(AdminListTime.class.getName()).log(Level.SEVERE, null, e);
        }
        /*update date*/
        MovieRoom movieRoom = showtimesDAO.getShowtimes(movieRoomId);
        if (!movieRoom.getPremiere().equals(date)) {
            movieRoom = new MovieRoom(movieRoomId, date);
            showtimesDAO.editShowtimes(movieRoom);
        }
        /*update slot*/
        if (slot != null) {
            for (int i = 0; i < slot.length; i++) {
                if (slot[i].equals("1")) {
                    start = Time.valueOf("08:00:00");
                    end = Time.valueOf("10:00:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot1", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("08:00:00");
                    end = Time.valueOf("10:00:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot1", "no");
                }
                if (slot[i].equals("2")) {
                    start = Time.valueOf("10:10:00");
                    end = Time.valueOf("12:10:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot2", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("10:10:00");
                    end = Time.valueOf("12:10:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot2", "no");
                }
                if (slot[i].equals("3")) {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot3", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot3", "no");
                }
                if (slot[i].equals("4")) {
                    start = Time.valueOf("14:30:00");
                    end = Time.valueOf("16:30:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot4", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot4", "no");
                }
                if (slot[i].equals("5")) {
                    start = Time.valueOf("16:40:00");
                    end = Time.valueOf("18:40:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot5", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId, "slot5", "no");
                }
                if (slot[i].equals("6")) {
                    start = Time.valueOf("18:50:00");
                    end = Time.valueOf("20:50:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot6", "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    edit=movieTimeDAO.editMovieTime(start, end, movieRoomId,"slot6", "no");
                }
                break;
            }
        } else {
            int index = 0;
            for (int i = 0; i < 6; i++) {
                index++;
                edit=movieTimeDAO.editMovieTimeSlot(movieRoomId,"no");
            }
        }
        request.setAttribute("edit", edit);
        request.getRequestDispatcher("adminListTime").forward(request, response);
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
