<%-- 
    Document   : profile
    Created on : 07 Jan 2023, 5:52:35 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.bean.Users"%>
<%@page import="com.puleproject.service.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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


        <form method="post" action="UpdateServlet" style="max-width:500px;margin:auto">
            <h2>My Profile</h2>
            <div class="input-container">
                <%
                    Users userSession = (Users) session.getAttribute("clientSession");
                    UserService uservice = new UserService();
                    
                    String email = userSession.getEmail();
                    Users tenant = uservice.getOneTenant(email);

                    
                %>
            </div>

            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="Name" name="firstname" value="<%= tenant.getName() %>">

            </div>

            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="Surname" name="surname" value="<%=  tenant.getSurname()%>">

            </div>
            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="ID Number" name="id_Number"  value="<%= tenant.getEmail() %>">

            </div>
                
                            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="ID Number" name="id_Number"  value="<%= tenant.getPhone() %>">

            </div>
                
                            <div class="input-container">
                <i class="fa fa-user icon"></i>
                <input class="input-field" type="text" placeholder="ID Number" name="id_Number"  value="<%= tenant.getUnitNumber() %>">

            </div>
                
   
            
            
            

            <button type="submit" class="btn" name="update_btn" value="Update Profile">Edit Profile</button>
            <br>

            <h3> <a href = "index.jsp">Cancel?</a></h3>

        </form>
        </div>

    </body>
</html>
