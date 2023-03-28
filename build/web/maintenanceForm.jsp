<%-- 
    Document   : maintenanceForm
    Created on : 07 Jan 2023, 12:43:21 PM
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

                if (userSession == null) {
                    out.print("Please login");
                } else {
            %>
            <div class="main-body">
                <h2>Dashboard</h2>
                <div class="promo_card">
                    <h1><%= "Hello, " + tenant.getName()%></h1>
                    <span>Lorem ipsum dolor sit amet.</span>

                </div>

                <div class="history_lists">
                    <div class="list1">
                        <div class="row">
                            <h4>Report Issues</h4>
                        </div>


                        <form method="post" action="MaintenanceServlet">
                            <table>

                                <thead>
                                    <tr>
                                        <th>Request Details</th>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Type of Request</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <select name="type">
                                                <option value="electricity">Electricity</option>
                                                <option value="toilet">Bathroom or Toilet</option>
                                                <option value="water">Water tank or Water Pump</option>
                                                <option value="geyser">Geyser</option>
                                                <option value="roof">Roof or Ceiling</option>
                                                <option value="floor">Tiles or Walls</option>
                                                <option value="security">Main Gate, Window Bars or Burglar Gate</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Details of Request</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <select name="detail">
                                                <option value="other">Other</option>
                                                <option value="leak">Leak</option>
                                                <option value="electric">Loose Wiring or Electric Tripping</option>
                                                <option value="damage">Damage</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Describe the Issue</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <textarea name="description" placeholder="e.g The shower in room 5 has no hot water"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Picture 1</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input type="file" id="myFile" name="filename1">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Picture 2</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input type="file" id="myFile" name="filename2">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Picture 3</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <input type="file" id="myFile" name="filename3">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Priority</td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <select name="prioritySelection">
                                                <option value="low">Low</option>
                                                <option value="Normal">Normal</option>
                                                <option value="High">High</option>
                                                <option value="critical">Critical</option>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>

                            </table>
                            <input type="submit" name="btn" value="Maintenance">
                        </form>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
