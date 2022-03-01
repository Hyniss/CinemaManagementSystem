/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BannerDAO;
import dao.IBannerDAO;
import dao.IMovieDAO;
import dao.IPromotionDAO;
import dao.impl.MovieDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;
import model.Movie;
import model.Promotion;

/**
 * Documentation : HomeController 
 * Created on : 09-Feb-2022, 00:20:55 
 * @author Bảo Châu Bống
 */

// The main screen for the users

public class HomeController extends HttpServlet {

    // Calling method of database
    IMovieDAO movieDao = new MovieDAO();
    IBannerDAO bannerDao = new BannerDAO();
    IPromotionDAO promotionDao = new PromotionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        
        // Lead to Homepage.jsp
        request.getRequestDispatcher("Homepage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // SHOW THE LIST OF MOVIE
        ArrayList<Movie> listTop8Movie = movieDao.getTop8Movie();
        request.setAttribute("listMovie", listTop8Movie);

        // SHOW THE LIST OF BANNER
        ArrayList<Banner> banners = bannerDao.getAllBanner();
        request.setAttribute("banners", banners);

        // SHOW THE LIST OF PROMOTION
        ArrayList<Promotion> promotions = promotionDao.getAllPromotion();
        request.setAttribute("promotions", promotions);

        // SHOW THE LIST OF MOVIE NOW PLAYING
        ArrayList<Movie> moviePremere = movieDao.getMoviePremere();
        request.setAttribute("moviePremere", moviePremere);

        // SHOW THE LIST OF MOVIE COMING SOON
        ArrayList<Movie> movieComing = movieDao.getMovieComing();
        request.setAttribute("movieComing", movieComing);

        // Lead to Homepage.jsp
        request.getRequestDispatcher("Homepage.jsp").forward(request, response);
    }
}
