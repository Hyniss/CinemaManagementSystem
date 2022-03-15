/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.INotificationDAO;
import dao.impl.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Notification;

/**
 *
 * @author HP
 */
public class AdminSearchNotificationController extends HttpServlet {

    INotificationDAO notificationDAO = new NotificationDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //get search txt
        String notificationTitle = request.getParameter("searchtxt").replaceAll("\\s+", " ").trim();
        request.setAttribute("searchtxt", notificationTitle);

        //get pageindex params
        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        //get list account bu search txt
        List<Notification> notificationtList = new ArrayList<>();
        notificationtList = notificationDAO.getNotificationByTitle(notificationTitle, pageIndex);

        //count number of pages
        int total = notificationDAO.getTotalNotificationByTitle(notificationTitle);
        int endPage = (int) Math.ceil((double) total / 5);

        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        if (notificationtList.size() == 0) {
            String searchMess = "No data to show!";
            request.setAttribute("searchMess", searchMess);
            request.getRequestDispatcher("AdminManageNotification.jsp").forward(request, response);
        } else {

            //set properties and send to jsp
            request.setAttribute("notificationList", notificationtList);
            request.getRequestDispatcher("AdminManageNotification.jsp").forward(request, response);
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
