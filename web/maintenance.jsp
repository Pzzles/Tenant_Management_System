<%-- 
    Document   : maintenance
    Created on : 07 Jan 2023, 6:38:42 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.bean.Maintenance"%>
<%@page import="com.puleproject.service.MaintenanceService"%>
<%@page import="com.puleproject.bean.Unit"%>
<%@page import="com.puleproject.service.UnitService"%>
<%@page import="com.puleproject.bean.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.puleproject.service.UserService"%>
<%@page import="com.puleproject.service.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                    <div>
                        <a href="MaintenanceServlet?btn1=deleteAll" class="btn btn-danger">Delete All</a>
                    </div>
                    
                    <div>
                        <label>Sort by:</label>

                        <a href="MaintenanceServlet?id=priority&btn1=low" class="btn btn-danger">Low</a>
                        <a href="MaintenanceServlet?id=priority&btn1=normal" class="btn btn-danger">Normal</a>
                        <a href="MaintenanceServlet?id=priority&btn1=high" class="btn btn-danger">High</a>
                        <a href="MaintenanceServlet?id=priority&btn1=critical" class="btn btn-danger">Critical</a>
                    </div>

                </div>

                <table class="table">
                    <thead>
                        <tr>
                            <th>ind</th>
                            <th>Unit Number</th>
                            <th>Email</th>
                            <th>Type Of Request</th>
                            <th>Details Of Request</th>
                            <th>Description Of Issue</th>
                            <th>Picture_1</th>
                            <th>Picture_2</th>
                            <th>Picture_3</th>
                            <th>Priority</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Service maintainService = new MaintenanceService();
                            List<Maintenance> maintainList = maintainService.getAllMaintenance();
                            int count = 1;

                            for (Maintenance maintenace : maintainList) {
                                String email = maintenace.getEmail();
                                String priority = maintenace.getPriority();
                        %>
                        <tr>
                            <td>
                                <span> 
                                    <%= count%>

                                </span>
                            </td>

                            <td><%= maintenace.getUnitNumber()%></td>
                            <td><%= email%></td>
                            <td><%= maintenace.getTypeOfRequest()%></td>
                            <td><%= maintenace.getDetailOfRequest()%></td>
                            <td><%= maintenace.getDescription()%></td>
                            <td><%= maintenace.getPic1()%></td>
                            <td><%= maintenace.getPic2()%></td>
                            <td><%= maintenace.getPic3()%></td>
                            <td>
                                <%= priority%>
                            </td>
                            <td>
                                <button>
                                    <a href="MaintenanceServlet?repNumber=<%=maintenace.getId() %>&btn=delete" class="fa fa-trash"> Delete
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
