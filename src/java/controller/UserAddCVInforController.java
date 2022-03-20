/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validation.Validate;
import dao.ICVInforDAO;
import dao.IRecruitmentDAO;
import dao.impl.CVInforDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CVInfor;
import model.Recruitment;

/**
 *
 * @author Bảo Châu Bống
 */
public class UserAddCVInforController extends HttpServlet {

    IRecruitmentDAO recruimentDao = new RecruitmentDAO();
    ICVInforDAO cvInforDao = new CVInforDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        ArrayList<Recruitment> recruitmentList = recruimentDao.getAllRecruitment();

        request.setAttribute("recruitmentList", recruitmentList);

        request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

//        String chucvu = request.getParameter("new_chucvu").trim();
//        if (chucvu == null) {
//            chucvu = "1";
//        }
//        String status = request.getParameter("new_status").trim();
//        if (status == null) {
//            status = "1";
//        }
//        
        String new_fullname = request.getParameter("new_fullname").trim();
        String new_CV = request.getParameter("new_CV").trim();
        String new_date = request.getParameter("new_date").trim();
        int new_chucvu = Integer.parseInt(request.getParameter("new_chucvu"));
        // int new_status = Integer.parseInt(status);
//        String new_status = request.getParameter("new_status").trim();

        CVInfor cvinfor = new CVInfor(0, new_fullname, new_CV, new_date, new_chucvu);
        cvinfor.setFullname(new_fullname);
        cvinfor.setCV(new_CV);
        cvinfor.setDate(new_date);
        cvinfor.setChucvu(new_chucvu);
        // cvinfor.setStatus(new_status);

        String mess = "";
//        if (Validate.checkFullName(cvinfor.getFullname()) == false) {
//            mess = "Sai định dạng tên";
//        } else if (Validate.checkImg(cvinfor.getCV()) == false) {
//            mess = "Sai định dạng ảnh !";
//        } else {
//            cvInforDao.addCV(cvinfor);
//            response.sendRedirect(request.getContextPath() + "/recruitment");
//
//        }
//        if (!mess.equals("")) {
//            request.setAttribute("mess", mess);
//            ArrayList<Recruitment> recruitmentList = recruimentDao.getAllRecruitment();
//            ArrayList<CVInfor> cvList = cvInforDao.getAllCV();
//            request.setAttribute("recruitmentList", recruitmentList);
//            request.setAttribute("cvList", cvList);
//            request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
//        }
        if (Validate.checkFullName(new_fullname) == false) {
            request.setAttribute("cvinfor", cvinfor);
            request.setAttribute("error", "Length of Fullname must be from 4 to 30 characters!");
            request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
        } else if (Validate.checkImg(new_CV) == false) {
            request.setAttribute("cvinfor", cvinfor);
            request.setAttribute("error", "Image can not be blank !");
            request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
        } else {
            cvInforDao.addCV(cvinfor);
            response.sendRedirect(request.getContextPath() + "/recruitment");
        }
        if (!mess.equals("")) {
            request.setAttribute("mess", "Add CV successful!");
            request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
        }
    }

}
