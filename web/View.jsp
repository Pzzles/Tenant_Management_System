<%-- 
    Document   : Payments
    Created on : 19 Dec 2022, 7:24:38 PM
    Author     : PULE
--%>

<%@page import="java.util.List"%>
<%@page import="com.puleproject.bean.Users"%>
<%@page import="com.puleproject.service.UserService"%>
<%@page import="com.puleproject.service.Service"%>
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
            <section class="attendance">
                <div class="attendance-list">
                    <div class="parent">
                        <div class="child">
                            
                            <i class="fas fa-users"></i><h1>Tenants</h1>
                           
                        </div>
                        <div class="top_btns">

                            <button>
                                <a href="ActionServlet?btn=add" class="btn btn-success" role="button"><i class="fas fa-plus" aria-hidden="true"></i> Add Tenant</a>
                            </button>
                        </div>
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Number</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Room Number</th>
                                <th>Email Address</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Service tenantService = new UserService();
                                List<Users> tenantList = tenantService.getAllTenants();
                                int count = 1;
                                for (Users tenant : tenantList) {
                                    String email = tenant.getEmail();
                            %>
                            <tr>
                                <td>
                                    <span> 
                                        <%= count%>

                                    </span>
                                </td>
                                <td><%= tenant.getUserID()%></td>
                                <td><%= tenant.getName() + " " + tenant.getSurname()%></td>
                                <td><%= tenant.getPhone()%></td>
                                <td><%= tenant.getUnitNumber()%></td>
                                <td><%= email%></td>
                                <td>
                                    <button>
                                        <a href="ActionServlet?email=<%=email%>&btn=edit" class="fa fa-edit"> Edit
                                        </a> 
                                    </button>
                                    <button>
                                        <a href="ActionServlet?email=<%=email%>&btn=delete" class="fa fa-trash" style="color:red;" > Delete
                                        </a>
                                    </button>
                                </td>
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
