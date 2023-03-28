/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.controller;

import com.puleproject.bean.Payment;
import com.puleproject.bean.Unit;
import com.puleproject.bean.Users;
import com.puleproject.service.PaymentService;
import com.puleproject.service.RegisterService;
import com.puleproject.service.Service;
import com.puleproject.service.UnitService;
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
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            RequestDispatcher dispatcher = null;
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String phone = request.getParameter("phone");
            String roomNumber = request.getParameter("roomNumber");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String encryptedPassword = Encryption.GenerateHash(password);

            String fullName = name + " " + surname;
            java.sql.Timestamp dateTime = new java.sql.Timestamp(new java.util.Date().getTime());

            Service addService = new RegisterService();
            Service payService = new PaymentService();
            Service unitService = new UnitService(); 
                    
            Users tenant = new Users(name, surname, roomNumber, phone, email, encryptedPassword);
            Payment payment = new Payment(fullName, tenant.getUserID(), phone, email, "Default", 0, 0, dateTime);
            Unit unit = new Unit(roomNumber, email, fullName);
          
            boolean isAdded = addService.addClient(tenant);
            if (isAdded != false) {
                session.setAttribute("Added", isAdded);
                payService.addPayment(payment);
                unitService.addToUnit(unit);
                
                dispatcher = request.getRequestDispatcher("View.jsp");
                dispatcher.forward(request, response);
            } else {

                dispatcher = request.getRequestDispatcher("Register.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
