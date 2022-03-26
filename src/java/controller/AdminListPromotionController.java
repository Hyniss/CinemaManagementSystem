/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPromotionDAO;
import dao.impl.PromotionDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promotion;

/**
 * Document : AdminListPromotionController Created on : 13-Feb-2022, 04:38:41
 *
 * @author Bảo Châu Bống
 */
// Admin can see the list of Promotion and CRUD
public class AdminListPromotionController extends HttpServlet {

    // Calling method of database
    IPromotionDAO promotionDao = new PromotionDAO();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        
//        // Get data from database and transfer in parameter
//        List<Promotion> promotionList = promotionDao.getAllPromotion();
//        
//        // Set Attribute
//        request.setAttribute("promotionList", promotionList);
//        
//        // Lead to AdminPromotionList.jsp
//        request.getRequestDispatcher("AdminPromotionList.jsp").forward(request, response);
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get pageIndex params
        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        // count number of pages
        int total = promotionDao.getTotalPromotion();
        int endPage = (int) Math.ceil((double) total / 5);

        // get list promotion by pageindex
        List<Promotion> promotionList = new ArrayList<>();
        promotionList = promotionDao.pagingPromotion(pageIndex);

        // set properties and send to jsp
        request.setAttribute("promotionList", promotionList);
        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);
        
        request.getRequestDispatcher("AdminListPromotion.jsp").forward(request, response);
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
