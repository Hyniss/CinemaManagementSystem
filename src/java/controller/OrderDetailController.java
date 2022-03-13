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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SeatRoom;
import model.SeatRoomCart;

/**
 *
 * @author TIEN HUY
 */
@WebServlet(name = "OrderDetailController", urlPatterns = {"/OrderDetail"})
public class OrderDetailController extends HttpServlet {

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
        String id = request.getParameter("cartId");
        int cId = Integer.parseInt(id);
        IOrder order = new OrderDAO();
         ArrayList<SeatRoom> seatDetails = null;
          int dis;
        try{
//            ArrayList<SeatRoomCart> seatList = order.getOrderSeatById(Integer.parseInt(id));
//            for (SeatRoomCart seatRoomCart : seatList) {
//                 dis =seatRoomCart.getSeatRoomId();
////                SeatRoom seatDetail = order.getSeatById(dis);
////                 seatDetails.add(seatDetail);
//            } 
            //                SeatRoom seatDetail = order.getSeatById(dis);
        }catch(Exception e){
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
//        for (SeatRoom seatDetail : seatDetails) {
//            System.out.println(seatDetail.getSeatId());
//        }
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
