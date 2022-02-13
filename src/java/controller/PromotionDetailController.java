/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.PromotionDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 * Document : PromotionDetailController
 * Created on : 12-Feb-2022, 22:15:27
 * @author Bảo Châu Bống
 */

// The list of information of Promotion

public class PromotionDetailController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Get value from Database
        Promotion promotion = promotionDao.get(Integer.parseInt(id));
        
        // Set Attribute
        request.setAttribute("promotion", promotion);

        // Get data from database and transfer in parameter
        List<Promotion> promotionList = promotionDao.getAllPromotion();
        
        // Set Attribute
        request.setAttribute("promotionList", promotionList);

        // Lead to Promotion-detail.jsp
        request.getRequestDispatcher("Promotion-detail.jsp").forward(request, response);
    }

}
