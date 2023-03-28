<%-- 
    Document   : messanger
    Created on : 08 Jan 2023, 8:05:04 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.bean.Users"%>
<%@page import="com.puleproject.service.UserService"%>
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

            <%@include file="css/boot.css" %>
            textarea {
                width: 100%;
                height: 150px;
                padding: 12px 20px;
                box-sizing: border-box;
                border: 2px solid #ccc;
                border-radius: 4px;
                background-color: #f8f8f8;
                font-size: 16px;
                resize: none;
            }
        </style>
    </head>
    <body>
        <div class="container">

            <%@include file="includes/tenantNav.jsp" %>

            <%
                Service tenantService = new UserService();
                Users tenant, userSession = (Users) session.getAttribute("clientSession");
                tenant = tenantService.getOneTenant(userSession.getEmail());

            %>

            <div class="main-body">
                <h2>Dashboard</h2>
                <div class="promo_card">
                    <h1><%= "Hello, " + tenant.getName()%></h1>
                    <span><%= "Unit " +  tenant.getUnitNumber() %></span>

                </div>

                <div class="history_lists">
                    <div class="list1">
                        <div class="row">
                            <h4>Report Issues</h4>
                        </div>


                        <form method="post" action="MaintenanceServlet">
                            <textarea name="text" placeholder="e.g The shower in room 5 has no hot water" required></textarea>
                            <input type="submit" name="btn" value="Send"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>



    </body>
</html>
