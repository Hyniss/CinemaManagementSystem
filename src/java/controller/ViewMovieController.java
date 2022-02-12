/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

/**
 *
 * @author Bảo Châu Bống
 */
public class ViewMovieController extends HttpServlet {

    MovieDAO movieDao = new MovieDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Get moive and get request dispatcher to movie_detail.jsp
        int mid = Integer.parseInt(request.getParameter("mid"));
        Movie m = movieDao.getMovieById(mid);
        request.setAttribute("movie", m);
        request.getRequestDispatcher("MovieDetail.jsp").forward(request, response);
    }
}
