/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
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
 * Documentation : AdminEditPromotion Created on : 13-Feb-2022, 04:38:41
 *
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
        // Set Parameter
//        promotion.setId(Integer.parseInt(request.getParameter("new_id")));
//        promotion.setTitle(request.getParameter("new_title"));
//        promotion.setImageLink(request.getParameter("new_Img"));
//        promotion.setContent(request.getParameter("new_content"));
//        promotion.setDate(request.getParameter("new_date"));
//        promotion.setDiscount((request.getParameter("new_discount")));
//        promotion.setMagiam(request.getParameter("new_magiam"));
        // Calling method
        int new_id = Integer.parseInt(request.getParameter("new_id").trim());
        String new_title = request.getParameter("new_title").trim();
        String new_img = request.getParameter("new_img").trim();
        String new_content = request.getParameter("new_content").trim();
        String new_date = request.getParameter("new_date").trim();
        String new_discount = request.getParameter("new_discount").trim();
        String new_magiam = request.getParameter("new_magiam").trim();

        Promotion promotion = new Promotion(new_id, new_title, new_content, new_magiam, new_date, new_discount, new_magiam);

        promotion.setId(new_id);
        promotion.setTitle(new_title);
        promotion.setImageLink(new_img);
        promotion.setContent(new_content);
        promotion.setDate(new_date);
        promotion.setDiscount(new_discount);
        promotion.setMagiam(new_magiam);

        String mess = "";
//
//        // Edit value from Database
//        promotionDao.editPromotion(promotion);
//
//        // Lead to Page that show the list of promotion
//        response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
        if (Validate.checkTitle(new_title) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Length of Title must be from 4 to 30");
            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
        } else if (Validate.checkImg(new_img) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Image can not be blank!");
            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
        } else if (Validate.checkDesc(new_content) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Length of Description must be from 4 to 2500 characters!");
            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
        } else if (Validate.checkDate(Date.valueOf((new_date))) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Date is not valid !");
            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
//        } else if (Validate.checkDiscount(new_magiam) == false) {
//            request.setAttribute("promotion", promotion);
//            request.setAttribute("error", "Length of Coupon must be from 4 to 15 characters!");
//            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
        } else {
            promotionDao.editPromotion(promotion);
            response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add Promotion successful!");
            request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
        }
    }
}
