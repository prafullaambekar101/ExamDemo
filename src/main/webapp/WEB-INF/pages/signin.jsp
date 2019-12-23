<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
</head>
<body>
	<div class="container">
		<form:form method="post">
			<div class="card ">
				<div class="card-header bg-primary text-white">
					<h1>Login</h1>
				</div>
				<div class="card-body">
					<div class="form-group">
						<form:label path="email">Email address:</form:label>
						<form:input type="email" class="form-control"
							placeholder="Enter email" path="email" />
						<form:errors path="email"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="pass">Password:</form:label>
						<form:input type="password" class="form-control"
							placeholder="Enter password" path="pass" />
						<form:errors path="pass"></form:errors>
					</div>

				</div>
				<div class="card-footer bg-primary text-white">
					<div class="row">
						<div class="col-6">
							<button type="reset" class="btn btn-danger">Reset</button>
						</div>
						<div class="col-6">
							<button type="submit" class="btn btn-success">Login</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
</body>
</html>