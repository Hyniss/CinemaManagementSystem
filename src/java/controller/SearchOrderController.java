/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IOrder;
import dao.impl.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;

/**
 *
 * @author TIEN HUY
 */
@WebServlet(name = "SearchOrderController", urlPatterns = {"/SearchOrder"})
public class SearchOrderController extends HttpServlet {

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
             HttpSession session = request.getSession();
             Account acc = (Account)session.getAttribute("acc");
          try{
          IOrder order = new OrderDAO();
          Date check = Date.valueOf(request.getParameter("searchdate"));
          
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String date = dateFormat.format(check);  
      
          String index = request.getParameter("pageIndex");
           if(index == null) index = "1";
          
        int pageIndex = Integer.parseInt(index);
         int total =  order.getTotalOrderByDate(acc.getUsername(),date);
         int endPage = (int) Math.ceil((double)total/3);
          
        ArrayList<Cart> orderList = order.getMyOrderByDate(acc.getUsername(),date, pageIndex);
         if (orderList.size() == 0) {
                String searchMess = "No data to show!";
                request.setAttribute("searchMess", searchMess);
            }
        session.setAttribute("order", orderList);
        request.setAttribute("total1", total);
        request.setAttribute("endPage1", endPage);
        request.setAttribute("pageIndex1", pageIndex);
        request.setAttribute("searchdate", date);
          }catch(Exception e){
              Logger.getLogger(MyOrderController.class.getName()).log(Level.SEVERE, null, e);
          }
        request.getRequestDispatcher("MyOrder.jsp").forward(request, response);
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
