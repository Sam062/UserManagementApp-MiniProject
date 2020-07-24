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

	<hr>
	<div class="container" align="center">
		<form:form action="data" method="POST" modelAttribute="userModel">
			<table class="table-hover">
				<tr class="primary">
					<td colspan="2">
						<h1 class="text text-success">Register Here !</h1>
					</td>
				</tr>
				<tr>
					<td><h5>First Name</h5></td>
					<td><form:input path="firstName" required="required" /></td>
				</tr>
				<tr>
					<td><h5>Last Name</h5></td>
					<td><form:input path="lastName" required="required" /></td>
				</tr>
				<tr>
					<td><h5>Email</h5></td>
					<td><form:input path="email" required="required" /></td>
				</tr>
				<tr>
					<td><h5>Phone No</h5></td>
					<td><form:input path="phoneNo" required="required" /></td>
				</tr>
				<tr>
					<td><h5>DOB</h5></td>
					<td><form:input path="dob" required="required" /></td>
				</tr>
				<tr>
					<td><h5>Gender</h5></td>
					<td><form:radiobutton required="required" path="gender"
							value="male" />&nbsp;MALE <form:radiobutton path="gender"
							value="female" />&nbsp;FEMALE</td>
				</tr>
				<tr>
					<td><h5>Country</h5></td>
					<td><form:input path="country" required="required" /></td>
				</tr>
				<tr>
					<td><h5>State</h5></td>
					<td><form:input path="state" required="required" /></td>
				</tr>
				<tr>
					<td><h5>City</h5></td>
					<td><form:input path="city" required="required" /></td>
				</tr>
				<tr>
					<td align="right"><input class="btn btn-danger" type="reset"
						value="RESET"></td>
					<td><input class="btn btn-success" type="submit"
						value="REGISTER"></td>
				</tr>
			</table>
		</form:form>
	</div>



</body>
</html>