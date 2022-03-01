/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.PromotionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 * Documentation : PromotionController 
 * Created on : 12-Feb-2022, 21:46:10
 * @author Bảo Châu Bống
 */

// The list of the promotion
public class PromotionController extends HttpServlet {

    // Calling method of database
    PromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from database and transfer in parameter
        List<Promotion> promotionList = promotionDao.getAllPromotion();
        
        // Set Attribute
        request.setAttribute("promotionList", promotionList);
        
        // Lead to Promotion.jsp
        request.getRequestDispatcher("Promotion.jsp").forward(request, response);
    }
}
