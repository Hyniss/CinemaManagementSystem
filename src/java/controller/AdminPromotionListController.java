/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 * Document : AdminPromotionListController
 * Created on : 13-Feb-2022, 04:38:41 
 * @author Bảo Châu Bống
 */

// Admin can see the list of Promotion and CRUD
public class AdminPromotionListController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Get data from database and transfer in parameter
        List<Promotion> promotionList = promotionDao.getAllPromotion();
        
        // Set Attribute
        request.setAttribute("promotionList", promotionList);
        
        // Lead to AdminPromotionList.jsp
        request.getRequestDispatcher("AdminPromotionList.jsp").forward(request, response);
    }
}
