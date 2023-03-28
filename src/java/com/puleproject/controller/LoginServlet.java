/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.controller;

import com.puleproject.bean.Users;
import com.puleproject.service.Service;
import com.puleproject.service.UserService;
import com.puleprojects.util.Encryption;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PULE
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            Service service = new UserService();
            Users user = null;
            String action = request.getParameter("login");
            String adminBox = request.getParameter("adminCheck");
            String username = request.getParameter("Email");
            String password = request.getParameter("password");
            boolean login = false, isChecked;
            int checker;
            String encryptedPassword = Encryption.GenerateHash(password);
            RequestDispatcher dispatch = null;

            if (adminBox == null) {
                isChecked = false;
                checker = 0;
            } else {
                isChecked = true;
                checker = 1;
            }
            if (action != null) {
                switch (checker) {
                    case 0:
                        login = service.loginValidation(username, encryptedPassword, isChecked);
                        if (login == true) {
                            user = new Users(username, encryptedPassword);
                            session.setAttribute("clientSession", user);
                            dispatch = request.getRequestDispatcher("TenantPage.jsp");
                            dispatch.forward(request, response);
                        } else {
                            response.sendRedirect("Login.jsp");
                        }
                        break;
                    case 1:
                        login = service.loginValidation(username, encryptedPassword, isChecked);
                        if (login == true) {
                            user = new Users(username, encryptedPassword);
                            session.setAttribute("adminSession", user);
                            dispatch = request.getRequestDispatcher("dashboard.jsp");
                            dispatch.forward(request, response);
                        } else {
                            response.sendRedirect("Login.jsp");
                        }
                        break;
                }
            }
        }
    }
}
