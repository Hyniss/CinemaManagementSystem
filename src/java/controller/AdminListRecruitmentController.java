/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ICVInforDAO;
import dao.IRecruitmentDAO;
import dao.impl.CVInforDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CVInfor;
import model.Recruitment;

/**
 * Documentation : AdminListRecruitmentController Created on : 27-Feb-2022,
 * 01:12:48
 *
 * @author Bảo Châu Bống
 */
// Admin can see the list of Recruitment and CRUD
public class AdminListRecruitmentController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

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
        int total = recruitmentDao.getTotalRecruitment();
        int endPage = (int) Math.ceil((double) total / 3);

        // get list recruitment by pageindex
        List<Recruitment> recruitmentList = new ArrayList<>();
        recruitmentList = recruitmentDao.pagingRecruitment(pageIndex);

        // set properties and send to jsp
        request.setAttribute("recruitmentList", recruitmentList);
        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        request.getRequestDispatcher("AdminListRecruitment.jsp").forward(request, response);
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
