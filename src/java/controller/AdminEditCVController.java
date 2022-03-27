/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ICVInforDAO;
import dao.IStatusDAO;
import dao.impl.CVInforDAO;
import dao.impl.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CVInfor;
import model.Status;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminEditCVController extends HttpServlet {

    ICVInforDAO cvInforDao = new CVInforDAO();
    IStatusDAO statusDao = new StatusDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("new_id"));
//        CVInfor cv = cvInforDao.getCV(id);
        int new_status = Integer.parseInt(request.getParameter("new_status"));
//        cv.setStatus(new_status);

        cvInforDao.editCV(new_status, id);

        // get pageIndex params
        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        // count number of pages
        int total = cvInforDao.getTotalCV();
        int endPage = (int) Math.ceil((double) total / 5);

        // get list cv by pageindex
        List<CVInfor> cvList = new ArrayList<>();
        cvList = cvInforDao.pagingCV(pageIndex);

        request.setAttribute("cvList", cvList);
        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        List<CVInfor> cvInforList = cvInforDao.getAllCV();
        //List<CVInfor> cvStatusList = cvInforDao.getAllStatus();
        List<Status> statusList = statusDao.getAllStatus();

        request.setAttribute("statusList", statusList);
        // request.setAttribute("cvStatusList", cvStatusList);
        request.setAttribute("cvInforList", cvInforList);
        request.getRequestDispatcher("AdminCVInforList.jsp").forward(request, response);
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
