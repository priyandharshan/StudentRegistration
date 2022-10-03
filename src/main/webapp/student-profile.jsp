<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>

		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">
			<div>
				<a class="navbar-brand"> Student Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/students"
					class="nav-link" style="text-color: white" s>Students</a></li>
				<li><a href="<%=request.getContextPath()%>/subjects"
					class="nav-link" style="text-color: white" s>Subjects</a></li>
				<li><a href="<%=request.getContextPath()%>/examination"
					class="nav-link" style="text-color: white" s>Examination</a></li>
					<li><a href="<%=request.getContextPath()%>/home"
						class="nav-link" style="text-color: white">Home</a></li>
			</ul>
		</nav>
	</header>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<div style="text-align: center;">
					<img alt="" src="data:image/jpg;base64,${student.base64Image}"
						width=250 height=200 />

					<h1>
						<c:if test="${student != null}">
            			<c:out value='${student.firstName}' /> Results
            		</c:if>
						<c:if test="${student == null}">
            			Results
            			</c:if>
					</h1>
					
					<label>Last Name: <c:out value='${student.lastName}' /></label>
					<label>Address: <c:out value='${student.address}' /></label>
					<label>Phone: <c:out value='${student.phonenumber}' /></label>
					<label>Date of Birth: <c:out value='${student.dateOfBirth}' /></label>
					<label>Gender: <c:out value='${student.gender}' /></label>
					<label>Grade: <c:out value='${student.grade}' /></label>
					<table class="table table=borderd">
						<thead>
						<th>Subject ID</th>
						<th>Term</th>
						<th>marks</th>
						</thead>
						<tbody>
						<c:forEach var="list" items="${list}">
						
						<tr>
						<td><c:out value="${list.subjectId}"></c:out></td>
						<td><c:out value="${list.examId}"></c:out></td>
						<td><c:out value="${list.studentMark}"></c:out></td></tr>
						
						</c:forEach></tbody>

					</table>


				</div>




			</div>
		</div>
	</div>

</body>
</html>