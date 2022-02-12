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
        String user=request.getParameter("user");
        String oldPass=request.getParameter("pass");
        String newPass=request.getParameter("newpass");
        String reNewPass=request.getParameter("renewpass");
       
     
        AccountDAO accDao=new AccountDAO();
        
        if(!newPass.equals(reNewPass)){
            //mật khẩu nhập lại ko giống nhau
            request.setAttribute("mess", "Password does not overlap, please re-enter");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }else{
         
            Account acc=accDao.checkPassword(user,oldPass);
            if(acc!=null){
                //nếu tài khoản tồn tại thì cho đổi mật khẩu
                accDao.changePassword(newPass, oldPass, user);
                request.setAttribute("messSuccess", "Change password succesfull!");
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }else{
                //đăng ký ko thành công đẩy về trang signup vì tài khoản đã tồn tại
                request.setAttribute("mess", "Username or password not exist!!");
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
