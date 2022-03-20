package controller;

import dao.impl.BannerDAO;
import dao.IBannerDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Banner;

/**
 * Documentation: AdminBannerListConntroller Created on: 13-Feb-2022, 0:41:21
 *
 * @author Bảo Châu Bống
 */
// Admin can see the list of Banner and do CRUD
public class AdminBannerListConntroller extends HttpServlet {

    // Calling method of database
    IBannerDAO bannerDao = new BannerDAO();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        // Transfer data from database
//        List<Banner> bannerList = bannerDao.getAllBanner();
//
//        // Set Attribute
//        request.setAttribute("bannerList", bannerList);
//
//        // Lead to AdminBannerList.jsp
//        request.getRequestDispatcher("AdminBannerList.jsp").forward(request, response);
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String index = request.getParameter("pageIndex");
        if (index == null) {
            index = "1";
        }
        int pageIndex = Integer.parseInt(index);

        // count number of pages
        int total = bannerDao.getTotalBanner();
        int endPage = (int) Math.ceil((double) total / 3);

        List<Banner> banner = new ArrayList<>();
        banner = bannerDao.pagingBanner(pageIndex);

        request.setAttribute("banner", banner);
        request.setAttribute("total", total);
        request.setAttribute("endPage", endPage);
        request.setAttribute("pageIndex", pageIndex);

        List<Banner> bannerList = bannerDao.getAllBanner();
//
//        // Set Attribute
       request.setAttribute("bannerList", bannerList);
        request.getRequestDispatcher("AdminBannerList.jsp").forward(request, response);
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
