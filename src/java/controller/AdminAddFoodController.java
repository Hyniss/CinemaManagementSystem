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
import model.FoodAndDrink;

/**
 * Documentation : AdminPromotionListController 
 * Created on : 13-Feb-2022, 08:41:21
 * @author Nguyễn Tiến Huy
 */

//  Admin can add new Banner
//url
@WebServlet(name = "AdminAddFoodController", urlPatterns = {"/AdminAddFoodController"})
public class AdminAddFoodController extends HttpServlet {
        //create object
       IFoodDAO foodDAO = new FoodDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lead to AdminAddFood.jsp
        request.getRequestDispatcher("AdminAddFood.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        // Parameter Initializing
        String new_category = request.getParameter("new_Category").trim();
        String new_Img = request.getParameter("new_Img").trim();
        String new_Name = request.getParameter("new_Name").trim();
        String new_Price = request.getParameter("new_Price").trim();
        
          //create object
        FoodAndDrink fd = new FoodAndDrink();
        // Set the value
       fd.setCategory(new_category);
       fd.setImg(new_Img);
       fd.setName(new_Name);
       fd.setPrice(new_Price);
       
        //call metho and add value to database
       foodDAO.addFood(fd);
       // Lead to Page that show the list Food
        response.sendRedirect(request.getContextPath() + "/AdminListFood");
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
