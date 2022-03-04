/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAO;
import dao.IAccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;

/**
 *
 * @author Tạ Văn Tân
 */
public class LoginController extends HttpServlet {

    IAccountDAO accountDAO = new AccountDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        //lay ra user, pass tu cookie
        Cookie arr[] = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("userC")) {
                    request.setAttribute("username", o.getValue());

                }
                if (o.getName().equals("passC")) {
                    request.setAttribute("password", o.getValue());

                }
            }
        }

        request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        // lấy giá trị username từ request mà người dùng nhập và xóa đi khoảng trắng đầu và cuối
        String username = request.getParameter("user").trim();

        String password = request.getParameter("pass"); // lấy giá trị password từ request mà người dùng nhập
        String remember = request.getParameter("remember");
        Account a = accountDAO.getAccountByUsernameAndPassword(username, password);
        if (a == null) {
            //nêu a bằng null thì gửi 1 câu thông báo về trang login là ko thành công
            request.setAttribute("mess", "Wrong user or pass");
            request.getRequestDispatcher("Login.jsp").forward(request, response);

        } else {
            //còn nếu a khac null nghĩa là tài khoản tồn tại đăng nhập thành công và trả về trang home
            HttpSession session = request.getSession();
            //lưu a lên trên session khi a tồn tại
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(60 * 60 * 24);//đặt thời gian tồn tại cho session

            //Tao cookie de luu tai khoan
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC", password);
            u.setMaxAge(60 * 60 * 24 * 30);// set thoi gian ton tai cho tai khoan cookie 30 ngay
            if (remember != null) {
                p.setMaxAge(60 * 60 * 24 * 30);
            } else {
                p.setMaxAge(0);
            }

            response.addCookie(u);// luu account vao cookie
            response.addCookie(p);
            if (a.getRoleId() == 1) {
                response.sendRedirect("adminhome");
            } else {
                response.sendRedirect("home");
            }
        }
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
