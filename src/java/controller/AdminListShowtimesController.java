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
public class AdminListShowtimesController extends HttpServlet {

    IShowtimesDAO showtimesDao = new ShowtimesDAO();
    IMovieDAO movieDao = new MovieDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        List<MovieRoom1> movieRoomList = showtimesDao.getAllShowtimes();
        String movieId1 = request.getParameter("movieId");
        if (movieId1 == null) {
            movieId1 = "0";
        }
        int movieId = Integer.parseInt(movieId1);
        Movie movie = movieDao.getMovieById(movieId);
        request.setAttribute("movie", movie);
        request.setAttribute("movieRoomList", movieRoomList);
        request.getRequestDispatcher("AdminListShowtimes.jsp").forward(request, response);

    }
}
