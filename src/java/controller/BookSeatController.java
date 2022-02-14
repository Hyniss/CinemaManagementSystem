/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * BookSeatController
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
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
 * This is a Servlet responsible for handling the task when the user wants to
 * book the seat
 * /book is the URL of the web site Extend HttpServlet class
 *
 * @author Nguyen Nam
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
        //Use ISeatDAO interface to call
        ISeatDAO seatDao = new SeatDAO();

        double totalSeatPrice = 0;
        double seatPrice = 0;
        String[] checkedSeatId = null;
        boolean bookSeat = false;

        checkedSeatId = request.getParameterValues("seatId");
        try {
            bookSeat = Boolean.valueOf(request.getParameter("bookSeat"));
        } catch (Exception e) {
        }

        ArrayList<Seat> listSeatChecked = new ArrayList<>();
        HttpSession BookSeatSession = request.getSession(true);

        if (checkedSeatId != null) {
            //add seat chosen into list and update the price 
            request.setAttribute("status", "check");
            for (String checked : checkedSeatId) {
                String price = seatDao.getSeatInfoBySeatId(checked).getPrice();
                try {
                    seatPrice = Double.parseDouble(price);
                } catch (Exception e) {
                }
                Seat seat = new Seat();
                seat.setSeatId(checked);
                totalSeatPrice += seatPrice;
                listSeatChecked.add(seat);
            }
            /*Attach attribute subjects for request and redirect it to Seat.jsp*/
            BookSeatSession.setAttribute("listcheckedSeatId", listSeatChecked);
            BookSeatSession.setAttribute("totalSeatPrice", totalSeatPrice);
            request.getRequestDispatcher("Seat.jsp").forward(request, response);
        } else if (bookSeat && checkedSeatId == null) {
            /* redirect it to Seat.jsp*/
            request.getRequestDispatcher("Seat.jsp").forward(request, response);
        } else if ((!bookSeat && checkedSeatId == null)) {
            /*Remove and redirect it to view seat*/
            BookSeatSession.removeAttribute("listcheckedSeatId");
            BookSeatSession.removeAttribute("totalSeatPrice");
            response.sendRedirect("seat");
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
