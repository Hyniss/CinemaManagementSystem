/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BannerDAO;
import dao.IBannerDAO;
import dao.IMovieDAO;
import dao.INotificationAccountDAO;
import dao.INotificationDAO;
import dao.IPromotionDAO;
import dao.impl.MovieDAO;
import dao.impl.NotificationAccountDAO;
import dao.impl.NotificationDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Banner;
import model.Movie;
import model.Notification;
import model.NotificationAccount;
import model.Promotion;

/**
 * Documentation : HomeController Created on : 09-Feb-2022, 00:20:55
 *
 * @author Bảo Châu Bống
 */
// The main screen for the users
public class HomeController extends HttpServlet {

    // Calling method of database
    IMovieDAO movieDao = new MovieDAO();
    IBannerDAO bannerDao = new BannerDAO();
    IPromotionDAO promotionDao = new PromotionDAO();
    INotificationAccountDAO notificationaccountDAO = new NotificationAccountDAO();
    INotificationDAO notificationDAO = new NotificationDAO();

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

        //get account from session and load it's notification from database
        HttpSession session = request.getSession();
        if (session.getAttribute("acc") != null) {
            Account account = (Account) session.getAttribute("acc");

            //GET NOTIFICATION
            ArrayList<NotificationAccount> notificationaccountList = notificationaccountDAO.get5Notification(account.getUsername());
            request.setAttribute("notificationaccountList", notificationaccountList);

            HashMap<Notification, NotificationAccount> notiHashMap = new HashMap<>();
            ArrayList<Notification> notificationList = new ArrayList<Notification>();
            int unreadednoti = 0;
            for (NotificationAccount notificationAccount : notificationaccountList) {
                Notification noti = notificationDAO.getNotificationById(notificationAccount.getNotificationId());
                notiHashMap.put(noti, notificationAccount);
                if (!notificationAccount.isReaded()) {
                    unreadednoti++;
                }
            }

            //store into session
            session.setAttribute("notiHashMap", notiHashMap);
            session.setAttribute("unreadednoti", unreadednoti);
        }

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
