/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieDAO;
import dao.IMovieRoomDAO;
import dao.IMovieTimeDAO;
import dao.IRoomDAO;
import dao.ITimeRoomDAO;
import dao.impl.MovieDAO;
import dao.impl.MovieRoomDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.RoomDAO;
import dao.impl.TimeRoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.mail.search.DateTerm;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import model.MovieRoom;
import model.MovieTime;
import model.Room;
import model.TimeRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public class ShowtimesController extends HttpServlet {

    IMovieDAO movieDao = new MovieDAO();
    IMovieRoomDAO movieRoomDao = new MovieRoomDAO();
    IMovieTimeDAO movieTimeDao = new MovieTimeDAO();
    ITimeRoomDAO timeRoomDao = new TimeRoomDAO();
    IRoomDAO roomDao = new RoomDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String movieRoomId1 = request.getParameter("movieRoomId");
        if (movieRoomId1 == null) {
            movieRoomId1 = "1";
        }
        String movieId1 = request.getParameter("movieId");
        if (movieId1 == null) {
            movieId1 = "1";
        }
        String timeId1 = request.getParameter("timeId");
        if (timeId1 == null) {
            timeId1 = "1";
        }

        int movieRoomId = Integer.parseInt(movieRoomId1);
        int movieId = Integer.parseInt(movieId1);
        int timeId = Integer.parseInt(timeId1);
        String roomId = request.getParameter("roomId");
        String roomName = request.getParameter("roomName");
        ArrayList<MovieRoom> movieRoom = movieRoomDao.getAllMovieRoom();
        ArrayList<MovieTime> movieTime = movieTimeDao.getAllMovieTime();
        ArrayList<MovieTime> movieTime1 = new ArrayList<>();
        ArrayList<Room> room = roomDao.getAllRoom();
        Movie movie = movieDao.getMovieById(movieId);

        /*Get local date and time*/
        ZoneId zid = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDate ld = LocalDate.now(zid);
        Date date = Date.valueOf(ld);
        MovieRoom movieRoom1 = movieRoomDao.getMovieRoomByDate(date);
        if (movieRoom1 != null) {
            movieRoomId = movieRoom1.getMovieRoomId();
            movieTime1 = movieTimeDao.getId(movieId, movieRoomId, roomId);
        }

        request.setAttribute("movie", movie);
        request.setAttribute("movieId", movieId);
        request.setAttribute("movieRoom", movieRoom);
        request.setAttribute("movieTime", movieTime);
//        request.setAttribute("timeRoom", timeRoom);
//        request.setAttribute("timeRoom1", timeRoom1);
        request.setAttribute("movieTime1", movieTime1);
        //request.setAttribute("movieRoom1", movieRoom1);
        request.setAttribute("room", room);
        request.setAttribute("movieRoomId", movieRoomId);
        request.setAttribute("roomName", roomName);
        request.getRequestDispatcher("Showtimes.jsp").forward(request, response);

    }

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
