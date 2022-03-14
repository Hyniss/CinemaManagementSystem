/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.INotificationAccountDAO;
import dao.INotificationDAO;
import dao.impl.NotificationAccountDAO;
import dao.impl.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Convert;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Notification;
import model.NotificationAccount;

/**
 *
 * @author HP
 */
public class ViewNotificationController extends HttpServlet {

    INotificationAccountDAO notificationaccountDAO = new NotificationAccountDAO();
    INotificationDAO notificationDAO = new NotificationDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //get attribute from jsp
        int notiId = Integer.parseInt(request.getParameter("notiId"));
        Notification notification = notificationDAO.getNotificationById(notiId);
        request.setAttribute("notification", notification);

        HttpSession session = request.getSession(false);
        Account account = (Account) session.getAttribute("acc");
        
        //edit readed of NotificationAccount
        boolean check = notificationaccountDAO.editReaded(notiId, account.getUsername());

        //GET NOTIFICATION
        ArrayList<NotificationAccount> notificationaccountList = notificationaccountDAO.get5Notification(account.getUsername());
        request.setAttribute("notificationaccountList", notificationaccountList);

        HashMap<Notification, NotificationAccount> notiHashMap = new HashMap<>();
        ArrayList<Notification> notificationList = new ArrayList<Notification>();
        int unreadednoti = 0;
        for (NotificationAccount notificationAccount : notificationaccountList) {
            Notification noti = notificationDAO.getNotificationById(notificationAccount.getNotificationId());
            notiHashMap.put(noti, notificationAccount);
            if (!notificationAccount.isReaded()) {
                unreadednoti++;
            }
        }
        
        //romove old session
        session.removeAttribute("notiHashMap");
        session.removeAttribute("unreadednoti");
        //add new session
        session.setAttribute("notiHashMap", notiHashMap);
        session.setAttribute("unreadednoti", unreadednoti);
        
        //get request dispatcher to jsp
        request.getRequestDispatcher("NotificationDetail.jsp").forward(request, response);

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
