/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 *
 * Documentation : AdminEditPromotion 
 * Created on : 13-Feb-2022, 04:38:41 
 * @author Bảo Châu Bống
 */
public class AdminEditPromotionController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Get value from database
        Promotion promotion = promotionDao.get(Integer.parseInt(id));
        
        // Set Attribute
        request.setAttribute("promotion", promotion);
        
        // Lead to AdminEditPromotion.jsp
        request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Calling method
        Promotion promotion = new Promotion();
        
        // Set Parameter
        promotion.setId(Integer.parseInt(request.getParameter("new_id")));
        promotion.setTitle(request.getParameter("new_title"));
        promotion.setImageLink(request.getParameter("new_Img"));
        promotion.setContent(request.getParameter("new_content"));
        promotion.setDate(request.getParameter("new_date"));
        promotion.setDiscount(Integer.parseInt(request.getParameter("new_discount")));
        promotion.setMagiam(request.getParameter("new_magiam"));
        
        // Edit value from Database
        promotionDao.editPromotion(promotion);

        // Lead to Page that show the list of promotion
        response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
    }
}
