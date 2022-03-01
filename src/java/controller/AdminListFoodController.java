/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.FoodDAO;
import dao.IFoodDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FoodAndDrink;

/**
 * Documentation: AdminListFoodConntroller 
 * Created on: 13-Feb-2022, 08:41:21
 * @author Nguyễn Tiến Huy
 */

// Admin can see the list of Banner and do CRUD
//url
@WebServlet(name = "AdminListFoodController", urlPatterns = {"/AdminListFood"})
public class AdminListFoodController extends HttpServlet {

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //create object
        IFoodDAO foodDAO = new FoodDAO();
        //create list with datatype is FoodAndDrink and call method from foodDAO for variable list
        List<FoodAndDrink> foodList = foodDAO.getAllFood();
        // Set Attribute
        request.setAttribute("foodList", foodList);
        // Lead to AdminBannerList.jsp
        request.getRequestDispatcher("AdminListFood.jsp").forward(request, response);
    }

}
