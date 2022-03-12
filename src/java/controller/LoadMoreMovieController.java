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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

/**
 * Load more movie when click load more button
 *
 * @author Thai Tran
 */
public class LoadMoreMovieController extends HttpServlet {

    IMovieDAO movieDAO = new MovieDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //get amount attribute from home.jsp
        int amount = Integer.parseInt(request.getParameter("exists"));

        //call mothod in dao
        List<Movie> movieList = movieDAO.getNext4Movie(amount);

        //println a html by servlet
        try (PrintWriter out = response.getWriter()) {
            for (Movie o : movieList) {
                out.println("<div class=\"movie col-md-3 mt-4\" >\n"
                        + "                        <div class=\"card card-custom h-100 shadow-sm\" style=\"position: relative\"> \n"
                        + "                            <a href=\"movie?mid=" + o.getMovieId() + "\"><img src=\"././././assets/img/movie/" + o.getImage() + "\" class=\"aa-product-img shadow border-radius-lg card-header\" position=\"absolute\" top=\"0\" left=\"0\" display=\"block\" width=\"100%\" height=\"450px\" margin-bottom =\"20px\" object-fit= \"cover\" alt=\"...\"></a>\n"
                        + "                            <div class=\"card-body\">\n"
                        + "                                <div class=\"clearfix mb-3 text-center\"> \n"
                        + "                                    <h2 class=\"currency price-hp\" style=\"color: #ff3333\">" + o.getMovieName() + "</h2> \n"
                        + "                                </div>\n"
                        + "                                <div class=\"clearfix mb-3\"> \n"
                        + "                                    <h4 class=\"currency price-hp\" style=\"color: #000\">Thể loại: " + o.getCategoryMovie() + "</h4> \n"
                        + "                                    <h4 class=\"currency price-hp\" style=\"color: #000\">Thời lượng: " + o.getDuration() + " phút</h4> \n"
                        + "                                    <h4 class=\"currency price-hp\" style=\"color: #000\">Khởi chiếu: " + o.getFormatedDate() + "</h4> \n"
                        + "                                </div>\n"
                        + "                                <div class=\"text-center my-4 hover\">                               \n"
                        + "                                    <button onclick=\"viewDetail(" + o.getMovieId() + ")\" class=\"custom-btn btn-watch\"><span>Xem ngay !</span><span>Xem ngay</span></button>\n"
                        + "                                    <button onclick=\"\" class=\"custom-btn btn-book\"><span>Mua vé !</span><span>Mua vé</span></button>\n"
                        + "                                </div>\n"
                        + "                                <!-- <div class=\"clearfix mb-1\"> <span class=\"float-start\"><i class=\"far fa-question-circle\"></i></span> <span class=\"float-end\"><i class=\"fas fa-plus\"></i></span> </div> -->\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>");
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
