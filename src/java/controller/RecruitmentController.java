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

/**
 * Documentation : RecruitmentController 
 * Created on: 26-Feb-2022, 10:12:10
 * @author Bảo Châu Bống
 */

// The list of the Recruitment
public class RecruitmentController extends HttpServlet {

    // Calling method of database
    RecruitmentDAO recruitmentDao = new RecruitmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from database and transfer in parameter
        List<Recruitment> recruitmentList = recruitmentDao.getAllRecruitment();

        // Set Attribute
        request.setAttribute("recruitmentList", recruitmentList);
        
        // Lead to Recruiment.jsp
        request.getRequestDispatcher("Recruitment.jsp").forward(request, response);
    }
}
