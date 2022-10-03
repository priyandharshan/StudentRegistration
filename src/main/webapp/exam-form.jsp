<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
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
				<a href="https://www.xadmin.net" class="navbar-brand"> Student
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" style="text-color: white" s>Students</a></li>
				<li><a href="<%=request.getContextPath()%>/home"
					class="nav-link" style="text-color: white">Home</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="card" align="center">
		<a href="<%=request.getContextPath() %>/showresults"><button
				class="btn btn-success">Show Results</button></a>
	</div>
	<div class="container">
		<div class="row">
			<div class="card">
				<img alt="" src="">
			</div>
		</div>

		<div class="card">
			<div class="card-body">


				<c:if test="${result != null}">
					<form action="updateresults" method="post">
				</c:if>
				<c:if test="${result == null}">
					<form action="insertresults" method="post">
				</c:if>

				<caption>
					<h2 align="center">
						<c:if test="${result != null}">
            			Edit Exam Results
            		</c:if>
						<c:if test="${result == null}">
            			Add Exam Results
            		</c:if>
						<c:if test="${result!=null}">
							<input type="hidden" name="id"
								value="<c:out value='${result.resultId}'/>" />

						</c:if>
						<table class="table table-borderd">

							<tr>
								<td><label>Student Id</label></td>
								<td><input type="text" name="name"
									value="<c:out value='${result.studentId}' />"
									required="required" required="required"></td>
							</tr>
							<tr>
								<td><label>Subject Name</label></td>
								<td><select name="subject">
										<c:forEach items="${subjectList}" var="subject">
											<option value="${subject.subjectId}">${subject.subjectName}-
												${subject.grade}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td><label>Exam Name</label></td>
								<td><select name="exam">
										<c:forEach items="${examList}" var="exam">
											<option value="${exam.examId}">${exam.examName}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td><label>Marks</label></td>
								<td><input type="number" name="mark"
									value="<c:out value='${result.marks}' />" required="required"></td>
							</tr>
							<tr>


								<td></td>
								<td>
									<button type="submit" class="btn btn-success">Save</button>
								</td>

							</tr>

						</table>

						</form>
			</div>
		</div>
	</div>
	</div>



</body>
</html>