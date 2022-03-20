/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.impl.FoodDAO;
import dao.IFoodDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FoodAndDrink;

/**
 * Documentation: AdminEditFoodController Created on : 13-Feb-2022, 08:41:34
 *
 * @author Nguyễn Tiến Huy
 */
// Admin can edit the information of food
//url
@WebServlet(name = "AdminEditFoodController", urlPatterns = {"/AdminEditFood"})
public class AdminEditFoodController extends HttpServlet {

    //create object
    IFoodDAO foodDao = new FoodDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // Parameter Initializing
        String id = request.getParameter("id");
        int fid = Integer.parseInt(id);
        //search object with id insert data into variable have datatype FoodAndDrink
        FoodAndDrink food = foodDao.getFoodAndDrink(fid);
        //set attribute
        request.setAttribute("food", food);

        // Lead to AdminEditFood.jsp
        request.getRequestDispatcher("AdminEditFood.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //create object
        FoodAndDrink fd = new FoodAndDrink();
        // Set parameter
//        fd.setFoodId(Integer.parseInt(request.getParameter("new_id").trim()));
//        fd.setCategory(request.getParameter("new_Category").trim());
//        fd.setImg(request.getParameter("new_Img").trim());
//        fd.setName(request.getParameter("new_Name").trim());
//        fd.setPrice(request.getParameter("new_Price").trim());
        // call method edit value from Database
//        foodDao.editFood(fd);
//        // Lead to Page that show the list food
//        response.sendRedirect(request.getContextPath() + "/AdminListFood");

        int new_id = Integer.parseInt(request.getParameter("new_id").trim());
        String new_Category = request.getParameter("new_Category").trim();
        String new_Img = request.getParameter("new_Img").trim();
        String new_Name = request.getParameter("new_Name").trim();
        String new_Price = request.getParameter("new_Price").trim();

        fd.setFoodId(new_id);
        fd.setCategory(new_Category);
        fd.setName(new_Name);
        fd.setImg(new_Img);
        fd.setPrice(new_Price);

        String mess = "";
        if (Validate.checkTitle(new_Category) == false) {
            request.setAttribute("fd", fd);
            request.setAttribute("error", "Length of Category must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminAddFood.jsp").forward(request, response);
        } else if (Validate.checkTitle(new_Name) == false) {
            request.setAttribute("fd", fd);
            request.setAttribute("error", "Length of Name must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminAddFood.jsp").forward(request, response);
        } else {
            foodDao.editFood(fd);
            response.sendRedirect(request.getContextPath() + "/AdminListFood");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add Food and Drink successful!");
            request.getRequestDispatcher("AdminAddFood.jsp").forward(request, response);
        }
    }
}
