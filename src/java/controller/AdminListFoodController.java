/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.FoodDAO;
import dao.IFoodDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FoodAndDrink;

/**
 * Documentation: AdminListFoodConntroller Created on: 13-Feb-2022, 08:41:21
 *
 * @author Nguyễn Tiến Huy
 */
// Admin can see the list of Banner and do CRUD
//url
@WebServlet(name = "AdminListFoodController", urlPatterns = {"/AdminListFood"})
public class AdminListFoodController extends HttpServlet {

    IFoodDAO foodDAO = new FoodDAO();
// protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       //create object
//        IFoodDAO foodDAO = new FoodDAO();
//        //create list with datatype is FoodAndDrink and call method from foodDAO for variable list
//        List<FoodAndDrink> foodList = foodDAO.getAllFood();
//        // Set Attribute
//        request.setAttribute("foodList", foodList);
//        // Lead to AdminBannerList.jsp
//        request.getRequestDispatcher("AdminListFood.jsp").forward(request, response);
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
        int total = foodDAO.getTotalFood();
        int endPage = (int) Math.ceil((double) total / 3);

        // get list banner by pageindex
        List<FoodAndDrink> foodList = new ArrayList<>();
        foodList = foodDAO.pagingFood(pageIndex);

        // set properties and send to jsp
        request.setAttribute("foodList", foodList);
        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        //List<Banner> bannerList = bannerDao.getAllBanner();
//
//        // Set Attribute
        // request.setAttribute("bannerList", bannerList);
        request.getRequestDispatcher("AdminListFood.jsp").forward(request, response);
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
