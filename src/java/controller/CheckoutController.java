/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IFoodCartDAO;
import dao.IOrder;
import dao.ISeatRoomCartDAO;
import dao.ISeatRoomDAO;
import dao.impl.FoodCartDAO;
import dao.impl.OrderDAO;
import dao.impl.SeatRoomCartDAO;
import dao.impl.SeatRoomDAO;
import java.io.IOException;
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
import model.FoodAndDrinkCart;
import model.MovieRoom;
import model.Seat;
import model.SeatRoom;
import model.SeatRoomCart;
import model.TimeRoom;

/**
 *
 * @author tenhik
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/checkout"})
public class CheckoutController extends HttpServlet {

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
        ISeatRoomDAO seatRoomDAO = new SeatRoomDAO();
        IOrder orderDAO = new OrderDAO();
        ISeatRoomCartDAO seatRoomCartDAO = new SeatRoomCartDAO();
        IFoodCartDAO foodAndDrinkCartDAO = new FoodCartDAO();

        Boolean statusSeatRoom = true;
        String statusCart = "false";
        int seatRoomId = 0;
        double totalFoodPrice = 0;
        int orderId = 0;
        double total = 0;
        ArrayList<FoodAndDrinkCart> listFoodChecked = new ArrayList<>();
        ArrayList<Seat> listSeatChecked = (ArrayList<Seat>) session.getAttribute("listcheckedSeatId");
        TimeRoom timeRoom = (TimeRoom) session.getAttribute("timeRoom");
        MovieRoom movieRoom = (MovieRoom) session.getAttribute("statusCart");
        Account account = (Account) session.getAttribute("acc");
        try {
            listFoodChecked = (ArrayList<FoodAndDrinkCart>) session.getAttribute("listFoodCarts");
        } catch (Exception e) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, e);

        }
        try {
            totalFoodPrice = (Double) session.getAttribute("totalFoodPrice");
        } catch (NumberFormatException e) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, e);

        }
        try {
            total = Double.parseDouble(request.getParameter("total"));
        } catch (NumberFormatException e) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, e);

        }
        if (listSeatChecked != null && timeRoom != null) {
            for (Seat seat : listSeatChecked) {
                SeatRoom addSeatRoom = new SeatRoom(statusSeatRoom, seat.getSeatId(), timeRoom.getTimeRoomId());
                seatRoomId = seatRoomDAO.addSeatRoom(addSeatRoom);
            }
        }
        if (total >= 0 && account != null) {
            Cart cart = new Cart(account.getUsername(), total, statusCart);
            orderId = orderDAO.addToCart(cart);
        }
        if (orderId != 0 && seatRoomId != 0) {
            SeatRoomCart seatRoomCart = new SeatRoomCart(seatRoomId, orderId);
            seatRoomCartDAO.addSeatRoomCart(seatRoomCart);
        }
           
        if (orderId != 0 && listFoodChecked != null) {
            for (FoodAndDrinkCart foodAndDrinkCart : listFoodChecked) {
                FoodAndDrinkCart foodAndDrinkCartAdded = new FoodAndDrinkCart(foodAndDrinkCart.getFoodId(), foodAndDrinkCart.getQuantity(), orderId, totalFoodPrice);
                foodAndDrinkCartDAO.addFoodCart(foodAndDrinkCartAdded);
            }
        }
           
        //remove all session
        session.removeAttribute("listcheckedSeatId");
        session.removeAttribute("listFoodCarts");
        session.removeAttribute("timeRoom");
        session.removeAttribute("movieTime");
        session.removeAttribute("movieRoom");
        session.removeAttribute("movie");
        session.removeAttribute("room");
        session.removeAttribute("quantitySeat");
        session.removeAttribute("totalSeatPrice");
        session.removeAttribute("totalFoodPrice");
        session.removeAttribute("totalPrice");

        response.sendRedirect("MyOrder");
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
