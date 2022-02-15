/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.IAccountDAO;
import java.io.IOException;
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

//user can edit properites of account

public class EditAccountController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //get account properites from jsp
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String fullname = request.getParameter("fullname");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int roleid = Integer.parseInt(request.getParameter("roleid"));

        //set popeties into new account
        Account account = new Account();
        account.setUsername(username.trim());
        account.setPassword(password);
        account.setAvatar(avatar.trim());
        account.setFullName(fullname.trim());
        account.setDob(dob);
        account.setEmail(email.trim());
        account.setPhone(phone.trim());
        account.setRoleId(roleid);

        //edit account
        boolean check = accountDao.editAccount(account);
        
        //get edit status through check variable
        if(check == true){
            String successMessage = "Edit successfully!";
            request.setAttribute("successMessage", successMessage);
            
        } else {
            String failMessage = "Edit failed!";
            request.setAttribute("failMessage", failMessage);
        }
        
        //get properties and getRequestDispatcher to AccountDetail.jsp
        request.setAttribute("account", account);
        request.getRequestDispatcher("AccountDetail.jsp").forward(request, response);
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
