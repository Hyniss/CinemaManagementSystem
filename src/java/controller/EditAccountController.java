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
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Thai Tran
 */
//user can edit properites of account
public class EditAccountController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        
        response.sendRedirect("EditAccountDetail.jsp");
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
        String username = request.getParameter("username").replaceAll("\\s+", " ").trim();;
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar").replaceAll("\\s+", " ").trim();;
        String fullname = request.getParameter("fullname").replaceAll("\\s+", " ").trim();;
        Date dob = Date.valueOf(request.getParameter("dob"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int roleid = Integer.parseInt(request.getParameter("roleid"));

        //set popeties into new account
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setAvatar(avatar);
        account.setFullName(fullname);
        account.setDob(dob);
        account.setEmail(email.trim());
        account.setPhone(phone);
        account.setRoleId(roleid);

        String mess = "";
        if (Validate.checkFullName(fullname) == false) {
            mess = "Th??ng tin fullname kh??ng h???p l???";
        } else if (Validate.checkUserName(username) == false) {
            mess = "Username ph???i c?? ??t nh???t 6 k?? t??? kh??ng bao g???m k?? t??? ?????c bi???t";
        } else if (Validate.checkPassword(password) == false) {
            mess = "Password ph???i c?? ??t nh???t 6 ?????n 8 k?? t??? v?? c?? ??t nh???t 1 ky t??? ch??? th?????ng, ch??? hoa, s??? v?? k?? t??? ?????c bi???t";
        } else if (Validate.checkAccountDob((Date) account.getDob()) == false) {
            mess = "Ng??y sinh kh??ng h???p l???";
        } else if (Validate.checkEmail(email) == false) {
            mess = "Vui l??ng nh???p email c?? d???ng example@xxx.xxx(.xxx)";
        } else if (Validate.checkPhone(phone) == false) {
            mess = "S??? ??i???n tho???i kh??ng h???p l???";
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

        //get properties and getRequestDispatcher to AccountDetail.jsp
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        session.setAttribute("acc", account);
        request.getRequestDispatcher("EditAccountDetail.jsp").forward(request, response);
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
