/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDAO;
import dao.IBannerDAO;
import dao.IMovieDAO;
import dao.IPromotionDAO;
import dao.MovieDAO;
import dao.PromotionDAO;
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
 *
 * @author Bảo Châu Bống
 */
public class HomeController extends HttpServlet {

    IMovieDAO movieDao = new MovieDAO();
    IBannerDAO bannerDao = new BannerDAO();
    IPromotionDAO promotionDao = new PromotionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("Homepage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // SHOW THE LIST OF MOVIE
        ArrayList<Movie> listMovie = movieDao.getAllMovie();
        request.setAttribute("listMovie", listMovie);

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

        request.getRequestDispatcher("Homepage.jsp").forward(request, response);
    }
}
