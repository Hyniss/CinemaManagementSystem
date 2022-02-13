/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.PromotionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Documentation : AdminDeletePromotionController 
 * Created on : 13-Feb-2022,04:22:00
 * @author Bảo Châu Bống
 */

// Admin can delete Promotion

public class AdminDeletePromotionController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Delete value from Database
        promotionDao.deletePromotion(Integer.parseInt(id));
        
        // Lead to Page that show the list of promotion
        response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
    }
}
