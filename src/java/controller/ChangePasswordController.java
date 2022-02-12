/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
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
public class ChangePasswordController extends HttpServlet {

    AccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String oldPass = request.getParameter("pass");
        String newPass = request.getParameter("newpass");
        String reNewPass = request.getParameter("renewpass");

        if (!newPass.equals(reNewPass)) {
            //mật khẩu nhập lại ko giống nhau
            request.setAttribute("mess", "Password does not overlap, please re-enter");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } else {

            Account acc = accountDao.checkPassword(user, oldPass);
            if (acc != null) {
                //nếu tài khoản tồn tại thì cho đổi mật khẩu
                accountDao.changePassword(newPass, oldPass, user);
                request.setAttribute("messSuccess", "Change password succesfull!");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            } else {
                //đăng ký ko thành công đẩy về trang signup vì tài khoản đã tồn tại
                request.setAttribute("mess", "Username or password not exist!!");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }
        }
    }
}
