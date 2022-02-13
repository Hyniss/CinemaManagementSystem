/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ISeatDAO;
import dao.SeatDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Seat;

/**
 *
 * @author tenhik
 */
@WebServlet(name = "BookSeatController", urlPatterns = {"/book"})
public class BookSeatController extends HttpServlet {

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
        ISeatDAO seatDao = new SeatDAO();
        Seat seat = new Seat();

        double totalPrice = 0;
        double seatPrice = 0;
        String[] checkedSeatId = null;

        checkedSeatId = request.getParameterValues("seatId");
        ArrayList<String> listSeatChecked = new ArrayList<>();

        if (checkedSeatId != null) {

            request.setAttribute("status", "check");
            for (String checked : checkedSeatId) {
                String price = seatDao.getSeatPriceBySeatId(checked);
                try {
                    seatPrice = Double.parseDouble(price);
                } catch (Exception e) {
                }
                totalPrice += seatPrice;
                listSeatChecked.add(checked);
            }
        }
        request.setAttribute("listcheckedSeatId", listSeatChecked);
        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("Seat.jsp").forward(request, response);
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
