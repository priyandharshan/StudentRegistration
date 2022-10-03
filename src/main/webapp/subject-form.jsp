<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">
		
			

			<ul class="navbar-nav">
			<a class="navbar-brand"> Student
					Management Application </a>
			
			<li>
				
					<a href="<%=request.getContextPath()%>/home"
						class="nav-link" style="text-color: white">Home</a></li>
				<li><a href="<%=request.getContextPath()%>/listsubjects"
					class="nav-link" style="text-color: white" s>Subjects</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="card">
		<div class="card-body">


			<c:if test="${subject != null}">
				<form action="updatesubject" method="post">
			</c:if>
			<c:if test="${subject == null}">
				<form action="insertsubject" method="post">
			</c:if>

			<c:if test="${subject!=null}">
				<input type="hidden" name="id"
					value="<c:out value='${subject.subjectId}'/>" />

			</c:if>
			<table class="table table-borderd">

				<tr>
					<td><label>Subject Name</label></td>
					<td><input type="text" name="subjectname"
						value="<c:out value='${subject.subjectName}' />"
						required="required" required="required"></td>
					<td><select name="subjectcat"
						value="<c:out value='${subject.grade}'/>">
							<option value="grade1">Grade 1</option>
							<option value="grade2">Grade 2</option>
							<option value="grade3">Grade 3</option>
							<option value="grade4">Grade 4</option>
							<option value="grade5">Grade 5</option>
							<option value="grade6">Grade 6</option>
							<option value="grade7">Grade 7</option>
							<option value="grade8">Grade 8</option>
							<option value="grade9">Grade 9</option>
							<option value="grade10">Grade 10</option>
							<option value="grade11">Grade 11</option>

					</select>
					<td><input type="submit" name="submit"></td>
				</tr>

				<br>
				<div class="card">
					<div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Subject ID</th>
									<th>Subject Name</th>
									<th>Grade</th>
									<th>Action</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="subject" items="${listSubject}">
									<tr>
										<td><c:out value="${subject.subjectId}"></c:out></td>
										<td><c:out value="${subject.subjectName}"></c:out></td>
										<td><c:out value="${subject.grade}"></c:out></td>

										<td><a
											href="editsubject?id=<c:out value='${subject.subjectId}' />">Edit</a>
											&nbsp;&nbsp; <a
											href="deletesubject?id=<c:out value='${subject.subjectId}' />">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
</body>
</html>