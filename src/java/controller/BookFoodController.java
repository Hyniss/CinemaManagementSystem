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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodAndDrink;
import model.FoodAndDrinkCart;

/**
 * This is a Servlet responsible for handling the task when the user wants to
 * book the foods /book-food is the URL of the web site Extend HttpServlet class
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
        //Use IFoodDAO interface to call
        IFoodDAO foodDAO = new FoodDAO();
        HttpSession session = request.getSession();
        ArrayList<FoodAndDrinkCart> listFoodAndDrinkCarts = (ArrayList<FoodAndDrinkCart>) session.getAttribute("listFoodCarts");
        ArrayList<FoodAndDrinkCart> listFoodToRemove = new ArrayList<>();
        double totalSeatPrice = 0;
        double totalFoodPrice = 0;
        double totalPrice = 0;
        int quantity = 0;

        int foodQuantity = 0;
        int pageIndex = 1;
        int pageSize = 8;
        int totalProduct = foodDAO.countTotalFood();
        int totalPage = 0;
        int page = 0;

        boolean bookFood = false;
        String foodId = request.getParameter("foodId");
        String calcType = request.getParameter("type");
        String changePage = request.getParameter("changePage");
        /* parse String to boolean and int*/
        try {
            bookFood = Boolean.valueOf(request.getParameter("bookFood"));
        } catch (Exception e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        } catch (NumberFormatException e) {
            Logger.getLogger(BookSeatController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            totalSeatPrice = (double) session.getAttribute("totalSeatPrice");
        } catch (Exception e) {
            response.sendRedirect("seat");
            return;
        }
        /*order product*/
        if (changePage == null) {
            FoodAndDrink food = foodDAO.getFoodAndDrink(foodId);
            if (quantity == 0 && calcType.equals("plus")) {
                quantity = 1;
            }
            FoodAndDrinkCart foodCart = new FoodAndDrinkCart(foodId, quantity, Double.parseDouble(food.getPrice()));
            boolean checkExist = false;
            if (listFoodAndDrinkCarts == null) {/* add new product*/
                listFoodAndDrinkCarts = new ArrayList<>();
                listFoodAndDrinkCarts.add(foodCart);
                session.setAttribute("listFoodCarts", listFoodAndDrinkCarts);
            } else {
                /*update quantity*/
                for (FoodAndDrinkCart l : listFoodAndDrinkCarts) {
                    if (l.getFoodId().equals(foodId)) {
                        if (calcType.equalsIgnoreCase("plus")) {/* check user wants to plus or minus*/
                            foodQuantity = l.getQuantity() + 1;
                        } else {
                            if (l.getQuantity() >= 1) {
                                foodQuantity = l.getQuantity() - 1;
                            }
                        }
                        if (foodQuantity == 0) {
                            listFoodToRemove.add(l);
                        }
                        l.setQuantity(foodQuantity);
                        checkExist = true;
                    }
                }
                /* remove food and drink if quantity = 0*/
                listFoodAndDrinkCarts.removeAll(listFoodToRemove);
                if (!checkExist) {
                    listFoodAndDrinkCarts.add(foodCart);
                    checkExist = false;
                }
                session.setAttribute("listFoodCarts", listFoodAndDrinkCarts);
            }
        }
        /* update total food price*/
        for (FoodAndDrinkCart listFoodAndDrinkCart : listFoodAndDrinkCarts) {
            totalFoodPrice += listFoodAndDrinkCart.getPrice() * listFoodAndDrinkCart.getQuantity();
        }
        session.setAttribute("totalFoodPrice", totalFoodPrice);
        
        /*pagging product*/
        if (totalProduct > 0) {
            page = totalProduct % pageSize;
            totalPage = totalProduct / pageSize;
            if (page == 0) {
                totalPage += 0;
            } else {
                totalPage += 1;
            }
        }
        int next = pageIndex + 1;
        int back = pageIndex - 1;
        ArrayList<FoodAndDrink> listFoodAndDrink = foodDAO.getAllFoodPagging(pageIndex, pageSize);
        /* redirect if product list is empty*/
        if (listFoodAndDrinkCarts.isEmpty()) {
            response.sendRedirect("food?viewFood=true");
            return;
        }
        /*Attach attribute subjects for request and redirect it to Food.jsp*/
        request.setAttribute("next", next);
        request.setAttribute("back", back);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("listFoodAndDrink", listFoodAndDrink);
        request.setAttribute("bookFood", bookFood);
        request.getRequestDispatcher("Food.jsp").forward(request, response);
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
