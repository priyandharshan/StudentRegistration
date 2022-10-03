<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: grey">
		<div>
			<a href="https://www.xadmin.net" class="navbar-brand"> Student
				Management Application </a>
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
	<div class="card" style="">
		<div class="card-body">
		
		&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
			
			<label> Student Name:<input list="studentName"
				name="studentlist"></label>
			<datalist id="studentName">
				<c:forEach items="${listStudents}" var="student">
					<option value="${student.studentId}">${student.firstName}-
						${student.lastName}</option>
				</c:forEach>
			</datalist>
			&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
			
			<a href="<%=request.getContextPath() %>/searchresults"><button style="background color:blue">Search</button></a>

		</div>
	</div>

	<div class="card">
		<div class="card-body">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Result ID</th>
						<th>Student ID</th>
						<th>Subject Id</th>
						<th>Exam ID</th>
						<th>Marks</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${listResults}">
						<tr>
							<td><c:out value="${result.resultId}"></c:out></td>
							<td><c:out value="${result.studentId}"></c:out></td>
							<td><c:out value="${result.subjectId}"></c:out></td>
							<td><c:out value="${result.examId}"></c:out></td>
							<td><c:out value="${result.studentMark}"></c:out></td>
							<td><a
								href="deleteresults?resultId=<c:out value='${result.resultId}' />">Delete</a>

							</td>


							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>