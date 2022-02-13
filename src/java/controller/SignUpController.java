/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.IAccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author NITRO
 */
public class SignUpController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String phone = request.getParameter("phone");
        String fullname = request.getParameter("fullname");
        if (!pass.equals(repass)) {
            //mật khẩu nhập lại ko giống nhau
            request.setAttribute("mess", "Confirm password does not match!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } else {
            Account a = accountDao.checkAccountExist(user);
            if (a == null) {
                //dc đăng ký
                accountDao.signup(user, pass, fullname, date, email, phone);
                request.setAttribute("messSuccess", "Register succesfull!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                //đăng ký ko thành công đẩy về trang signup vì tài khoản đã tồn tại
                request.setAttribute("mess", "Username already exists!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        }
    }
}
