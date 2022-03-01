/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ICVInforDAO;
import dao.IStatusDAO;
import dao.impl.CVInforDAO;
import dao.impl.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CVInfor;
import model.Status;
import util.CustomException;

/**
 *
 * @author Bảo Châu Bống
 */
public class AdminListCVController extends HttpServlet {

    ICVInforDAO cvInforDao = new CVInforDAO();
    IStatusDAO statusDao = new StatusDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        List<CVInfor> cvInforList = cvInforDao.getAllCV();
        List<CVInfor> cvStatusList = cvInforDao.getAllStatus();
       // List<Status> statusList = statusDao.getAllStatus();

       // request.setAttribute("statusList", statusList);
        request.setAttribute("cvStatusList", cvStatusList);
        request.setAttribute("cvInforList", cvInforList);

        request.getRequestDispatcher("AdminCVInforList.jsp").forward(request, response);
    }

//    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<CustomException> validationErrors = new ArrayList<>();
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        String fullname = request.getParameter("fullname");
//        String CV = request.getParameter("CV");
//        String date = request.getParameter("date");
//        String chucvu = request.getParameter("chucvu");
//        String status = request.getParameter("status");
//
//        boolean valid = true;
//        boolean success = false;
//
//        if (status.isEmpty()) {
//            validationErrors.add(new CustomException("You must fill all fields"));
//            valid = false;
//        } else {
//            try {
//                CVInforDAO cvidao = new CVInforDAO();
//
//                if (valid) {
//                    CVInfor updateCVStatus = new CVInfor(id, fullname, CV, date, chucvu, status);
//
//                    if (cvidao.editCV(updateCVStatus)) {
//                        success = true;
//                    } else {
//                        success = false;
//                    }
//                }
//            } catch (NumberFormatException e) {
//                validationErrors.add(new CustomException("Error"));
//            }
//        }
//
//        if (!valid || !success) {
//            request.setAttribute("updateStatus", false);
//            request.setAttribute("updateMessage", validationErrors);
//        } else {
//            request.setAttribute("updateStatus", true);
//            request.setAttribute("updateMessage", "Updated Successfully!");
//        }
//    }
}
