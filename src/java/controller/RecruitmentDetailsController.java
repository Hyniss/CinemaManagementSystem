/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.RecruitmentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Recruitment;
import dao.IRecruitmentDAO;

/**
 * Documentation : RecruitmentDetailsController
 * Crested on : 12-Feb-2022, 22:15:27
 * @author Bảo Châu Bống
 */

// The list of information of Recruitment
public class RecruitmentDetailsController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Parameter Initializing
        String id = request.getParameter("id");
        
        // Get value from Database
        Recruitment recruitment = recruitmentDao.get(Integer.parseInt(id));
        
        // Set Attribute
        request.setAttribute("recruitment", recruitment);

        // Get data from database and transfer in parameter
        List<Recruitment> recruitmentList = recruitmentDao.getAllRecruitment();
        
        // Set Attribute
        request.setAttribute("recruitmentList", recruitmentList);

        // Lead to Recruitment_detail.jsp
        request.getRequestDispatcher("Recruitment_detail.jsp").forward(request, response);
    }
}
