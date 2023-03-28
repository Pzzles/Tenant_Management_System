<%-- 
    Document   : Payments
    Created on : 19 Dec 2022, 7:24:38 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.service.UnitService"%>
<%@page import="com.puleproject.bean.Unit"%>
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

                            <i class="fas fa-home"></i><h1>Units</h1>

                        </div>

                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>ind</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Unit Number</th>
                                <th>Email Address</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Service tenantService = new UserService();
                                List<Users> tenantList = tenantService.getAllTenants();
                                int count = 1;
                                Service tenantServ = null,
                                        unitService = new UnitService();
//                                    Unit unit = null;

                                List<Unit> unitList = unitService.getAllUnits();

                                for (Unit tenant : unitList) {
                                    String email = tenant.getEmail();
                            %>
                            <tr>
                                <td>
                                    <span> 
                                        <%= count%>

                                    </span>
                                </td>
                                <td><%= tenant.getId()%></td>
                                <td><%= tenant.getOccupantName()%></td>
                                <td><%= tenant.getUnitNumber()%></td>
                                <td><%= email%></td>
                                    <td>
                                        <select name="status" id="status">
                                            <option value="default">Default</option>
                                            <option value="Successful">Successful</option>
                                            <option value="Failed">Failed</option>
                                        </select>
                                    </td>
                                <td>
                                    <button>
                                        <a href="ActionServlet?email=<%=email%>&btn=edit" class="fa fa-edit"> Edit
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
