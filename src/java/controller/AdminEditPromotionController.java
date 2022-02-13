/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.PromotionDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminEditPromotionController extends HttpServlet {

    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Promotion promotion = promotionDao.get(Integer.parseInt(id));
        request.setAttribute("promotion", promotion);
        request.getRequestDispatcher("AdminEditPromotion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Promotion promotion = new Promotion();
        promotion.setId(Integer.parseInt(request.getParameter("new_id")));
        promotion.setTitle(request.getParameter("new_title"));
        promotion.setImageLink(request.getParameter("new_Img"));
        promotion.setContent(request.getParameter("new_content"));
        promotion.setDate(Date.valueOf(request.getParameter("new_date")));
        promotionDao.editPromotion(promotion);

        response.sendRedirect(request.getContextPath() + "/adminpromotionlist");
    }
}
