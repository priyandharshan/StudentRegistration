<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
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


		</nav>
	</header>
	<br>

	<div align="justify">
		<div class="container">
			<div class="container">
				<div class="card">
					<div class="card-body">
						<form action="<%=request.getContextPath()%>/login" method="post">

							<table align="center" class="" tabletable-sm"">
								<tr>
									<td><label>Email</label></td>
									<td><input type="text" name="emaillogin"
										required="required" id="emaillogin" placeholder="Enter your email"></td>
								</tr>
								<tr>
								</tr>
								<tr>
									<td><label>Password</label></td>
									<td><input type="password" name="passwordlogin"
										required="required" placeholder="Enter your password"></td>
							</table>
							<br>
							<div align="center">
								<button type="submit" class="brn btn-success">Login</button>

							</div>
							<div align="center">
								<a href="<%=request.getContextPath()%>/forgotpassword">
									Forgot Password</a>

							</div>
							<div align="center">
								<a href="<%=request.getContextPath()%>/signup">Sign Up</a>

							</div>

						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>