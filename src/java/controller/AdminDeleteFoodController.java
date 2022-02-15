/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FoodDAO;
import dao.IFoodDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Documentation : AdminDeleteFoodController
 * Created on : 13-Feb-2022, 02:29:34 
 * @author Nguyễn Tiến Huy
 */

// Admin Can delete Food
@WebServlet(name = "AdminDeleteFoodController", urlPatterns = {"/AdminDeleteFood"})
public class AdminDeleteFoodController extends HttpServlet {
           // Create object
            IFoodDAO foodDAO = new FoodDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parameter Initializing
        String id = request.getParameter("id");
        // Calling method 
       foodDAO.deleteFood(id);
       // Lead to Page that show the list Food
        response.sendRedirect(request.getContextPath() + "/AdminListFood");
    }
}
