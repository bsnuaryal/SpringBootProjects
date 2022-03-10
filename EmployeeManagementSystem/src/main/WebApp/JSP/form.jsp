<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Management System</h1>
	<p>${message}</p>
	<form:form action="addEmployee" method="post" modelAttribute="emp">
		<table>
			<tr>
				<td>Employee Name:</td>
				<td><form:input path="empName" /></td>
			</tr>
			<tr>
				<td>Employee Salary:</td>
				<td><form:input path="empSalary" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>

	<a href="viewAllEmployees"> View All Employees</a>
</body>
</html>