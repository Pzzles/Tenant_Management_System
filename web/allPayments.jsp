<%-- 
    Document   : allPayments
    Created on : 31 Dec 2022, 3:15:28 AM
    Author     : PULE
--%>

<%@page import="java.util.List"%>
<%@page import="com.puleproject.bean.Payment"%>
<%@page import="com.puleproject.service.PaymentService"%>
<%@page import="com.puleproject.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <script src="https://kit.fontawesome.com/b99e375b6e.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>


        <style>    
            <%@include file="css/styles.css" %>
        </style>
    </head>
    <body>
        <div class="container">
            <%@include file="includes/Nav.jsp" %>
            <section class="attendance">
                <div class="attendance-list">
                    <div class="parent">
                        <div class="child">

                            <i class="fas fa-users"></i><h1>Tenants</h1>

                        </div>
                    </div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Number</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email Address</th>
                                <th>Payment Status</th>
                                <th>Amount Paid</th>
                                <th>Amount Outstanding</th>
                                <th>Date</th>
                                <th>Last Payment Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Service payServ = new PaymentService();
                                String act = request.getParameter("view1.1");
                                List<Payment> payList = payServ.getAllPayments();
                                // if (act != null) {
                                int count = 1;
                                for (Payment payment : payList) {
                            %>
                            <tr>
                                <td>
                                    <span> 
                                        <%= count%>

                                    </span>
                                </td>
                                <td><%= payment.getPayID()%></td>
                                <td><%= payment.getFullName()%></td>
                                <td><%= payment.getPhone()%></td>
                                <td><%= payment.getEmail()%></td>
                                <td><%= payment.getStatus()%> </td>
                                <td><%= payment.getAmount_Paid()%> </td>
                                <td><%= payment.getAmount_Outstanding()%> </td>
                                <td><%= payment.getDate()%> </td>
                                <td><%= payment.getDate()%> </td>
                            </tr>
                            <%
                                    count++;
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </body>
</html>
