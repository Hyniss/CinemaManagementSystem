/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDAO;
import dao.IBannerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;

/**
 * Document: AdminAddBannerController
 * Created on: 
 * @author Bảo Châu Bống
 */

//  Admin can add new Banner

public class AdminAddBannerController extends HttpServlet {
    // 
    IBannerDAO bannerDao = new BannerDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AdminAddBanner.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String new_title = request.getParameter("new_title");
        String new_desc = request.getParameter("new_desc");
        String new_Img = request.getParameter("new_Img");
        
        Banner banner = new Banner();
        banner.setTitle(new_title);
        banner.setImg(new_Img);
        banner.setDesc(new_desc);
        
        bannerDao.addBanner(banner);
        response.sendRedirect(request.getContextPath() + "/adminbannerlist");
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
