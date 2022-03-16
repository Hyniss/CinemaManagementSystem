/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * AdminListMovieRoom
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.IMovieDAO;
import dao.IMovieTimeDAO;
import dao.IRoomDAO;
import dao.IShowtimesDAO;
import dao.ITimeRoomDAO;
import dao.impl.MovieDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.RoomDAO;
import dao.impl.ShowtimesDAO;
import dao.impl.TimeRoomDAO;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import model.MovieRoom;
import model.MovieTime;
import model.Room;
import model.TimeRoom;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list movie room
 * /adminListMovieRoom is the URL of the web site Extend HttpServlet
 * class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "AdminListMovieRoom", urlPatterns = {"/adminListMovieRoom"})
public class AdminListMovieRoom extends HttpServlet {

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
        IRoomDAO roomDAO = new RoomDAO();
        ITimeRoomDAO timeRoomDAO = new TimeRoomDAO();
        IShowtimesDAO showtimesDAO = new ShowtimesDAO();
        IMovieTimeDAO movieTimeDAO = new MovieTimeDAO();
        IMovieDAO movieDAO = new MovieDAO();

        int movieRoomId = 0;
        try {
            movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminListMovieRoom.class.getName()).log(Level.SEVERE, null, e);
        }
        ZoneId zid = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDate ld = LocalDate.now(zid);
        Date currentDate = Date.valueOf(ld);

        MovieRoom movieRoom = showtimesDAO.getShowtimes(movieRoomId);
        ArrayList<Room> listRoom = roomDAO.getAllRoom();
        ArrayList<MovieRoom> listDate = showtimesDAO.getAllDate();
        ArrayList<MovieTime> listTime = movieTimeDAO.getMovieByMovieRoomId(movieRoomId);
        ArrayList<MovieTime> listTimeChoose = movieTimeDAO.getMovieByMovieRoomIdAndAdd(movieRoomId);
        ArrayList<Movie> listMovie = movieDAO.getAllMovie();
        ArrayList<TimeRoom> listTimeRoom = timeRoomDAO.getAllTimeRoomByMovieRoom(movieRoomId);

        request.setAttribute("listTime", listTime);
        request.setAttribute("listTimeChoose", listTimeChoose);
        request.setAttribute("listRoom", listRoom);
        request.setAttribute("listDate", listDate);
        request.setAttribute("movieRoom", movieRoom);
        request.setAttribute("listMovie", listMovie);
        request.setAttribute("currentDate",currentDate);
        request.setAttribute("listTimeRoom", listTimeRoom);

        request.getRequestDispatcher("AdminListMovieRoom.jsp").forward(request, response);
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
