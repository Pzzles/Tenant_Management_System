<%-- 
    Document   : Payments
    Created on : 19 Dec 2022, 7:24:38 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.bean.Message"%>
<%@page import="com.puleproject.service.MessangerService"%>
<%@page import="com.puleproject.bean.Maintenance"%>
<%@page import="com.puleproject.service.MaintenanceService"%>
<%@page import="com.puleproject.bean.Unit"%>
<%@page import="com.puleproject.service.UnitService"%>
<%@page import="com.puleproject.bean.Users"%>

<%@page import="com.puleproject.service.UserService"%>
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


            <section class="main">
                <div class="main-top">
                    <h1>Dashboard<<</h1>
                    <i class="fas fa-user-cog"></i>

                </div>


                <div class="users">
                    <div class="card">
                        <div class="per">
                            <%
                                Service unitService = new UnitService();
                                List<Unit> unitList = unitService.getAllUnits();

                                Service maintenanceService = new MaintenanceService();
                                List<Maintenance> maintenanceList = maintenanceService.getAllMaintenance();
                            %>
                            <table>

                                <tr>
                                    <td>Occupied Units:</td><td></td><td><span><%= unitList.size()%></span></td>
                                </tr>

                                <tr>
                                    <td>Empty Units:</td><td></td><td><span><%= 22 - unitList.size()%></span></td>
                                </tr>
                            </table>
                        </div>
                        <button>Profile</button>
                    </div>
<!--                    <div class="card">
                        <img src="./pic/img2.jpg">
                        <h4>Balbina kherr</h4>
                        <p>Progammer</p>
                        <div class="per">
                            <table>
                                <td>Units</td>
                                <tr>
                                </tr>
                            </table>
                        </div>
                        <button>Profile</button>
                    </div>
                    <div class="card">
                        <img src="./pic/img3.jpg">
                        <h4>Badan John</h4>
                        <p>tester</p>
                        <div class="per">

                            <table>
                                <tr>
                                    <td><span><%= maintenanceList.size()%></span></td>
                                    <%
                                        int lowCount = 0, normalCount = 0, highCount = 0, criticalCount = 0;
//                                        for (Maintenance maintenance : maintenanceList) {
//                                            String priority = maintenance.getPriority();
//                                            if (priority.equalsIgnoreCase("Low")) {
//                                                lowCount++;
//                                            } else if ((priority.equalsIgnoreCase("Normal"))) {
//                                                normalCount++;
//                                            } else if ((priority.equalsIgnoreCase("High"))) {
//                                                highCount++;
//                                            } else if ((priority.equalsIgnoreCase("Critical"))) {
//                                                criticalCount++;
//                                            }
//                                        }
                                    %>
                                </tr>

                                <tr> 
                                    <td>Low:</td><td></td><td><td><span><%= lowCount%></span></td>
                                </tr>
                                <tr> 
                                    <td>Normal:</td><td></td><td><td><span><%= normalCount%></span></td>
                                </tr>
                                <tr> 
                                    <td>High:</td><td></td><td><td><span><%= highCount%></span></td>
                                </tr>
                                <tr> 
                                    <td>Critical:</td><td></td><td><td><span><%= criticalCount%></span></td>
                                </tr>
                            </table>

                        </div>
                        <button>Profile</button>
                    </div>
                    <div class="card">
                        <img src="./pic/img4.jpg">
                        <h4>Salina micheal</h4>
                        <p>Ui designer</p>
                        <div class="per">
                            <%
                                Service messanger = new MessangerService();
                                List<Message> messageList = messanger.getAllMessages();
                            %>
                            <table>
                                <tr>
                                    <td>Month <span><%= messageList.size()%></span></td>
                                    <td><span>82%</span></td>
                                </tr>
                                <tr>

                                    <td>Year</td>
                                </tr>
                            </table>
                        </div>
                        <button>Profile</button>
                    </div>-->
                </div>

                <section class="attendance">
                    <div class="attendance-list">
                        <h1>Tenant List</h1>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ind</th>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Phone</th>
                                    <th>Room Number</th>
                                    <th>Email Address</th>
                                    <th>Date</th>
                                    <th>Payments</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    Service tenantService = new UserService();
                                    Service payServ = new PaymentService();
                                    Payment payment = null;
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
                                    <td><%= payServ.getOnePayment(email).getDate()%></td>
                                    <td>
                                        <div>
                                            <form method="get" action="ManageServlet">
                                                <input type="hidden" name="tenants" value="<%= email%>"/>

                                                <button type="submit" name="action" value="manage">Manage Payment</button>
                                            </form>
                                        </div>
                                    </td>
                                    <td>
                                        <!--<button>View</button>-->

                                        <a href="ActionServlet?email=<%=email%>&btn=edit" class="fa fa-edit" style="color:#FFC107;size: auto;font: sans-serif  " > Edit
                                        </a> 
                                        <a href="ActionServlet?email=<%=email%>&btn=delete" class="fa fa-trash" style="color:red;size: auto;font: sans-serif " > Delete
                                        </a>

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
            </section>
        </div>

    </body>
</html>
