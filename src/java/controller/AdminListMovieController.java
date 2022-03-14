/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieDAO;
import dao.impl.MovieDAO;
import java.io.IOException;
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
@WebServlet(name = "adminListMovie", urlPatterns = {"/adminListMovie"})
public class AdminListMovieController extends HttpServlet {
    IMovieDAO movieDAO= new MovieDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         final int PAGE_SIZE=5; //số lượng phim trong 1 trang
        int page=1;
        String pageRequest=request.getParameter("page");
        if(pageRequest!=null){
            page=Integer.parseInt(pageRequest);
        }
        
        
        int totalMovie= movieDAO.getTotalMovie();// tính tổng số lượng phim
        int totalPage=totalMovie/PAGE_SIZE;    //tính tổng số trang
        
        if(totalMovie % PAGE_SIZE!=0){
            totalPage=totalPage+1;    // nếu chia dư thì cộng số trang lên 1
        }
        
        
        List<Movie> listMovie=movieDAO.getMovieWithPagging(page,PAGE_SIZE);
        request.setAttribute("page", page);
        request.setAttribute("totalpage", totalPage);
        
        request.setAttribute("listmovie", listMovie);
        request.getRequestDispatcher("AdminMovieList.jsp").forward(request, response);
        
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
