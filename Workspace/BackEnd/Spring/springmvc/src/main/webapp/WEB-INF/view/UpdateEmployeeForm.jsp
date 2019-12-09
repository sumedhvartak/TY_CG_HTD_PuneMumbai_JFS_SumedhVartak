<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session = "false" %>
<% String msg = (String) request.getAttribute("msg"); %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg != null && !msg.isEmpty()) { %>
<h3><%=msg%></h3>
<%} %>
	<fieldset>
	<legend>Update Employee</legend>
	<form action="./updateEmployee" method="post">
	<table>
	<tr>
	<td>Employee Id</td>
	<td>:</td>
	<td><input type="number" name="empId" required></td>
	</tr>
	<tr>
	<td>Employee Name</td>
	<td>:</td>
	<td><input type="text" name="empName" required></td>
	</tr>
	
	<tr>
	<td>Age</td>
	<td>:</td>
	<td><input type="number" name="age" required></td>
	</tr>
	
	<tr>
	<td>Salary</td>
	<td>:</td>
	<td><input type="number" name="salary" required></td>
	</tr>
	
	<tr>
	<td>Designation</td>
	<td>:</td>
	<td><input type="text" name="designation" required></td>
	</tr>
	<tr>
	<td>Mobile</td>
	<td>:</td>
	<td><input type="number" name="mobile" required></td>
	</tr>
	
	<tr>
	<td>Gender</td>
	<td>:</td>
	<td><input type="text" name="gender" required></td>
	</tr>
	
	<tr>
	<td>Password</td>
	<td>:</td>
	<td><input type="text" name="password" required></td>
	</tr>
	
	<tr>
	<td colspan="3" align="center"><br>
	<input type="submit" value="Add">
	</td>
	</tr>
	</table>
	</form>
	</fieldset>
</body>
</html>