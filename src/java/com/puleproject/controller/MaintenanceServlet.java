/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.controller;

import com.puleproject.bean.Maintenance;
import com.puleproject.bean.Message;
import com.puleproject.bean.Users;
import com.puleproject.service.MaintenanceService;
import com.puleproject.service.MessangerService;
import com.puleproject.service.Service;
import com.puleproject.service.UserService;
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author PULE
 */
@WebServlet(name = "MaintenanceServlet", urlPatterns = {"/MaintenanceServlet"})
public class MaintenanceServlet extends HttpServlet {

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

            String action = "";
            HttpSession session = request.getSession();
            Users tenant, userSession = (Users) session.getAttribute("clientSession");
            Service maintenanceService = new MaintenanceService();
            Service messangerService = new MessangerService();
            Service userService = new UserService();

            String email = "";
            String unitNum = "";

            String typeReq = request.getParameter("type");
            String detailReq = request.getParameter("detail");
            String desc = request.getParameter("description");
            String pic1 = request.getParameter("filename1");
            String pic2 = request.getParameter("filename2");
            String pic3 = request.getParameter("filename3");
            String priority = request.getParameter("prioritySelection");

            List<Maintenance> maintenanceList = maintenanceService.getAllMaintenance();

            String submission = request.getParameter("btn");
            String submission1 = request.getParameter("btn1");
            

            HttpSession session1 = request.getSession();
session1.setMaxInactiveInterval(60);
            if (submission != null) {
                switch (submission) {
                    case "Maintenance":
                        email = userSession.getEmail();
                        tenant = userService.getOneTenant(email);
                        unitNum = tenant.getUnitNumber();
                        Maintenance maintenance
                                = new Maintenance(unitNum, email, typeReq, detailReq, desc, pic1, pic2, pic3, priority);
                        maintenanceService.requestMaintenance(maintenance);
                        break;
                    case "Send":
                        email = userSession.getEmail();
                        tenant = userService.getOneTenant(email);
                        unitNum = tenant.getUnitNumber();
                        String fullName = tenant.getName() + " " + tenant.getSurname();
                        String msg = request.getParameter("text");
                        Message message
                                = new Message(fullName, email, msg);
                        messangerService.addMessage(message);
                        break;
                    case "delete":
                        try {
                            int reportNumber = Integer.parseInt(request.getParameter("repNumber"));

                            int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION);
                            if (opt == 0) {
                                maintenanceService.deleteMaintenance(reportNumber);
                                JOptionPane.showMessageDialog(null, "Maintenance record deleted");
                            }
                            RequestDispatcher rd = request.getRequestDispatcher("maintenance.jsp");
                            rd.forward(request, response);

                            break;
                        } catch (HeadlessException | IOException | NumberFormatException | ServletException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            } else if (submission1 != null) {
                switch (submission1) {
                    case "low":
                        out.print("low");
                        break;
                    case "normal":
                        out.print("normal");
                        break;
                    case "high":
                        out.print("high");
                        break;
                    case "crtical":
                        out.print("critical");
                        break;
                    case "deleteAll":
//                        String chosen = request.getParameter("prior");
//                        for (Maintenance oneMaintenance : maintenanceList) {
//                            String prio = oneMaintenance.getPriority();
//                            
//                            if(prio.equalsIgnoreCase(chosen)){
//                                
//                            }
//                        }
                        try {
                        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete all records?", "Delete", JOptionPane.YES_NO_OPTION);
                        if (opt == 0) {
                            maintenanceService.deleteAllMaintenance();
                            JOptionPane.showMessageDialog(null, "All Maintenance records deleted");
                        }
                        RequestDispatcher rd = request.getRequestDispatcher("maintenance.jsp");
                        rd.forward(request, response);

                        break;
                    } catch (HeadlessException | IOException | ServletException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
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
