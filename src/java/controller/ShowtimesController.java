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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String roomName = request.getParameter("roomName");
        ArrayList<MovieRoom> movieRoom = movieRoomDao.getAllMovieRoom();
        ArrayList<MovieTime> movieTime = movieTimeDao.getAllMovieTime();
        ArrayList<TimeRoom> timeRoom1 = timeRoomDao.getByMovieId(movieId);
        ArrayList<Room> room = roomDao.getAllRoom();
        Movie movie = movieDao.getMovieById(movieId);
        

        request.setAttribute("movie", movie);
        request.setAttribute("movieId", movieId);
        request.setAttribute("movieRoom", movieRoom);
        request.setAttribute("movieTime", movieTime);
        request.setAttribute("timeRoom1", timeRoom1);
        request.setAttribute("room", room);
        request.setAttribute("movieRoomId", movieRoomId);
        request.setAttribute("roomName", roomName);
        request.getRequestDispatcher("Showtimes.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         HttpSession session = request.getSession();
           //remove all session
        session.removeAttribute("listcheckedSeatId");
        session.removeAttribute("listFoodCarts");
        session.removeAttribute("timeRoom");
        session.removeAttribute("movieTime");
        session.removeAttribute("movieRoom");
        session.removeAttribute("movie");
        session.removeAttribute("room");
        session.removeAttribute("quantitySeat");
        session.removeAttribute("totalSeatPrice");
        session.removeAttribute("totalFoodPrice");
        session.removeAttribute("totalPrice");
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
