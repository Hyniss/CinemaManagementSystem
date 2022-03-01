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

        ArrayList<Recruitment> recruimentList = recruimentDao.getAllChucVu();

        request.setAttribute("recruimentList", recruimentList);

        request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String new_fullname = request.getParameter("new_Fullname");
        String new_CV = request.getParameter("new_CV");
        String new_date = request.getParameter("new_date");
        String new_chucvu = request.getParameter("new_chucvu");

        CVInfor cvinfor = new CVInfor();
        cvinfor.setFullname(new_fullname.trim());
        cvinfor.setCV(new_CV.trim());
        cvinfor.setDate(new_date);
        cvinfor.setChucvu(new_chucvu);

        String mess = "";
        if (Validate.checkFullName(cvinfor.getFullname()) == false) {
            mess = "Sai định dạng tên";
        } else if (Validate.checkImg(cvinfor.getCV()) == false) {
            mess = "Sai định dạng ảnh !";
        } else {
            cvInforDao.addCV(cvinfor);
            response.sendRedirect(request.getContextPath() + "/recruitment");

        }
        if (!mess.equals("")) {
            request.setAttribute("mess", mess);
            ArrayList<Recruitment> recruimentList = recruimentDao.getAllChucVu();
            ArrayList<CVInfor> cvList = cvInforDao.getAllCV();
            request.setAttribute("recruimentList", recruimentList);
            request.setAttribute("cvList", cvList);
            request.getRequestDispatcher("UserAddCVInfor.jsp").forward(request, response);
        }

    }

}
