/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IRecruitmentDAO;
import dao.impl.RecruitmentDAO;
import java.sql.Date;
import model.Recruitment;

/**
 * Documentation : AdminAddRecruitmentController Created on : 27-Feb-2022,
 * 01:12:48
 *
 * @author Bảo Châu Bống
 */
public class AdminAddRecruitmentController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Lead to AdminAddRecruitment.jsp
        request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // Parameter Initializing
        String new_img = request.getParameter("new_img").trim();
        String new_Title = request.getParameter("new_Title").trim();
        String new_content = request.getParameter("new_content").trim();
        String new_date = request.getParameter("new_date");
        String mess = "";
        // Set the value
        //Recruitment recruitment = new Recruitment();
//        recruitment.setImg(new_img.trim());
//        recruitment.setTitle(new_Title.trim());
//        recruitment.setContent(new_content.trim());
//        recruitment.setDate((new_date));
//        String mess = "";
//        if (Validate.checkImg(recruitment.getImg()) == false) {
//            mess = "Sai định dạng ảnh !";
//        } else if (Validate.checkTitle(recruitment.getTitle()) == false) {
//            mess = "Thông tin Title không hợp lệ !";
//        } else if (Validate.checkDesc(recruitment.getContent()) == false) {
//            mess = "Thông tin Content không hợp lệ !";
//        } else {
//            recruitmentDao.addRecruitment(recruitment);
//            //request.getRequestDispatcher("/adminrecruitmentlist").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
//        }
//        if (!mess.equals("")) {
//            request.setAttribute("mess", mess);
//            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
//        }
        Recruitment recruitment = new Recruitment(0, new_img, new_Title, new_content, new_date);

        if (Validate.checkTitle(new_Title) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Length of Title must be from 4 to 30 characters!");
            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
        } else if (Validate.checkImg(new_img) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Image can not be blank !");
            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
        } else if (Validate.checkDesc(new_content) == false) {
            request.setAttribute("recruitment", recruitment);
            request.setAttribute("error", "Length of Content must be from 4 to 2500 characters!");
            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
        } else {
            recruitmentDao.addRecruitment(recruitment);
            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add Recruitment successful !");
            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
        }
   
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
