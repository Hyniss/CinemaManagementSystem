/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.impl.AccountDAO;
import dao.IAccountDAO;
import dao.IRoleDAO;
import dao.impl.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Role;

/**
 *
 * @author HP
 */
public class AdminAddAccountController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();
    IRoleDAO roleDao = new RoleDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminAddAccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddAccountController at " + request.getContextPath() + "</h1>");
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

        //get role list from database
        ArrayList<Role> roleList = roleDao.getAllRole();

        //set attribute and send to jsp
        request.setAttribute("roleList", roleList);
        request.getRequestDispatcher("AdminAddAccount.jsp").forward(request, response);

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
        String password = request.getParameter("password").replaceAll("\\s+", " ").trim();
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
        account.setPhone(phone.trim());
        account.setRoleId(roleid);

        //check constraint and store in mess
        String mess = "";
        if (accountDao.getAccountByUsername(account.getUsername()) != null) {
            mess = "Username ???? t???n t???i";
        } else if (Validate.checkUserName(account.getUsername()) == false) {
            mess = "Username ph???i c?? ??t nh???t 6 k?? t??? kh??ng bao g???m k?? t??? ?????c bi???t";
        } else if (Validate.checkPassword(account.getPassword()) == false) {
            mess = "Password ph???i c?? ??t nh???t 6 ?????n 8 k?? t??? v?? c?? ??t nh???t 1 ky t??? ch??? th?????ng, ch??? hoa, s??? v?? k?? t??? ?????c bi???t";
        } else if (Validate.checkFullName(account.getFullName()) == false) {
            mess = "Th??ng tin fullname kh??ng h???p l???";
        } else if (Validate.checkAccountDob((Date) account.getDob()) == false) {
            mess = "Ng??y sinh kh??ng h???p l???";
        } else if (Validate.checkEmail(account.getEmail()) == false) {
            mess = "Vui l??ng nh???p email c?? d???ng example@xxx.xxx(.xxx)";
        } else if (Validate.checkPhone(account.getPhone()) == false) {
            mess = "S??? ??i???n tho???i ph???i kh??ng h???p l???";
        } else {

            //edit account
            boolean check = accountDao.insertAccount1(account);
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

        //get properties and getRequestDispatcher to AccountDetail.jsp
        ArrayList<Role> roleList = roleDao.getAllRole();
        request.setAttribute("roleList", roleList);
        request.setAttribute("account", account);
        request.getRequestDispatcher("AdminAddAccount.jsp").forward(request, response);
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
