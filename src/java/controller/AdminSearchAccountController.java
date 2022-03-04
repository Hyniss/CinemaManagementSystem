/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAO;
import dao.IAccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author HP
 */
public class AdminSearchAccountController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //get search txt
        String accSubUsername = request.getParameter("searchtxt").trim();

        if (accSubUsername.equals("")) {
            String searchMess = "This field can not empty!";
            request.setAttribute("searchMess", searchMess);
            request.setAttribute("total", 0);
            request.getRequestDispatcher("AdminManageAccount.jsp").forward(request, response);
        } else {

            //get list account bu search txt
            List<Account> accountList = new ArrayList<>();
            accountList = accountDao.getUserAccountBySubUsername(accSubUsername);
            if (accountList.size() == 0) {
                String searchMess = "No data to show!";
                request.setAttribute("searchMess", searchMess);
                request.setAttribute("total", 0);
                request.getRequestDispatcher("AdminManageAccount.jsp").forward(request, response);
            } else {

                //set properties and send to jsp
                request.setAttribute("total", accountList.size());
                request.setAttribute("accountList", accountList);
                request.getRequestDispatcher("AdminManageAccount.jsp").forward(request, response);
            }
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
