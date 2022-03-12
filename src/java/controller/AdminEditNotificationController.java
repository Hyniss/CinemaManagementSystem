/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.INotificationDAO;
import dao.impl.NotificationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Notification;

/**
 *
 * @author HP
 */
public class AdminEditNotificationController extends HttpServlet {

    INotificationDAO notificationDAO = new NotificationDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminEditNotificationController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditNotificationController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //get id param from jsp
        int id = Integer.parseInt(request.getParameter("notiId"));
        Notification notification = notificationDAO.getNotificationById(id);

        LocalDate curdate = LocalDate.now();
        Date currentdate = Date.valueOf(curdate);
        request.setAttribute("currentdate", currentdate);

        //set attribute and send to jsp
        request.setAttribute("notification", notification);
        request.getRequestDispatcher("AdminEditNotification.jsp").forward(request, response);
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

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //get notification properites from jsp
        int notiId = Integer.parseInt(request.getParameter("notiId"));
        String img = request.getParameter("img");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Date date = Date.valueOf(request.getParameter("date"));

        //set popeties into new notification
        Notification notification = new Notification();
        notification.setNotificationId(notiId);
        notification.setNotificationImg(img.trim());
        notification.setNotificationTitle(title.trim());
        notification.setNotificationDescription(description.trim());
        notification.setNotificationDate(date);;

        //check constraint and store in mess
        String mess = "";
        if (Validate.checkString(notification.getNotificationImg(), 6, 50) == false) {
            mess = "Image không hợp lệ";
        } else if (Validate.checkString(notification.getNotificationTitle(), 6, 250) == false) {
            mess = "Title ít nằm trong khoảng 6 đến 250 ký tự";
        } else if (Validate.checkString(notification.getNotificationDescription(), 6, 2500) == false) {
            mess = "Description nằm trong khoảng 6 đến 2500 ký tự";
        } else {

            //edit account
            boolean check = notificationDAO.editNotification(notification);
            //get edit status through check variable
            if (check == true) {
                String successMessage = "Edit successfully!";
                request.setAttribute("successMessage", successMessage);

            } else {
                String failMessage = "Edit failed!";
                request.setAttribute("failMessage", failMessage);
            }
        }

        request.setAttribute("mess", mess);

        //get properties and getRequestDispatcher to NotificationDetail.jsp
        LocalDate curdate = LocalDate.now();
        Date currentdate = Date.valueOf(curdate);
        request.setAttribute("currentdate", currentdate);

        request.setAttribute("notification", notification);
        request.getRequestDispatcher("AdminEditNotification.jsp").forward(request, response);

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
