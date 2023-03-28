<%-- 
    Document   : messages
    Created on : 31 Jan 2023, 4:04:50 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.service.UserService"%>
<%@page import="com.puleproject.bean.Users"%>
<%@page import="com.puleproject.bean.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.puleproject.service.Service"%>
<%@page import="com.puleproject.service.MessangerService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                            <th>ID</th>
                            <th>Unit Number</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Message</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Service messageServ = new MessangerService();
//                            String act = request.getParameter("view1.1");
                            List<Message> messages = messageServ.getAllMessages();
                            int count = 1;
                            for (Message singleMessage : messages) {
                        %>
                        <tr>
                            <td>
                                <span> 
                                    <%= count%>

                                </span>
                            </td>
                            <%
                                String mail = singleMessage.getEmail();
                                UserService userv = new UserService();
                                Users ten = userv.getOneTenant(mail);
                            %>
                            <td><%= ten.getUnitNumber()%></td>
                            <td><%= singleMessage.getFullName()%></td>
                            <td><%= mail %></td>
                            <td><%= ten.getPhone() %></td>
                            <td><%= singleMessage.getMsg()%></td>

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
