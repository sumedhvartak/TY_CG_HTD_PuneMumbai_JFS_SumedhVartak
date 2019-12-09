<%@page import="com.capgemini.springmvc.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session = "false" %>

<% HttpSession session = request.getSession(false);
   EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean)  session.getAttribute("employeeInfoBean"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome  <%= employeeInfoBean.getEmpName()%> !</h3>
	<a href="./addEmployeeForm">Add Employee</a><br>
	<a href="./UpdateEmployeeForm">Update Employee </a><br>
	<a href="./deleteEmployeeForm">Delete Employee</a><br>
	<a href="./searchEmployee">Search Employee</a><br>
	<a href ="./seeAllEmployee">See All Employee</a><br>
	
	<a href="./Logout">Logout</a>
</body>
</html>