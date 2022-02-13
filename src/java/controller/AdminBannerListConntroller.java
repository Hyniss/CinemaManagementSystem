/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BannerDAO;
import dao.IBannerDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminBannerListConntroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IBannerDAO bannerDao = new BannerDAO();
        List<Banner> bannerList = bannerDao.getAllBanner();
        request.setAttribute("bannerList", bannerList);
        request.getRequestDispatcher("AdminBannerList.jsp").forward(request, response);
    }

}
