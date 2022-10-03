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
				<a  class="navbar-brand"> Student
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





	<div class="column">
		<div class="card">
			<div class="card-body">


				<c:if test="${student != null}">
					<form action="update" method="post" enctype="multipart/form-data">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2 align="center">
						<c:if test="${student != null}">
            			Edit User
            		</c:if>
						<c:if test="${student == null}">
            			Add New User</h2>
            		</c:if>
            	</caption>
						<c:if test="${student!=null}">
							<input type="hidden" name="studentid"
								value="<c:out value='${student.studentId}'/>" >

						</c:if>
						<table class="table table-borderd">

							<tr>
								<td>First Name</td>
								<td><input type="text" name="fname"
									value="<c:out value='${student.firstName}' />"
									required="required" ></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lname"
									value="<c:out value='${student.lastName}' />"
									required="required"></td>
							</tr>
							<tr>
								<td>Address</td>
								<td><input type="text" name="address"
									value="<c:out value='${student.address}' />"
									required="required"></td>
							</tr>
							<tr>
								<td>phone</td>
								<td><input type="text" name="phone"
									value="<c:out value='${student.phonenumber}' />"
									required="required"></td>
							</tr>
							<tr>
							
							<tr>
								<td>Date of Birth</td>
								<td><input type="date" name="dob"
									value="<c:out value='${student.dateOfBirth}' />"
									required="required">
							</tr>
							
							
							
						
							<tr>
								<td>Gender</td>
								<td><input type="radio" name="id" value="male">
									Male <input type="radio" name="id" value="female">
									Female</td>
							</tr>
							
							<tr>
								<td>Grade</td>
								<td><select name="gradecatagary">
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

								</select></td>
							</tr>
							<tr>
								<td>Photo</td>
								<td><input type="file" name="photo" required="required"
									
									></td>
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