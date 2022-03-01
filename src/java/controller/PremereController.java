/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieDAO;
import dao.impl.MovieDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

/**
 * Documentation: PremereController
 * Created on : 12-Feb-2022, 13:34:08
 * @author Bảo Châu Bống
 */

// The list of movie currently showing

public class PremereController extends HttpServlet {

    // Calling method of database
    IMovieDAO movieDao = new MovieDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from database and transfer in parameter
        ArrayList<Movie> moviePremere = movieDao.getMoviePremere();
        
        // Set Attribute
        request.setAttribute("moviePremere", moviePremere);
        
        // Lead to Premere.jsp
        request.getRequestDispatcher("Premere.jsp").forward(request, response);
    }
}
