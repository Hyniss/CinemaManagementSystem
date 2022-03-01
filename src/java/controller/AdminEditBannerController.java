/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BannerDAO;
import dao.IBannerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;

/**
 * Documentation: AdminEditBannerController
 * Created on : 13-Feb-2022, 02:29:34
 * @author Nguyễn Tiến Huy
 */

// Admin can edit the information of Banner

public class AdminEditBannerController extends HttpServlet {

    // Calling method of database
    IBannerDAO bannerDao = new BannerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Get value from database
        Banner banner = bannerDao.get(Integer.parseInt(id));
        
        // Set attribute
        request.setAttribute("banner", banner);
        
        // Lead to AdminEditBanner.jsp
        request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Calling method
        Banner banner = new Banner();
        
        // Set parameter
        banner.setId(Integer.parseInt(request.getParameter("new_id")));
        banner.setTitle(request.getParameter("new_title"));
        banner.setImg(request.getParameter("new_Img"));
        banner.setDesc(request.getParameter("new_desc"));
        
        // Edit value from Database
        bannerDao.editBanner(banner);

        // Lead to Page that show the list of banner
        response.sendRedirect(request.getContextPath() + "/adminbannerlist");
    }

}
