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
        String new_img = request.getParameter("new_img");
        String new_Title = request.getParameter("new_Title");
        String new_content = request.getParameter("new_content");
        String new_date = request.getParameter("new_date");

        // Set the value
        Recruitment recruitment = new Recruitment();
        recruitment.setImg(new_img.trim());
        recruitment.setTitle(new_Title.trim());
        recruitment.setContent(new_content.trim());
        recruitment.setDate((new_date));

        String mess = "";
        if (Validate.checkImg(recruitment.getImg()) == false) {
            mess = "Sai định dạng ảnh !";
        } else if (Validate.checkTitle(recruitment.getTitle()) == false) {
            mess = "Thông tin Title không hợp lệ !";
        } else if (Validate.checkDesc(recruitment.getContent()) == false) {
            mess = "Thông tin Content không hợp lệ !";
        } else {
            recruitmentDao.addRecruitment(recruitment);
            //request.getRequestDispatcher("/adminrecruitmentlist").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("AdminAddRecruitment.jsp").forward(request, response);
        }
    }
}
