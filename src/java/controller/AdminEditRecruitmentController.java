/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.IRecruitmentDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recruitment;

/**
 * Documentation : AdminEditRecruitmentController Created on : 27-Feb-2022,
 * 02:18:50
 *
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
        //Recruitment recruitment = new Recruitment();
        int new_id = Integer.parseInt(request.getParameter("new_id"));
        String new_img = request.getParameter("new_img").trim();
        String new_Title = request.getParameter("new_Title").trim();
        String new_Content = request.getParameter("new_content").trim();
        String new_date = request.getParameter("new_date");
        Recruitment recruitment = new Recruitment(new_id, new_img, new_Title, new_Content, new_date);
        // Set Parameter
        recruitment.setID(new_id);
        recruitment.setImg(new_img);
        recruitment.setTitle(new_Title);
        recruitment.setContent(new_Content);
        recruitment.setDate(new_date);

//        String mess = "";
//        if (Validate.checkImg(recruitment.getImg()) == false) {
//            mess = "Sai định dạng ảnh !";
//        } else if (Validate.checkTitle(recruitment.getTitle()) == false) {
//            mess = "Thông tin Title không hợp lệ !";
//        } else if (Validate.checkDesc(recruitment.getContent()) == false) {
//            mess = "Thông tin Content không hợp lệ !";
//        } else {
//            // Edit value from Database
//            recruitmentDao.editRecruitment(recruitment);
//            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
//        }
//
//        if (!mess.equals("")){
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
//        }
        String mess = "";
        if (Validate.checkTitle(new_Title) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Length of Title must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
        } else if (Validate.checkImg(new_img) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Image can not be blank and length from 4 to 30 characters!");
            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
        } else if (Validate.checkDesc(new_Content) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Length of Content must be from 4 to 2500 characters!");
            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
        } else {
            recruitmentDao.editRecruitment(recruitment);
//            request.getRequestDispatcher("/adminrecruitmentlist").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add Recruitment successful !");
            request.getRequestDispatcher("AdminEditRecruitment.jsp").forward(request, response);
        }
    }
}
