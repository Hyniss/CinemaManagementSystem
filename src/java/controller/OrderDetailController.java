/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.CheckOrder;
import dao.IMovieDAO;
import dao.IMovieTimeDAO;
import dao.IOrder;
import dao.IRoomDAO;
import dao.IShowtimesDAO;
import dao.ITimeRoomDAO;
import dao.impl.MovieDAO;
import dao.impl.MovieTimeDAO;
import dao.impl.OrderDAO;
import dao.impl.RoomDAO;
import dao.impl.ShowtimesDAO;
import dao.impl.TimeRoomDAO;
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
import javax.servlet.http.HttpSession;
import model.Account;
import model.Cart;
import model.FastFoodCart;
import model.SeatRoom;
import model.SeatRoomCart;
import model.FoodAndDrink;
import model.FoodAndDrinkCart;
import model.Movie;
import model.MovieRoom;
import model.MovieTime;
import model.Room;
import model.TimeRoom;

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
        HttpSession session = request.getSession();
        String id = request.getParameter("cartId");
        int cId = Integer.parseInt(id);
        IOrder order = new OrderDAO();
        //moi lam
        ITimeRoomDAO tmd = new TimeRoomDAO();
        IMovieDAO mvd = new MovieDAO();
        IRoomDAO rd = new RoomDAO();
        IMovieTimeDAO mtd = new MovieTimeDAO();
        IShowtimesDAO std = new ShowtimesDAO();
        //
        ArrayList<SeatRoom> seatDetails = new ArrayList<>();
        ArrayList<FastFoodCart> foodList = new ArrayList<>();
        ArrayList<FoodAndDrink> foodDetails = new ArrayList<>();
        //moi lam
        ArrayList<TimeRoom> timeRoomList = new ArrayList<>();
        CheckOrder check = new CheckOrder();
        ArrayList<Cart> details;
        double giadoan = 0;
        int quan = 0;
        double priceseat = 0;
        int count = 0;
        //moi lam
         TimeRoom timeRoom = new TimeRoom();
         Movie movie;
         FoodAndDrink foodDetail;
         Room room;
         MovieTime movieTime;
         MovieRoom movieRoom;
         //
        Account acc1 = (Account) session.getAttribute("acc");
        String acc2 = request.getParameter("username");
        details = (ArrayList<Cart>) session.getAttribute("order");

        try {
            if (acc1.getUsername().equals(acc2) && check.CheckId(details, cId)) {
                try {
                    ArrayList<SeatRoomCart> seatList = order.getOrderSeatById(Integer.parseInt(id));
                    for (SeatRoomCart seatRoomCart : seatList) {
                        SeatRoom seatDetail = order.getSeatById(seatRoomCart.getSeatRoomId());
                        count++;
                        seatDetails.add(seatDetail);

                    }
                    priceseat = 55000 * count;
                    request.setAttribute("priceseat", priceseat);
                    request.setAttribute("quanseat", count);
                    request.setAttribute("seatDetails", seatDetails);
                } catch (Exception e) {
                    Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, e);
                }
                try {
                    foodList = order.getOrderFoodById(cId);
                    if (foodList.isEmpty()) {
                        foodDetail = order.getFoodById(0);
                        giadoan = 0;
                        quan = 0;
                        foodDetails.add(foodDetail);
                    } else {
                        for (FastFoodCart fastFoodCart : foodList) {
                            foodDetail = order.getFoodById(fastFoodCart.getFoodId());
                            giadoan += fastFoodCart.getPrice();
                            quan += fastFoodCart.getQuantity();
                            foodDetails.add(foodDetail);

                        }
                    }
                    request.setAttribute("foodDetails", foodDetails);
                    request.setAttribute("foodList", foodList);
                    request.setAttribute("giadoan", giadoan);
                    request.setAttribute("quan", quan);
                } catch (Exception e) {
                    Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, e);
                }
                
                //truy xuất tới bảng timeroomid
                for(SeatRoom seatroom : seatDetails){
                    timeRoom = tmd.getTimeRoom(seatroom.getTimeRoomId());
                    timeRoomList.add(timeRoom);
                }
                //lay movie
                movie = mvd.getMovieById(timeRoom.getMovieId());
                request.setAttribute("movie", movie);
                //lay room
                room = rd.room(timeRoom.getRoomId());
                request.setAttribute("room", room);
                //lay thoi gian bat dau
                movieTime =mtd.getMovieTime(timeRoom.getTimeId());
                request.setAttribute("movieTime", movieTime);
                //lay ngay
                movieRoom = std.getShowtimes(movieTime.getMovieRoomId());
                request.setAttribute("date",  movieRoom);
            } else {
                String searchMess = "No data to show!";
                request.setAttribute("searchMess", searchMess);
            }
        } catch (Exception e) {
            Logger.getLogger(OrderDetailController.class.getName()).log(Level.SEVERE, null, e);
        }
        request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
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