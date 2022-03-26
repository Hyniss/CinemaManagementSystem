/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IRecruitmentDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recruitment;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminSearchRecruitmentController extends HttpServlet {

    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // get search txt
        String recruitmentTitle = request.getParameter("searchtxt").replaceAll("\\s+", " ").trim();
        request.setAttribute("searchtxt", recruitmentTitle);

        // get pageindex params
        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        // get list banner by search txt
        List<Recruitment> recruitmentList = new ArrayList<>();
        recruitmentList = recruitmentDao.getRecruitmentByTitle(recruitmentTitle, pageIndex);

        // count number of pages
        int total = recruitmentDao.getTotalRecruitmentByTitle(recruitmentTitle);
        int endPage = (int) Math.ceil((double) total / 5);

        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        if (recruitmentList.size() == 0) {
            String searchMess = "No data to show!";
            request.setAttribute("searchMess", searchMess);
            request.getRequestDispatcher("AdminListRecruitment.jsp").forward(request, response);
        } else {
            request.setAttribute("recruitmentList", recruitmentList);
            request.getRequestDispatcher("AdminListRecruitment.jsp").forward(request, response);
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
