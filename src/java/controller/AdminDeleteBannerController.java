
package controller;

import dao.BannerDAO;
import dao.IBannerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Documentation : AdminDeleteBannerController
 * Created on : 13-Feb-2022, 02:29:34 
 * @author Bảo Châu Bống
 */

// Admin Can delete Banner

public class AdminDeleteBannerController extends HttpServlet {

    // Calling method of database
    IBannerDAO bannerDao = new BannerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Delete value from Database
        bannerDao.deleteBanner(Integer.parseInt(id));
        
        // Lead to Page that show the list of banner
        response.sendRedirect(request.getContextPath() + "/adminbannerlist");
    }
}
