/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import model.MovieRoom1;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminEditShowtimesController extends HttpServlet {

    IShowtimesDAO showtimesDao = new ShowtimesDAO();
    IMovieDAO movieDao = new MovieDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

//        String movieId1 = request.getParameter("movieId");
//        if (movieId1 == null) {
//            movieId1 = "0";
//        }
//        int movieId = Integer.parseInt(movieId1);
////        int movieId = Integer.parseInt(request.getParameter("movieId"));
//        Movie movie = movieDao.getMovieById(movieId);
//        request.setAttribute("movie", movie);

//        String movieRoomId1 = request.getParameter("movieRoomId");
//        if (movieRoomId1 == null) {
//            movieRoomId1 = "0";
//        }
//        int movieRoomId = Integer.parseInt(movieRoomId1);

        int movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        // String movieName = request.getParameter("movieName");
//        ArrayList<Movie> movie = movieDao.getMovieById("movieId");
//        ArrayList<MovieRoom> movieRoom = showtimesDao.getTimeById(movieId);
//        request.setAttribute("movie", movie);
//        request.setAttribute("movieRoom", movieRoom);
        MovieRoom1 movieRoom = showtimesDao.get(movieRoomId);
        request.setAttribute("movieRoom", movieRoom);
        request.getRequestDispatcher("AdminEditShowtimes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

//        String movieRoomId1 = request.getParameter("movieRoomId");
//        if (movieRoomId1 == null) {
//            movieRoomId1 = "0";
//        }
//        int movieRoomId = Integer.parseInt(movieRoomId1);
//
//        Date premiere = Date.valueOf(request.getParameter("premiere"));
//        Time time = Time.valueOf(request.getParameter("time"));
//
//        int movieId = Integer.parseInt(request.getParameter("movieId"));
//        int roomId = Integer.parseInt(request.getParameter("roomId"));
//
//        MovieRoom1 movieRoom = new MovieRoom1();
//        movieRoom.setMovieRoomId(movieRoomId);
//        movieRoom.setPremiere(premiere);
//        movieRoom.setTime(time);
//        movieRoom.setMovieId(movieId);
//        movieRoom.setRoomId(roomId);
        MovieRoom1 movieRoom = new MovieRoom1();
        movieRoom.setMovieRoomId(Integer.parseInt(request.getParameter("new_movieRoomId")));
        movieRoom.setMovieId(Integer.parseInt(request.getParameter("new_movieId")));
        movieRoom.setPremiere(Date.valueOf(request.getParameter("new_premiere")));
        movieRoom.setTime(Time.valueOf("new_time"));
        movieRoom.setRoomId(Integer.parseInt(request.getParameter("new_roomId")));
        showtimesDao.editShowtimes(movieRoom);
        response.sendRedirect(request.getContextPath() + "/adminshowtimeslist");
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
