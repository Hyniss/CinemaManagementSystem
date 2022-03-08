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
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public class ShowtimesController extends HttpServlet {

    IShowtimesDAO showtimesDao = new ShowtimesDAO();
    IMovieDAO movieDAO = new MovieDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String date = request.getParameter("premiere");
//        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//        //LocalDate dNow = java.time.LocalDate.parse(date1);
//        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
//        
//        // ngày hôm nay
        LocalDateTime current = LocalDateTime.now();
        Date oldDate = Date.from(current.atZone(ZoneId.systemDefault()).toInstant());
//        
//        c1.setTime(date1);
        c2.setTime(oldDate);
//        
        request.setAttribute("oldDate", oldDate);

        String movie = request.getParameter("movieId");
        if (movie == null) {
            movie = "1";
        }

        int movieId = Integer.parseInt(movie);
        List<MovieRoom> movieList = new ArrayList<>();
        ArrayList<MovieRoom> movieRoom = showtimesDao.getTimeByDate(date);
        ArrayList<MovieRoom> showtimes = showtimesDao.getAllShowtimes();
        ArrayList<MovieRoom> showtime = showtimesDao.getTimeById(movieId);
        ArrayList<MovieRoom> test = showtimesDao.getTimeByDateAndId(movieId, date);
        // List<Movie> listMovie = movieDAO.getAllMovie();
        //request.setAttribute("listMovie1, listMovie);
//        String movie1 = request.getParameter("movieId");
//        if (movie1 == null) {
//            movie1 = "1";
//        }
//        int movieId1 = Integer.parseInt(movie);
        int mid = 0;
        String movieId1 = request.getParameter("mid");
        try {
            mid = Integer.parseInt(movieId1);
        } catch (NumberFormatException ex) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Movie m = movieDAO.getMovieById(mid);
        //request.setAttribute("listMovie", listMovie);

        request.setAttribute("movie", m);
        request.setAttribute("movieList", movieList);
        request.setAttribute("test", test);
        request.setAttribute("showtime", showtime);
        request.setAttribute("showtimes", showtimes);
        request.setAttribute("movieRoom", movieRoom);
        request.getRequestDispatcher("Showtimes.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
