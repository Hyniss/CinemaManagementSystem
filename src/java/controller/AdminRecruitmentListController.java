/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IRecruitmentDAO;
import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recruitment;

/**
 * Documentation : AdminRecruitmentListController
 * Created on : 27-Feb-2022, 01:12:48
 * @author Bảo Châu Bống
 */

// Admin can see the list of Recruitment and CRUD
public class AdminRecruitmentListController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        // Get data from database and transfer in parameter
        List <Recruitment> recruitmentList = recruitmentDao.getAllRecruitment();
        
        // Set Attributes
        request.setAttribute("recruitmentList", recruitmentList);
        
        // Lead to AdminRecruitmentList.jsp
        request.getRequestDispatcher("AdminRecruitmentList.jsp").forward(request, response);
    }
}
