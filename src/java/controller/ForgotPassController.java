/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author NITRO
 */
public class ForgotPassController extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user=request.getParameter("user");
        String email=request.getParameter("email");
        String question = request.getParameter("question");
        String newPass=request.getParameter("newpass");
        String reNewPass=request.getParameter("renewpass");
       
     
        AccountDAO accDao=new AccountDAO();
        
        if(!newPass.equals(reNewPass)){
            //mật khẩu nhập lại ko giống nhau
            request.setAttribute("mess", "Password does not overlap, please re-enter");
            request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
        }else{
         
            Account acc=accDao.checkLogin(user, email);
            if(acc!=null){
                //nếu tài khoản tồn tại và trùng với email thì cho đổi mật khẩu và hiện thành công
               accDao.ChangePass(newPass, question,email);
                request.setAttribute("messSuccess", "Change password succesfull!");
                request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
            }else{
                //đăng ký ko thành công đẩy về trang forget vì không tồn tại
                request.setAttribute("mess", "Question incorect!!");
                request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
            }
        }
    }

 
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
