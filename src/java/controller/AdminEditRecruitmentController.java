/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IRecruitmentDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recruitment;

/**
 * Documentation : AdminEditRecruitmentController
 * Created on : 27-Feb-2022, 02:18:50
 * @author Bảo Châu Bống
 */

// Admin can edit Recruitment

public class AdminEditRecruitmentController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Parameter Initializing
        String id = request.getParameter("id");

        // Get value from database
        Recruitment recruitment = recruitmentDao.get(Integer.parseInt(id));

        // Set Attribute
        request.setAttribute("recruitment", recruitment);

        // Lead to AdminEditRecruitment.jsp
        request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Calling method
        Recruitment recruitment = new Recruitment();

        // Set Parameter
        recruitment.setID(Integer.parseInt(request.getParameter("new_id")));
        recruitment.setImg(request.getParameter("new_img").trim());
        recruitment.setTitle(request.getParameter("new_Title").trim());
        recruitment.setContent(request.getParameter("new_content").trim());
        recruitment.setDate((request.getParameter("new_date")));

//        String mess = "";
//        if (Validate.checkImg(recruitment.getImg()) == false) {
//            mess = "Sai định dạng ảnh !";
//        } else if (Validate.checkTitle(recruitment.getTitle()) == false) {
//            mess = "Thông tin Title không hợp lệ !";
//        } else if (Validate.checkDesc(recruitment.getContent()) == false) {
//            mess = "Thông tin Content không hợp lệ !";
//        } else {
//            // Edit value from Database
            recruitmentDao.editRecruitment(recruitment);
            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
//        }
//
//        if (!mess.equals("")){
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
//        }
    }
}
