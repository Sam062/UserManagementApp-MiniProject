<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>User Management Application</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container" align="center">
		<form:form action="validate" method="POST" modelAttribute="userModel">
			<table class="table-hover">
				<tr class="primary">
					<td colspan="2">
						<h2 class="text text-primary">Login Here !</h2>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<h1 class="text text-danger">${msg}</h1>
					</td>
				</tr>
				<tr>
					<td><h5>Email :</h5></td>
					<td><form:input class="form-control" type="email" path="email"
							required="required" placeholder="INPUT EMAIL ADDRESS" /></td>
				</tr>
				<tr>
					<td><h5>Password :</h5></td>
					<td><form:password class="form-control" path="password"
							required="required" placeholder="INPUT PASSWORD" /></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input class="btn btn-success"
						type="submit" value="Sign in"></td>
				</tr>
				<tr>
					<td align="right"><a href="/home">SignUp</a></td>
					<td align="center"><a href="/forgotPwd">Forgot Password</a></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>