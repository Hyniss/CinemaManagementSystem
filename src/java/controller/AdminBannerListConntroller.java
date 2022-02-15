
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
 * Documentation: AdminBannerListConntroller 
 * Created on: 13-Feb-2022, 0:41:21
 * @author Bảo Châu Bống
 */

// Admin can see the list of Banner and do CRUD

public class AdminBannerListConntroller extends HttpServlet {
    
    // Calling method of database
    IBannerDAO bannerDao = new BannerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Transfer data from database
        List<Banner> bannerList = bannerDao.getAllBanner();
        
        // Set Attribute
        request.setAttribute("bannerList", bannerList);
        
        // Lead to AdminBannerList.jsp
        request.getRequestDispatcher("AdminBannerList.jsp").forward(request, response);
    }

}
