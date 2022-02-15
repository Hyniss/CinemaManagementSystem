/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * ViewFoodController
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-11   1.0         Nguyen Nam    First Implement
 */
package controller;

import dao.FoodDAO;
import dao.IFoodDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodAndDrink;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * see the list of foods 
 * /food is the URL of the web site Extend HttpServlet class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "ViewFoodController", urlPatterns = {"/food"})
public class ViewFoodController extends HttpServlet {

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

        IFoodDAO foodDAO = new FoodDAO();
//        ArrayList<FoodAndDrink> listFoodAndDrink = foodDAO.listAllFoodAndDrink(); lấy lại hàm
        HttpSession BookSeatSession = request.getSession(true);

        double totalSeatPrice = (double) BookSeatSession.getAttribute("totalSeatPrice");
        if (BookSeatSession != null) {
            /*Attach attribute subjects for request and redirect it to Food.jsp*/
            request.setAttribute("totalSeatPrice", totalSeatPrice);
//            request.setAttribute("listFoodAndDrink", listFoodAndDrink); lấy lại hàm
            request.getRequestDispatcher("Food.jsp").forward(request, response);
        } else {
           response.sendRedirect("book");
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
