<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">
			<div>
				<div>
					<a href="https://www.xadmin.net" class="navbar-brand"> Student
						Management Application </a>
				</div>

			</div>
			<div align="center">

				<ul class="navbar-nav">
					<li><a href="<%=request.getContextPath()%>/list"
						class="nav-link" style="text-color: white">Students list</a></li>
					<li><a href="<%=request.getContextPath()%>/home"
						class="nav-link" style="text-color: white">Home</a></li>
				</ul>
			</div>
	</header>
	<br>

	<div class="row">
		<div class="container text-left">
			<h3 align="center">List of Students</h3>
		</div>
	</div>
	<br>
	<div>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">New</a>
		</div>
	</div>
	<br>





	<div class="container">
		<div class="card">
			<table class="table table-borderd">
				<thead>
					<tr>
					<th>Image</th>
						<th>Student ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Phone Number</th>
						<th>Address</th>

						





					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${listStudent}">

						<tr>
						<td><img alt="" src="data:image/jpg;base64,${student.base64Image}"
						width=150 height=100 /></td>
							<td><c:out value="${student.studentId}"></c:out></td>

							<td><c:out value="${student.firstName}"></c:out></td>



							<td><c:out value="${student.lastName}"></c:out></td>
							<td><c:out value="${student.phonenumber}"></c:out></td>
							<td><c:out value="${student.address}"></c:out></td>
							

							<td><a
								href="edit?studentId=<c:out value='${student.studentId}' />">Edit</a>
								&nbsp;&nbsp; <a
								href="delete?studentId=<c:out value='${student.studentId}' />">Delete</a>
								&nbsp;&nbsp; <a
								href="showprofile?studentId=<c:out value='${student.studentId}' />">Show
									Results</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>











</body>

</html>