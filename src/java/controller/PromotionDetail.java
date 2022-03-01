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
 *
 * @author Bảo Châu Bống
 */
public class PromotionDetail extends HttpServlet {

    IPromotionDAO promotionDao = new PromotionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Promotion promotion = promotionDao.get(Integer.parseInt(id));
        request.setAttribute("promotion", promotion);

        List<Promotion> promotionList = promotionDao.getAllPromotion();
        request.setAttribute("promotionList", promotionList);

        request.getRequestDispatcher("Promotion-detail.jsp").forward(request, response);
    }

}
