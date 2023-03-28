<%-- 
    Document   : Payments
    Created on : 19 Dec 2022, 7:24:38 PM
    Author     : PULE
--%>

<%@page import="java.util.List"%>
<%@page import="com.puleproject.service.PaymentService"%>
<%@page import="com.puleproject.service.Service"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.puleproject.bean.Payment"%>
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
            <form method="post" action="UpdateServlet">
                <section class="attendance">
                    <div class="attendance-list">
                        <i class="fas fa-home"></i> <h1>Units</h1>
                        <table class="table">
                            <thead>
                                <tr>
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
                            <tbody>                            <%
                                Payment payment = (Payment) session.getAttribute("Payment");
                                if (payment != null) {

                                %>
                                <tr>
                                    <td><%= payment.getPayID()%></td>
                                    <td><%= payment.getFullName()%></td>
                                    <td><%= payment.getPhone()%></td>
                                    <td><%= payment.getEmail()%></td>
                                    <td>
                                        <select name="status" id="status">
                                            <option value="default">Default</option>
                                            <option value="Successful">Successful</option>
                                            <option value="Failed">Failed</option>
                                        </select>
                                    </td>
                                    <td>R <input type="text" name="paid" value="<%= payment.getAmount_Paid()%>"/></td>
                                    <td>R <input type="text" name="owed" value="<%= payment.getAmount_Outstanding()%>"/></td>
                                    <td><%= payment.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))%></td>
                                    <td><%= payment.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </section>

                <input type="hidden" name="email" value="<%= payment.getEmail()%>"/>
                <input type="hidden" name="paid" value="<%=payment.getAmount_Paid()%>"/>
                <input type="hidden" name="owed" value="<%=payment.getAmount_Outstanding()%>"/>
                <input type="hidden" name="date" value="<%= payment.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))%>" />
                <input type="hidden" name="lastDate" value="<%= payment.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))%>" />

                <input type="submit" class="btn btn-primary" name="updatePayment" value="Update Payment"/> 
                <a href="allPayments.jsp" class="btn btn-primary">View Update</a> 
                <%
                    }
                %>

            </form>

        </div>
    </body>
</html>
