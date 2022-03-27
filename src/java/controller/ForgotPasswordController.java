/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author TIEN HUY
 */
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/ForgotPassword"})
public class ForgotPasswordController extends HttpServlet {
    
       public String generateRandomPassword() {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_-";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
       

          try {
              
            String emailAdress = request.getParameter("email");
            String username = request.getParameter("username");
            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.checkEmail(username, emailAdress);
            if(account == null){
                request.setAttribute("mess", "email or username not exist");
                request.getRequestDispatcher("ForgotPass.jsp").forward(request, response);
            }else {
            try (PrintWriter out = response.getWriter()) {
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        String username = "huynthe153411@fpt.edu.vn";
                        String password = "huytruong0612@";
                        return new PasswordAuthentication(username, password);
                    }
                });
               
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("huynthe153411@fpt.edu.vn"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAdress));
                message.setSubject("Reset password");
                String check =  generateRandomPassword();
                message.setText("New Password: " + check);
//            message.setReplyTo(message.getFrom("));
                request.setAttribute("messSuccess", "Check email");
                 HttpSession ss = request.getSession();
                ss.setAttribute("check",check);
                ss.setMaxInactiveInterval(10*60);
                Transport.send(message);
               request.getRequestDispatcher("CheckSecurity.jsp").forward(request, response);

            } catch (Exception e) {
                 Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        } catch (Exception e) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, e);
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
