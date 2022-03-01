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
 * Documentation : AdminPromotionListController Created on : 13-Feb-2022,
 * 01:41:21
 *
 * @author Bảo Châu Bống
 */
//  Admin can add new Banner
public class AdminAddBannerController extends HttpServlet {

    // Calling method of database
    IBannerDAO bannerDao = new BannerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Lead to AdminAddBanner.jsp
        request.getRequestDispatcher("AdminAddBanner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // Parameter Initializing
        String new_title = request.getParameter("new_title".trim());
        String new_desc = request.getParameter("new_desc").trim();
        String new_Img = request.getParameter("new_Img");

        // Set the value
        Banner banner = new Banner();
        banner.setTitle(new_title);
        banner.setImg(new_Img);
        banner.setDesc(new_desc);

        String mess = "";
        if (Validate.checkImg(banner.getImg()) == false) {
            mess = "Sai định dạng ảnh !";
        } else if (Validate.checkTitle(banner.getTitle()) == false) {
            mess = "Thông tin Title không hợp lệ !";
        } else if (Validate.checkDesc(banner.getDesc()) == false) {
            mess = "Thông tin Content không hợp lệ !";
        } else {
            bannerDao.addBanner(banner);
            //request.getRequestDispatcher("/adminrecruitmentlist").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/adminbannerlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("AdminAddBanner.jsp").forward(request, response);
        }

    }
}
