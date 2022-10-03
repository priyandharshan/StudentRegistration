<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ragala High School</title>
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
				<li><a href="<%=request.getContextPath()%>/students"
					class="nav-link" style="text-color: white" s>Students</a></li>
				<li><a href="<%=request.getContextPath()%>/subjects"
					class="nav-link" style="text-color: white" s>Subjects</a></li>
				<li><a href="<%=request.getContextPath()%>/examination"
					class="nav-link" style="text-color: white" s>Examination</a></li>
			</ul>
		</nav>
	</header>

	<div class="center">
		<div class="column">
			<div class="card">
				<img alt="" src="images/photo.jpg">
			</div>
		</div>



	</div>

</body>
</html>