/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.ValidateMovie;
import dao.IMovieDAO;
import dao.MovieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

/**
 *
 * @author NITRO
 */
@WebServlet(name = "AdminAddMovieController", urlPatterns = {"/AdminAddMovie"})
public class AdminAddMovieController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddMovieController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddMovieController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); //có thể nhận dữ liệu là tiếng việt
        IMovieDAO movieDAO = new MovieDAO();

        //lấy ra các dữ liệu từ request 
        int movieId = Integer.parseInt(request.getParameter("movieID").trim());
        String movieName = request.getParameter("movieName").trim();
        String movieImage = request.getParameter("movieImage").trim();
        String movieCategory = request.getParameter("movieCategory").trim();
        String description = request.getParameter("movieDescription").trim();
        String movieTrailer = request.getParameter("movieTrailer").trim();
        String movieAuthor = request.getParameter("movieAuthor").trim();
        String movieActor = request.getParameter("movieActor").trim();
        String movieDuration = request.getParameter("movieDuration").trim();
        String moviePremiere = request.getParameter("moviePremiere");
        Date premiere = Date.valueOf(moviePremiere);//ep kieu du lieu cho date
        Movie movie = new Movie(movieId, movieName, movieImage, movieCategory, description, movieTrailer, movieAuthor, movieActor, movieDuration, premiere);

        if (ValidateMovie.checkDataMovie(movieName) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Thông tin movie name không hợp lệ! ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        } else if(ValidateMovie.checkDataMovie(movieCategory) == false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Thông tin movie category không hợp lệ! ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        } else if(ValidateMovie.checkDataMovie(description) == false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Thông tin movie description không hợp lệ! ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        }else if(ValidateMovie.checkDataMovie(movieAuthor) == false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Thông tin author không hợp lệ! ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        }else if(ValidateMovie.checkDataMovie(movieActor) == false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Thông tin movie actor không hợp lệ! ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        }else if(ValidateMovie.checkDuration(movieDuration) == false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Duration phải là số và không bắt đầu bắng số 0 ");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        }
        else {

            movieDAO.addMovie(movie);
            request.setAttribute("mess", "Add movie successful!!");
            request.getRequestDispatcher("AdminAddMovie.jsp").forward(request, response);
        }
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
