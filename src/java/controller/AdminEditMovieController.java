/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import Validation.ValidateMovie;
import dao.IMovieDAO;
import dao.impl.MovieDAO;
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
@WebServlet(name = "AdminEditMovieController", urlPatterns = {"/editmovie"})
public class AdminEditMovieController extends HttpServlet {

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
            out.println("<title>Servlet AdminEditMovieController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditMovieController at " + request.getContextPath() + "</h1>");
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
        IMovieDAO movieDAO = new MovieDAO();
        int movieId = Integer.parseInt(request.getParameter("movieID"));//lay movie id tu request
        Movie movie = movieDAO.getMovieById(movieId);// lay ra movie update
        request.setAttribute("movie", movie);

        request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);

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
        request.setCharacterEncoding("UTF-8"); //c?? th??? nh???n d??? li???u l?? ti???ng vi???t

        IMovieDAO movieDAO = new MovieDAO();
        int movieId = Integer.parseInt(request.getParameter("movieID").trim());
        String movieName = request.getParameter("movieName").trim();
        String movieImage = request.getParameter("movieImage");
        String movieCategory = request.getParameter("movieCategory").trim();
        String description = request.getParameter("movieDescription").trim();
        String movieTrailer = request.getParameter("movieTrailer").trim();
        String movieAuthor = request.getParameter("movieAuthor").trim();
        String movieActor = request.getParameter("movieActor").trim();
        String movieDuration = request.getParameter("movieDuration").trim();
        String moviePremiere = request.getParameter("moviePremiere");
        Date premiere = Date.valueOf(moviePremiere);//ep kieu du lieu cho date
        Movie movie = new Movie(movieId, movieName, movieImage, moviePremiere, description, movieTrailer, movieAuthor, movieActor, movieDuration, premiere);
        //update lai du lieu cho movie
        movie.setMovieId(movieId);
        movie.setMovieName(movieName);
        movie.setImage(movieImage);
        movie.setCategoryMovie(movieCategory);
        movie.setDescription(description);
        movie.setTrailer(movieTrailer);
        movie.setAuthor(movieAuthor);
        movie.setActor(movieActor);
        movie.setDuration(movieDuration);
        movie.setPremiere(premiere);
        if (ValidateMovie.checkDataMovie(movieName) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Movie name kh??ng ???????c ????? tr???ng v?? gi???i h???n 4-2000 k?? t???!!!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if (ValidateMovie.checkDataMovie(movieCategory) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Movie Category kh??ng ???????c ????? tr???ng v?? gi???i h???n 4-2000 k?? t???!!!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if (ValidateMovie.checkDataMovie(description) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Description kh??ng ???????c ????? tr???ng v?? gi???i h???n 4-2000 k?? t???!!!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if (ValidateMovie.checkTrailer(movieTrailer) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Trailer ph???i l?? 1 ???????ng link b???t ?????u b???ng http(s) ");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if (ValidateMovie.checkDataMovie(movieAuthor) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Author kh??ng ???????c ????? tr???ng v?? gi???i h???n 4-2000 k?? t???!!!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if (ValidateMovie.checkDataMovie(movieActor) == false) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Actor kh??ng ???????c ????? tr???ng v?? gi???i h???n 4-2000 k?? t???!!! ");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        } else if ((ValidateMovie.checkDuration(movieDuration) == false) || (Integer.parseInt(movieDuration) > 300) || (Integer.parseInt(movieDuration) < 60)) {
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Duration ph???i l?? s??? v?? kh??ng b???t ?????u b???ng s??? 0 v?? n???m trong kho???ng t??? 60-300!!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        }  else if(ValidateMovie.checkPremiere(premiere)==false){
            request.setAttribute("movie", movie);
            request.setAttribute("error", "Ng??y c??ng chi???u ph???i sau ng??y hi???n t???i v?? n??m ph???i nh??? h??n n??m hi???n t???i +2!");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
        }
            else {

            movieDAO.editMovie(movie);
            request.setAttribute("mess", "Update successful");
            request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
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
