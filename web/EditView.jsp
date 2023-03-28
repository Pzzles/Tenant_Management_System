<%-- 
    Document   : View
        Created on : 18 Dec 2022, 2:46:41 PM
    Author     : PULE
--%>

<%@page import="com.puleproject.service.UserService"%>
<%@page import="com.puleproject.bean.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.puleproject.bean.Payment"%>
<%@page import="java.util.List"%>
<%@page import="com.puleproject.service.PaymentService"%>
<%@page import="com.puleproject.service.Service"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
        <%@include file="includes/header.jsp"  %>


<form method="get" action="UpdateServlet">
    <div>
        <h4>Edit Tenant</h4>
    </div>
    <%
        Service tenantService = new UserService();
        String email = request.getParameter("email");
        Users tenant = tenantService.getOneTenant(email);
    %>
    <div>
        <div class="form-group">
            <label>Name</label> 
            <input type="text" name="name" class="form-control" value="<%= tenant.getName()%>" required/>
        </div>
        <div class="form-group">
            <label>Surname</label> 
            <input type="text" name="surname" class="form-control" value="<%= tenant.getSurname()%>" required/>
        </div>
        <div class="form-group">
            <label>Phone</label> 
            <input type="text" name="phone" class="form-control" value="<%= tenant.getPhone()%>" required/>
        </div>
        <div class="form-group">
            <label>Email</label> 
            <input type="email" name="email" class="form-control" value="<%= tenant.getEmail()%>" required/>
        </div>
        <div class="form-group">
            <label>Room Number</label>
            <input type="text" name="roomNumber" class="form-control" value="<%= tenant.getUnitNumber()%>" required/>
        </div>

    </div>

    <div>
        <a href="View.jsp" class="btn btn-primary"  >Cancel</a> 
        <input type="submit" name="btn" class="btn btn-success" value="Save"/>
    </div>

</form>
  <%@include file="includes/header.jsp"  %>