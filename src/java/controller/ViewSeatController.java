/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * ViewSeatController
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.IMovieDAO;
import dao.IMovieRoomDAO;
import dao.IMovieTimeDAO;
import dao.IRoomDAO;
import dao.ISeatRoomDAO;
import dao.ITimeRoomDAO;
import dao.impl.MovieDAO;
import dao.impl.MovieRoomDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.RoomDAO;
import dao.impl.SeatRoomDAO;
import dao.impl.TimeRoomDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Movie;
import model.MovieRoom;
import model.MovieTime;
import model.Room;
import model.SeatRoom;
import model.TimeRoom;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the seat map /seat is the URL of the web site Extend HttpServlet class
 *
 * @author Nguyen Nam
 */
public class ViewSeatController extends HttpServlet {

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
        IMovieDAO movieDAO = new MovieDAO();
        IMovieRoomDAO movieRoomDAO = new MovieRoomDAO();
        IMovieTimeDAO movieTimeDAO = new MovieTimeDAO();
        ISeatRoomDAO seatRoomDAO = new SeatRoomDAO();
        ITimeRoomDAO timeRoomDAO = new TimeRoomDAO();
        IRoomDAO roomDAO = new RoomDAO();

        HttpSession session = request.getSession();// create session

        int movieRoomId = 0;
        int movieId = 0;
        int timeId = 0;

        String roomId = request.getParameter("roomId");
        try {
            movieId = Integer.parseInt(request.getParameter("movieId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            timeId = Integer.parseInt(request.getParameter("time"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        if (movieRoomId == 0 || timeId == 0) {
            response.sendRedirect("showtimes?movieId=" + movieId);
        }
        Room room = roomDAO.room(roomId);
        Movie movie = movieDAO.getMovieById(movieId);
        MovieRoom movieRoom = movieRoomDAO.getMovieRoomById(movieRoomId);
        MovieTime movieTime = movieTimeDAO.getMovieTime(timeId);
        TimeRoom timeroom = timeRoomDAO.getTimeRoomByTimeAndRoom(timeId, roomId, movieId);
        ArrayList<SeatRoom> listSeatBooked = seatRoomDAO.getSeatRoomByTimeIdAndMovieId(timeId,roomId,movieId, movieRoomId);
        request.setAttribute("listSeatBooked", listSeatBooked);
        session.setAttribute("movieTime", movieTime);
        session.setAttribute("movieRoom", movieRoom);
        session.setAttribute("movie", movie);
        session.setAttribute("room", room);
        session.setAttribute("timeRoom", timeroom);
        /*Attach attribute subjects for request and redirect it to Seat.jsp*/
        request.getRequestDispatcher("Seat.jsp").forward(request, response);
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
