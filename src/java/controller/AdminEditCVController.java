/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ICVInforDAO;
import dao.impl.CVInforDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CVInfor;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminEditCVController extends HttpServlet {

    ICVInforDAO cvInforDao = new CVInforDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

       String id = request.getParameter("id");
        
        // Get value from database
        CVInfor cvInforList = cvInforDao.getCV(Integer.parseInt(id));
        
        // Set Attribute
        request.setAttribute("cvInforList", cvInforList);
        
        // Lead to AdminEditPromotion.jsp
        request.getRequestDispatcher("AdminCVInforList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Calling method
        CVInfor cvInforList = new CVInfor();

        // Set Parameter
        cvInforList.setStatus(request.getParameter("new_status"));

        // Edit value from Database
        cvInforDao.editCV(cvInforList);

        // Lead to Page that show the list of promotion
        response.sendRedirect(request.getContextPath() + "/admincvlist");
    }

}
