/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.impl.AccountDAO;
import dao.IAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author HP
 */
public class AdminEditAccountController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminEditAccount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminEditAccount at " + request.getContextPath() + "</h1>");
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

        //get username param from jsp
        String username = request.getParameter("username");
        Account account = accountDao.getAccountByUsername(username);

        //set attribute and send to jsp
        request.setAttribute("account", account);
        request.getRequestDispatcher("AdminEditAccount.jsp").forward(request, response);
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

        //get account properites from jsp
        String username = request.getParameter("username").replaceAll("\\s+", " ").trim();
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar").replaceAll("\\s+", " ").trim();
        String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();
        Date dob = Date.valueOf(request.getParameter("dob"));
        String email = request.getParameter("email").replaceAll("\\s+", " ").trim();
        String phone = request.getParameter("phone");
        int roleid = Integer.parseInt(request.getParameter("roleid"));

        //set popeties into new account
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAvatar(avatar);
        account.setFullName(fullname);
        account.setDob(dob);
        account.setEmail(email);
        account.setPhone(phone);
        account.setRoleId(roleid);

        //check constraint and store in mess
        String mess = "";
        if (Validate.checkUserName(username) == false) {
            mess = "Username phải có ít nhất 6 ký tự không bao gồm ký tự đặc biệt";
        } else if (Validate.checkPassword(password) == false) {
            mess = "Password phải có ít nhất 6 đến 8 ký tự và có ít nhất 1 ky tự chữ thường, chữ hoa, số và ký tự đặc biệt";
        } else if (Validate.checkFullName(fullname) == false) {
            mess = "Thông tin fullname không hợp lệ";
        } else if (Validate.checkAccountDob(dob) == false) {
            mess = "Ngày sinh không hợp lệ";
        } else if (Validate.checkEmail(email) == false) {
            mess = "Vui lòng nhập email có dạng example@xxx.xxx(.xxx)";
        } else if (Validate.checkPhone(phone) == false) {
            mess = "Số điện thoại phải không hợp lệ";
        } else {

            //edit account
            boolean check = accountDao.editAccount(account);

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

        //set properties and getRequestDispatcher to AccountDetail.jsp
        request.setAttribute("account", account);
        request.getRequestDispatcher("AdminEditAccount.jsp").forward(request, response);
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
