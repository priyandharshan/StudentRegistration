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
	<link href="/css/login.css" rel="stylesheet" type="text/css">
	<script src="js/signup.js"></script>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">
			<div>
				<a  class="navbar-brand"> Student
					Management Application </a>
					<li><a href="<%=request.getContextPath()%>/home"
						class="nav-link" style="text-color: white">Home</a></li>
			</div>

			
		</nav>
	</header>
	<br>





	<div class="column">
		<div class="card">
			<div class="card-body">


				
				<form action="<%=request.getContextPath()%>/registerusers" method="post" name="signup"  id="signUp" onSubmit="check()">
						<c:if test="${user!=null}">
							<input type="hidden" name="id"
								value="<c:out value='${user.userId}'/>" />

						</c:if>
						<table class="table table-borderd">

							<tr>
								<td>User name</td>
								<td><input type="text" name="username" placeholder="Enter your username"
									
									required="required" ></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email" id="email"
								placeholder="Enter your email"
									
									required="required"></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><input type="password" name="password"
								placeholder="Enter your password"
								
									required="required"></td>
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