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
import java.util.HashSet;
import java.util.List;
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
@WebServlet(name = "AdminSearchMovieController", urlPatterns = {"/adminsearchmovie"})
public class AdminSearchMovieController extends HttpServlet {
    IMovieDAO movieDAO= new MovieDAO();
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
        request.setCharacterEncoding("UTF-8");
        String movietxt=request.getParameter("movietxt").trim();
        if(movietxt == null || movietxt.equals("") ){
            request.setAttribute("movietxt", movietxt);
            request.setAttribute("error", "This field can not empty!");
            request.getRequestDispatcher("AdminMovieList.jsp").forward(request, response);
        }else{
            List<Movie> listmovie=movieDAO.getMovieByName(movietxt);
            if(listmovie.size()==0){
                request.setAttribute("error", "No data to show!!");
                request.setAttribute("movietxt", movietxt);
                request.getRequestDispatcher("AdminMovieList.jsp").forward(request, response);
            }else{
                request.setAttribute("listmovie", listmovie);
                request.getRequestDispatcher("AdminMovieList.jsp").forward(request, response);
            
        }
        
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

