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
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author NITRO
 */
public class LoginController extends HttpServlet {

    IAccountDAO accountDao = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        Account a = accountDao.login(username, password);
        if (a == null) {
            //nêu a bằng null thì gửi 1 câu thông báo về trang login là ko thành công
            request.setAttribute("mess", "Wrong user or pass");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        } else {
            //còn nếu a khac null nghĩa là tài khoản tồn tại đăng nhập thành công và trả về trang home
            HttpSession session = request.getSession();
            //lưu a lên trên session khi a tồn tại
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(10000);//đặt thời gian lưu cho session
            request.getRequestDispatcher("home").forward(request, response);
        }
    }
}
