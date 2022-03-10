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
	<form:form action="saveEditedEmployee" method="post"
		modelAttribute="empToEdit">
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
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>