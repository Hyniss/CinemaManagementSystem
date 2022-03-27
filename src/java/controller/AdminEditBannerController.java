/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
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
 * @author Bảo Châu Bống
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
        request.setCharacterEncoding("utf-8");

        // Calling method
        int new_id = Integer.parseInt(request.getParameter("new_id").trim());
        String new_title = request.getParameter("new_title").trim();
        String new_Img = request.getParameter("new_Img").trim();
        String new_desc = request.getParameter("new_desc").trim();
        Banner banner = new Banner(new_id, new_Img, new_title, new_desc);
        // Set parameter
        banner.setId(new_id);
        banner.setTitle(new_title);
        banner.setImg(new_Img);
        banner.setDesc(new_desc);

        // Edit value from Database
//        bannerDao.editBanner(banner);
//
//        // Lead to Page that show the list of banner
//        response.sendRedirect(request.getContextPath() + "/adminbannerlist");
        String mess = "";
        if (Validate.checkTitle(new_title) == false) {
            request.setAttribute("banner", banner);
            request.setAttribute("error", "Length of Title must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
        } else if (Validate.checkImg(new_Img) == false) {
            request.setAttribute("banner", banner);
            request.setAttribute("error", "Image can not be blank!");
            request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
        } else if (Validate.checkDesc(new_desc) == false) {
            request.setAttribute("banner", banner);
            request.setAttribute("error", "Length of Description must be from 4 to 2500 characters!");
            request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
        } else {
            bannerDao.editBanner(banner);
            response.sendRedirect(request.getContextPath() + "/adminbannerlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Edit Banner successful !");
            request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
        }
    }

}
