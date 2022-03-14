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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Tạ Văn Tân
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Lấy ra account vừa đăng nhập vào bằng session
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        //Lấy dữ liệu từ request
        String oldPass = request.getParameter("pass");
        String newPass = request.getParameter("newpass");
        String reNewPass = request.getParameter("renewpass");

        IAccountDAO accountDAO = new AccountDAO();

        if (!newPass.equals(reNewPass)) {
            request.setAttribute("oldpass", oldPass);
            request.setAttribute("newpass", newPass);
            request.setAttribute("renewpass", reNewPass);
            //mật khẩu nhập lại ko giống nhau
            request.setAttribute("mess", "Password does not overlap, please re-enter");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        } else {

            Account account = accountDAO.getAccountByUsernameAndPassword(acc.getUsername(), oldPass);
            if (account != null) {
                //nếu tài khoản tồn tại thì cho đổi mật khẩu
                if (Validate.checkPassword(newPass) == false) {
                    //nhập sai dữ liệu trả lại dữ liệu về trang để đỡ phải nhập lại
                    request.setAttribute("oldpass", oldPass);
                    request.setAttribute("newpass", newPass);
                    request.setAttribute("renewpass", reNewPass);
                    //kiểm tra đầu vào cho Password mới nhập vào          
                    request.setAttribute("mess", "Password phải có ít nhất 6 đến 8 ký tự và có ít nhất 1 ký"
                            + " tự chữ thường, chữ hoa, số và ký tự đặc biệt !! ");
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);

                } else {
                    accountDAO.updatePassword(newPass, oldPass, acc.getUsername());
                    request.setAttribute("messSuccess", "Change password succesfull!");
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("oldpass", oldPass);
                request.setAttribute("newpass", newPass);
                request.setAttribute("renewpass", reNewPass);
                //đăng ký không thành công đẩy về trang signup vì mật khẩu cũ không đúng
                request.setAttribute("mess", "Mật khẩu cũ ko đúng!!");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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

