/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieDAO;
import dao.IMovieDateDAO;
import dao.IMovieRoomDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieDAO;
import dao.impl.MovieDateDAO;
import dao.impl.MovieRoomDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.sql.Date;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MovieDate;
import model.MovieRoom;

/**
 *
 * @author Bảo Châu Bống
 */
public class ShowtimesController extends HttpServlet {

    IShowtimesDAO showtimesDao = new ShowtimesDAO();
    IMovieDAO movieDAO = new MovieDAO();
    IMovieRoomDAO movieRoomDao = new MovieRoomDAO();
    IMovieDateDAO movieDateDao = new MovieDateDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

//        String date = request.getParameter("premiere");
////        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
////        //LocalDate dNow = java.time.LocalDate.parse(date1);
////        Calendar c1 = Calendar.getInstance();
//        Calendar c2 = Calendar.getInstance();
////        
////        // ngày hôm nay
//        LocalDateTime current = LocalDateTime.now();
//        Date oldDate = Date.from(current.atZone(ZoneId.systemDefault()).toInstant());
////        
////        c1.setTime(date1);
//        c2.setTime(oldDate);
////        
//        request.setAttribute("oldDate", oldDate);
//
//        String movie = request.getParameter("movieId");
//        if (movie == null) {
//            movie = "1";
//        }
//
//        int movieId = Integer.parseInt(movie);
//        List<MovieRoom1> movieList = new ArrayList<>();
//        ArrayList<MovieRoom1> movieRoom = showtimesDao.getTimeByDate(date);
//        ArrayList<MovieRoom1> showtimes = showtimesDao.getAllShowtimes();
//        ArrayList<MovieRoom1> showtime = showtimesDao.getTimeById(movieId);
//        ArrayList<MovieRoom1> test = showtimesDao.getTimeByDateAndId(movieId, date);
//        // List<Movie> listMovie = movieDAO.getAllMovie();
//        //request.setAttribute("listMovie1, listMovie);
        String movieRoomId1 = request.getParameter("movieRoomId");
        if (movieRoomId1 == null) {
            movieRoomId1 = "1";
        }
        String movieId1 = request.getParameter("movieId");
        if (movieId1 == null) {
            movieId1 = "1";
        }
////        int movieId1 = Integer.parseInt(movie);
//        int mid = 0;
//        String movieId1 = request.getParameter("mid");
//        try {
//            mid = Integer.parseInt(movieId1);
//        } catch (NumberFormatException ex) {
//            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Movie m = movieDAO.getMovieById(mid);
//        //request.setAttribute("listMovie", listMovie);
//
//        request.setAttribute("movie", m);
//        request.setAttribute("movieList", movieList);
//        request.setAttribute("test", test);
//        request.setAttribute("showtime", showtime);
//        request.setAttribute("showtimes", showtimes);
//        request.setAttribute("movieRoom", movieRoom);

       
        int movieRoomId = Integer.parseInt(movieRoomId1);
        int movieId = Integer.parseInt(movieId1);
        String premiere = request.getParameter("premiere");
        //Date premiere1 = Date.valueOf(premiere);
        ArrayList<MovieRoom> movieRoom = movieRoomDao.getAllMovieRoom();
        ArrayList<MovieRoom> movieRoom1 = movieRoomDao.getListById(movieRoomId);
        ArrayList<MovieRoom> movieRoom2 = movieRoomDao.getByMovieId(movieId);
        ArrayList<MovieDate> movieDate = movieDateDao.getAllMovieDate();// cái này làm j có tham số mà m truyền về
        ArrayList<MovieDate> movieDate1 = movieDateDao.getDateById(movieRoomId);
        ArrayList<MovieRoom> test = movieRoomDao.getTimeByDateAndId(movieId, premiere, movieRoomId);
        ArrayList<MovieDate> check = movieDateDao.getId(movieRoom);

        request.setAttribute("check", check);
        request.setAttribute("test", test);
        request.setAttribute("movieRoom", movieRoom);
        request.setAttribute("movieRoom1", movieRoom1);
        request.setAttribute("movieRoom2", movieRoom2);
        request.setAttribute("movieDate", movieDate);
        request.setAttribute("movieDate1", movieDate1);
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
