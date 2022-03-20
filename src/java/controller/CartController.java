/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.PromotionDAO;
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
import model.FoodAndDrinkCart;
import model.Promotion;

/**
 *
 * @author TIEN HUY
 */
@WebServlet(name = "CartController", urlPatterns = {"/Cart"})
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        // Session
        HttpSession session = request.getSession();
        // create any variable
        int pos = 0;
        int iteams;
        double total = 0;
        double totalFood = 0;
        double totalSeat = 0;
        int count = 0;
//        session.getAttribute("totalPrice");
         // get Attribute from Session
        session.getAttribute("totalFoodPrice");
        session.getAttribute("totalSeatPrice");
        session.getAttribute("quantityFood");
        int totalQuantitySeat = (int) session.getAttribute("quantitySeat");
        //Using try cath to discarded exceptional
        try {
            totalSeat = (double) session.getAttribute("totalSeatPrice");
        } catch (Exception e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            totalFood = (double) session.getAttribute("totalFoodPrice");
        } catch (Exception e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            session.setAttribute("list", session.getAttribute("listcheckedSeatId"));
        } catch (Exception e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
        }
        // get Attribute a list have datatype FoodAndDrinkCart
        ArrayList<FoodAndDrinkCart> listFoodCarts = (ArrayList<FoodAndDrinkCart>) request.getSession().getAttribute("listFoodCarts");
        //get total quantity of Food
        if (listFoodCarts != null) {
            for (int j = 0; j < listFoodCarts.size(); j++) {
                pos += listFoodCarts.get(j).getQuantity();

            }

        }
        // total iteams in cart
        iteams = pos + totalQuantitySeat;
        //setAttribute in store session
        session.setAttribute("pos", pos);
        session.setAttribute("iteams", iteams);
        if (session.getAttribute("totalFoodPrice") == null) {
            totalFood = 0;
        }
        //Total price
        total = totalSeat + totalFood;
        session.setAttribute("total", total);
        try {
            //get Parameter from Cart.jsp
            String magiam = request.getParameter("magiam");
            //call method in  PromotionDAO
            PromotionDAO proDAO = new PromotionDAO();
            Promotion pro = proDAO.discount(magiam);
            
           
            
//             if (pro == null && !magiam.equals("")) {
//
//                session.setAttribute("error", "Error");
//            }else if(pro == null && magiam.equals("")){
//                session.setAttribute("soso", "Nhập mã nếu có");
//            }else {
//                session.setAttribute("success", "Success");
//            }
            if(pro != null){
                request.setAttribute("success", "thành công");
                count++;
                session.setAttribute("c", count);
            }else if(magiam.isEmpty())
            {
                request.setAttribute("so", "");
            }
            else{
                request.setAttribute("error", "thất bại");
            }
            //caculator about discount
            double disc = (total * Integer.parseInt(pro.getDiscount())) / 100;
            //last price
            double dis = total - disc;
            //set atribute value last price,display value discount
            session.setAttribute("discount", pro.getDiscount());
            session.setAttribute("dis", dis);
           
        } catch (Exception e) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, e);
        }
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
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