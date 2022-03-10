<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${Msg}</p>
	<p>${deletionMsg}</p>
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="emp">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.empName}</td>
					<td>${emp.empSalary}</td>
					<td><a href="editEmployee?id =${emp.id}">Edit</a></td>
					<td><a href="deleteEmployee?id =${emp.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/loadForm">Add New Employee</a>
</body>
</html>