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

/**
 * Documentation : AdminDeleteRecruitmentController
 * Created on : 27-Feb-2022, 02:18:50
 * @author Bảo Châu Bống
 */

// Admin can delete Recruitment

public class AdminDeleteRecruitmentController extends HttpServlet {

    // Calling method of database
    IRecruitmentDAO recruitmentDao = new RecruitmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // Parameter Initializing
        String id = request.getParameter("id");

        // Delete value from Database
        recruitmentDao.deleteRecruitment(Integer.parseInt(id));

        // Lead to Page that show the list of Recruitment
        response.sendRedirect(request.getContextPath() + "/adminrecruitmentlist");
    }
}
