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
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tenhik
 */
@WebServlet(name = "AdminAddListTime", urlPatterns = {"/AddListTime"})
public class AdminAddListTime extends HttpServlet {

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

        String datetxt = request.getParameter("datetxta");
        Date date = null;
        Time start;
        Time end;
        try {
            date = Date.valueOf(datetxt);
        } catch (Exception e) {
            Logger.getLogger(AdminListTime.class.getName()).log(Level.SEVERE, null, e);
        }

        int movieRoomId = showtimesDAO.addShowtimes(date);
        String[] slot = request.getParameterValues("slot");

        if (slot != null) {
            for (int i = 0; i < slot.length; i++) {
                if (slot[i].equals("1")) {
                    start = Time.valueOf("08:00:00");
                    end = Time.valueOf("10:00:00");
                    movieTimeDAO.addMovieTime("slot1", start, end, movieRoomId, "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("08:00:00");
                    end = Time.valueOf("10:00:00");
                    movieTimeDAO.addMovieTime("slot1", start, end, movieRoomId, "no");
                }
                if (slot[i].equals("2")) {
                    start = Time.valueOf("10:10:00");
                    end = Time.valueOf("12:10:00");
                    movieTimeDAO.addMovieTime("slot2", start, end, movieRoomId, "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("10:10:00");
                    end = Time.valueOf("12:10:00");
                    movieTimeDAO.addMovieTime("slot2", start, end, movieRoomId, "no");
                }
                if (slot[i].equals("3")) {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    movieTimeDAO.addMovieTime("slot3", start, end, movieRoomId, "yes");

                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("12:20:00");
                    end = Time.valueOf("14:20:00");
                    movieTimeDAO.addMovieTime("slot3", start, end, movieRoomId, "no");
                }
                if (slot[i].equals("4")) {
                    start = Time.valueOf("14:30:00");
                    end = Time.valueOf("16:30:00");
                    movieTimeDAO.addMovieTime("slot4", start, end, movieRoomId, "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("14:30:00");
                    end = Time.valueOf("16:30:00");
                    movieTimeDAO.addMovieTime("slot4", start, end, movieRoomId, "no");
                }
                if (slot[i].equals("5")) {
                    start = Time.valueOf("16:40:00");
                    end = Time.valueOf("18:40:00");
                    movieTimeDAO.addMovieTime("slot5", start, end, movieRoomId, "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("16:40:00");
                    end = Time.valueOf("18:40:00");
                    movieTimeDAO.addMovieTime("slot5", start, end, movieRoomId, "no");
                }
                if (slot[i].equals("6")) {
                    start = Time.valueOf("18:50:00");
                    end = Time.valueOf("20:50:00");
                    movieTimeDAO.addMovieTime("slot6", start, end, movieRoomId, "yes");
                    if (i < slot.length - 1) {
                        i++;
                    }
                } else {
                    start = Time.valueOf("18:50:00");
                    end = Time.valueOf("20:50:00");
                    movieTimeDAO.addMovieTime("slot6", start, end, movieRoomId, "no");
                }
                break;
            }
        } else {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                count++;
                movieTimeDAO.addMovieTimeSlot("slot" + count, movieRoomId, "no");
            }
        }
        response.sendRedirect("adminListTime");
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
