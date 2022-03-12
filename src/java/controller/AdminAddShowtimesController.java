/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.IMovieDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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
public class AdminAddShowtimesController extends HttpServlet {
    
    IShowtimesDAO showtimesDao = new ShowtimesDAO();
    IMovieDAO movieDao = new MovieDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String movieId1 = request.getParameter("movieId");
        if (movieId1 == null) {
            movieId1 = "0";
        }
        int movieId = Integer.parseInt(movieId1);
//        int movieId = Integer.parseInt(request.getParameter("movieId"));
        Movie movie = movieDao.getMovieById(movieId);
        request.setAttribute("movie", movie);

        // Lead to AdminAddBanner.jsp
        request.getRequestDispatcher("AdminAddShowtimes.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //int movieRoomId = Integer.parseInt(request.getParameter("movieRoomId"));
        Date premiere = Date.valueOf(request.getParameter("premiere"));
        Time time = Time.valueOf(request.getParameter("time"));
        
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        
        MovieRoom1 movieRoom = new MovieRoom1();
        //movieRoom.setMovieRoomId(movieRoomId);
        movieRoom.setPremiere(premiere);
        movieRoom.setTime(time);
        movieRoom.setMovieId(movieId);
        movieRoom.setRoomId(roomId);

//        String mess = "";
//        if (Validate.checkPhone(movieRoom.toString()) == false) {
//            mess = "Showtimes đã tồn tại";
//        } else {
//            showtimesDao.addShowtimes(movieRoom);
//            response.sendRedirect(request.getContextPath() + "/adminshowtimeslist");
//        }
//        List<MovieRoom> movieRoomList = showtimesDao.getTimeById(movieId);
//        Movie movie = movieDao.getMovieById(movieId);
//
//        if (!mess.equals("")) {
//            request.setAttribute("mess", mess);
//            request.setAttribute("movie", movie);
//            request.setAttribute("movieRoomList", movieRoomList);
//            request.getRequestDispatcher("AdminAddShowtimes.jsp").forward(request, response);
//        }
        showtimesDao.addShowtimes(movieRoom);
        response.sendRedirect(request.getContextPath() + "/adminshowtimeslist");
        
    }
}
