/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IMovieTimeDAO;
import dao.IShowtimesDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.ShowtimesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MovieRoom;
import model.MovieTime;

/**
 *
 * @author tenhik
 */
@WebServlet(name = "AdminListTime", urlPatterns = {"/adminListTime"})
public class AdminListTime extends HttpServlet {

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
        IShowtimesDAO showtimesDAO = new ShowtimesDAO();
        IMovieTimeDAO movieTimeDAO = new MovieTimeDAO();

        int pageIndex = 1;
        int pageSize = 8;
        int total = showtimesDAO.countTotal();
        int totalPage = 0;
        int page = 0;
        String date = request.getParameter("searchtxt");
        Date dateSearch = null;
        try {
            dateSearch = Date.valueOf(date);
        } catch (Exception e) {
            Logger.getLogger(AdminListTime.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        } catch (NumberFormatException e) {
            Logger.getLogger(AdminListTime.class.getName()).log(Level.SEVERE, null, e);
        }
        /*pagging*/
        if (total > 0) {
            page = total % pageSize;
            totalPage = total / pageSize;
            if (page == 0) {
                totalPage += 0;
            } else {
                totalPage += 1;
            }
        }
        ZoneId zid = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDate ld = LocalDate.now(zid);
        Date currentDate = Date.valueOf(ld);
             
        int next = pageIndex + 1;
        int back = pageIndex - 1;
        ArrayList<MovieRoom> listDate = showtimesDAO.getAllDatePaggingAndSearching(pageIndex, pageSize, dateSearch);
        ArrayList<MovieTime> listTime = listTime = movieTimeDAO.getMovieTimeByMovieRoomId(listDate);
        request.setAttribute("next", next);
        request.setAttribute("back", back);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("total", total);
        request.setAttribute("currentDate",currentDate);
        request.setAttribute("date", dateSearch);
        request.setAttribute("listDate", listDate);
        request.setAttribute("listTime", listTime);
        request.getRequestDispatcher("AdminListTime.jsp").forward(request, response);
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
