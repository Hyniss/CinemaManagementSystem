/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class AdminSearchPromotionController extends HttpServlet {

    IPromotionDAO promotionDao = new PromotionDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get search txt
        String promotionTitle = request.getParameter("searchtxt").replaceAll("\\s+", " ").trim();
        request.setAttribute("searchtxt", promotionTitle);

        // get pageindex params
        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        // get list promotion by search txt
        List<Promotion> promotionList = new ArrayList<>();
        promotionList = promotionDao.getPromotionByTitle(promotionTitle, pageIndex);

        // count number of pages
        int total = promotionDao.getTotalPromotionByTitle(promotionTitle);
        int endPage = (int) Math.ceil((double) total / 3);

        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        if (promotionList.size() == 0) {
            String searchMess = "No data to show!";
            request.setAttribute("searchMess", searchMess);
            request.getRequestDispatcher("AdminListPromotion.jsp").forward(request, response);
        } else {
            request.setAttribute("promotionList", promotionList);
            request.getRequestDispatcher("AdminListPromotion.jsp").forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
