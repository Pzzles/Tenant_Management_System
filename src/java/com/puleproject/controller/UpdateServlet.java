/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.controller;

import com.puleproject.bean.Users;
import com.puleproject.service.PaymentService;
import com.puleproject.service.Service;
import com.puleproject.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PULE
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String updatePaymentbtn = request.getParameter("updatePayment");
            String updateTenant = request.getParameter("btn");
            String email = request.getParameter("email");
            RequestDispatcher dispatcher = null;
            

            if (updatePaymentbtn != null) {

                double paid = Double.parseDouble(request.getParameter("paid"));
                double owed = Double.parseDouble(request.getParameter("owed"));
                String status = request.getParameter("status");
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            java.sql.Timestamp dateLast = new java.sql.Timestamp(new java.util.Date().getTime());

                Service updatePayServ = new PaymentService();
                
                updatePayServ.updatePayment(status, paid, owed, date, dateLast, email);

                dispatcher = request.getRequestDispatcher("allPayments.jsp");
                dispatcher.forward(request, response);
                
            } else if (updateTenant != null) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String roomNum = request.getParameter("roomNumber");
                String phone = request.getParameter("phone");

                Service serv = new UserService();

                String password = serv.getOneTenant(email).getPassword();
                serv.updateTenant(name, surname, roomNum, phone, password, email);

                dispatcher = request.getRequestDispatcher("View.jsp");
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
