/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.MovieDAO;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;
import model.Movie;
import util.StringDecode;

/**
 *
 * @author Bảo Châu Bống
 */
public class MovieListController extends HttpServlet {

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
//        // Query Parameter
//        int page = Integer.parseInt(request.getParameter("page"));
//        String query = StringDecode.decode(request.getParameter("query"));
//        request.setAttribute("page", page);
//        request.setAttribute("query", query.replace(' ', '+'));
//
//        // Random Banner
//        BannerDAO bdao = new BannerDAO();
//        List<Banner> banners = bdao.getAllBanner();
//        Random rand = new Random();
//        int size = banners.size();
//        if (size > 0) {
//            request.setAttribute("banner", banners.get(rand.nextInt(banners.size())));
//        }
        
        //Get moive and get request dispatcher to movie_detail.jsp
        int mid = Integer.parseInt(request.getParameter("mid"));
        MovieDAO mdao = new MovieDAO();
        Movie m = mdao.getMovieById(mid);
        request.setAttribute("movie", m);
        request.getRequestDispatcher("movie_detail.jsp").forward(request, response);
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
