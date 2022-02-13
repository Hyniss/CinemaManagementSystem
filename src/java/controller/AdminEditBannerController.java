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
 *
 * @author Bảo Châu Bống
 */
public class AdminEditBannerController extends HttpServlet {

    IBannerDAO bannerDao = new BannerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Banner banner = bannerDao.get(Integer.parseInt(id));
        request.setAttribute("banner", banner);
        request.getRequestDispatcher("AdminEditBanner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Banner banner = new Banner();
        banner.setId(Integer.parseInt(request.getParameter("new_id")));
        banner.setTitle(request.getParameter("new_title"));
        banner.setImg(request.getParameter("new_Img"));
        banner.setDesc(request.getParameter("new_desc"));
        bannerDao.editBanner(banner);

        response.sendRedirect(request.getContextPath() + "/adminbannerlist");
    }

}
