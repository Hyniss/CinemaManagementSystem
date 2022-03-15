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
public class AdminAddNotificationController extends HttpServlet {

    INotificationDAO notificationDAO = new NotificationDAO();
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddNotificationController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddNotificationController at " + request.getContextPath() + "</h1>");
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
        
        //set attribute current date
        LocalDate curdate = LocalDate.now();
        Date currentdate = Date.valueOf(curdate);
        request.setAttribute("currentdate", currentdate);
        request.getRequestDispatcher("AdminAddNotification.jsp").forward(request, response);
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
        String img = request.getParameter("img").replaceAll("\\s+", " ").trim();
        String title = request.getParameter("title").replaceAll("\\s+", " ").trim();
        String description = request.getParameter("description").replaceAll("\\s+", " ").trim();
        Date date = Date.valueOf(request.getParameter("date"));

        
        //set popeties into new notificaton
        Notification notification = new Notification();
        notification.setNotificationImg(img);
        notification.setNotificationTitle(title);
        notification.setNotificationDescription(description);
        notification.setNotificationDate(date);

        //check constraint and store in mess
        String mess = "";
        if (Validate.checkString(notification.getNotificationImg(),6,50) == false) {
            mess = "Image không hợp lệ";
        } else if (Validate.checkString(notification.getNotificationTitle(),6,250) == false) {
            mess = "Title ít nằm trong khoảng 6 đến 250 ký tự";
        } else if (Validate.checkString(notification.getNotificationDescription(),6,2500) == false) {
            mess = "Description nằm trong khoảng 6 đến 2500 ký tự";
        } else {

            //edit account
            boolean check = notificationDAO.insertNotification(notification);
            //get edit status through check variable
            if (check == true) {
                String successMessage = "Add successfully!";
                request.setAttribute("successMessage", successMessage);

            } else {
                String failMessage = "Add failed!";
                request.setAttribute("failMessage", failMessage);
            }
        }

        request.setAttribute("mess", mess);

        //get properties and getRequestDispatcher to AdminAddNotification.jsp
        LocalDate curdate = LocalDate.now();
        Date currentdate = Date.valueOf(curdate);
        request.setAttribute("currentdate", currentdate);

        request.setAttribute("notification", notification);
        request.getRequestDispatcher("AdminAddNotification.jsp").forward(request, response);
        
        
        
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

