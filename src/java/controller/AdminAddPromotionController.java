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
 * Documentation : AdminAddPromotionController Created on : 13-Feb-2022,
 * 01:41:21
 *
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
        String new_title = request.getParameter("new_title").trim();
        String new_content = request.getParameter("new_content").trim();
        String new_imageLink = request.getParameter("new_imageLink");
        String new_date = request.getParameter("new_date");
        String new_discount = request.getParameter("new_discount");
        String new_magiam = request.getParameter("new_magiam").trim();

        // Set the value
        Promotion promotion = new Promotion();
        promotion.setTitle(new_title);
        promotion.setContent(new_content);
        promotion.setImageLink(new_imageLink);
        promotion.setDate(new_date);
        promotion.setDiscount(new_discount);
        promotion.setMagiam(new_magiam);

        String mess = "";
//        if (Validate.checkImg(promotion.getImageLink()) == false) {
//            mess = "Sai định dạng ảnh !";
//        } else if (Validate.checkTitle(promotion.getTitle()) == false) {
//            mess = "Thông tin Title không hợp lệ !";
//        } else if (Validate.checkDesc(promotion.getContent()) == false) {
//            mess = "Thông tin Content không hợp lệ !";
//        } else {
//            // Add value to database
//            promotionDao.addPromotion(promotion);
//            response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
//        }
//        if (!mess.equals("")) {
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
//        }
        if (Validate.checkTitle(new_title) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Length of Title must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
        } else if (Validate.checkDesc(new_content) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Length of Content must be from 4 to 2500 characters!");
            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
            //        } else if (Validate.checkDiscount(new_magiam) == false) {
            //            request.setAttribute("promotion", promotion);
            //            request.setAttribute("error", "Length of Coupon must be from 4 to 15 characters!");
            //            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
        } else if (Validate.checkDate((Date.valueOf(new_date))) == false) {
            request.setAttribute("promotion", promotion);
            request.setAttribute("error", "Date is not valid!");
            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
        } else {
            promotionDao.addPromotion(promotion);
            response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add Promotion successful!");
            request.getRequestDispatcher("AdminAddPromotion.jsp").forward(request, response);
        }
    }
}
