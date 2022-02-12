/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

/**
 *
 * @author Bảo Châu Bống
 */
public class PremereController extends HttpServlet {

    MovieDAO movieDao = new MovieDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // SHOW THE LIST OF MOVIE SHOWING NOW
        ArrayList<Movie> moviePremere = movieDao.getMoviePremere();
        request.setAttribute("moviePremere", moviePremere);
        request.getRequestDispatcher("Premere.jsp").forward(request, response);
    }
}
