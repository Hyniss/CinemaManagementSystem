/* 
 * CinemaManagementSystem
 * Copyright(C)2022, Group 4 SE1511 FPTU-HN
 * 
 * BookFoodController
 * Record of change:
 * DATE         Version     AUTHOR        Description
 * 2022-02-12   1.0         Nguyen Nam    First Implement
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
import model.FoodAndDrink;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * book the foods
 * /book-food is the URL of the web site 
 * Extend HttpServlet class
 *
 * @author Nguyen Nam
 */
@WebServlet(name = "BookFoodController", urlPatterns = {"/book-food"})
public class BookFoodController extends HttpServlet {

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

        IFoodDAO foodDAO = new FoodDAO();
        ArrayList<FoodAndDrink> listFoodAndDrink = foodDAO.listAllFoodAndDrink();
        String totalSeatPrice = request.getParameter("totalSeatPrice");
        String movie = request.getParameter("movie");
        String room = request.getParameter("room");
        String seat = request.getParameter("seat");

        String bookFoodId = request.getParameter("foodId");
        String bookFood = request.getParameter("bookFood");
        String subQuan = request.getParameter("quantity");
        int subQuantity = 0;
        try {
            subQuantity = Integer.parseInt(subQuan);
        } catch (Exception e) {
        }
        subQuantity += 1;

        /*Attach attribute subjects for request and redirect it to Food.jsp*/
        request.setAttribute("bookFoodId", bookFoodId);
        request.setAttribute("quantity", subQuantity);
        request.setAttribute("bookFood", bookFood);

        request.setAttribute("totalSeatPrice", totalSeatPrice);
        request.setAttribute("movie", movie);
        request.setAttribute("room", room);
        request.setAttribute("seat", seat);
        request.setAttribute("listFoodAndDrink", listFoodAndDrink);
        request.getRequestDispatcher("Food.jsp").forward(request, response);
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
