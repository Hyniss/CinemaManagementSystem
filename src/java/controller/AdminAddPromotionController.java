/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.PromotionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 * Documentation : AdminAddPromotionController
 * Created on : 13-Feb-2022, 01:41:21
 * @author Bảo Châu Bống
 */


public class AdminAddPromotionController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Lead to AdminAddBanner.jsp
        request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // Parameter Initializing
        String new_title = request.getParameter("new_title");
        String new_content = request.getParameter("new_content");
        String new_imageLink = request.getParameter("new_imageLink");
        String new_date = request.getParameter("new_date");

        // Set the value
        Promotion promotion = new Promotion();
        promotion.setTitle(new_title);
        promotion.setContent(new_content);
        promotion.setImageLink(new_imageLink);
        promotion.setDate(Date.valueOf(new_date));

        // Add value to database
        promotionDao.addPromotion(promotion);
        
        // Lead to Page that show the list of banner
        response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
    }
}
