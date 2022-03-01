/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
        IMovieDAO movieDAO=new MovieDAO();
        int movieId=Integer.parseInt(request.getParameter("movieID"));//lay movie id tu request
        Movie movie=movieDAO.getMovieById(movieId);// lay ra movie update
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
        request.setCharacterEncoding("UTF-8"); //có thể nhận dữ liệu là tiếng việt
        
        IMovieDAO movieDAO=new MovieDAO();
        Movie movie=new Movie();
        //update lai du lieu cho movie
        movie.setMovieId(Integer.parseInt(request.getParameter("movieID").trim()));
        movie.setMovieName(request.getParameter("movieName").trim());
        movie.setImage(request.getParameter("movieImage").trim());
        movie.setCategoryMovie(request.getParameter("movieCategory").trim());
        movie.setDescription(request.getParameter("movieDescription").trim());
        movie.setTrailer(request.getParameter("movieTrailer").trim());
        movie.setAuthor(request.getParameter("movieAuthor").trim());
        movie.setActor(request.getParameter("movieActor").trim());
        movie.setDuration(request.getParameter("movieDuration").trim());
        movie.setPremiere(Date.valueOf(request.getParameter("moviePremiere")));
        
        movieDAO.editMovie(movie);
        request.setAttribute("mess", "Update successful");
        request.getRequestDispatcher("AdminEditMovie.jsp").forward(request, response);
                
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
