<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
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
		<h3 class="text text-success">${msg }</h3>
		<form:form action="data" method="POST" modelAttribute="userModel">
			<table class="table-hover">
				<tr class="primary">
					<td colspan="2">
						<h1 class="text text-primary">Register Here !</h1>
					</td>
				</tr>
				<tr>
					<td><h5>First Name</h5></td>
					<td><form:input class="form-control" path="firstName"
							required="required" /></td>
				</tr>
				<tr>
					<td><h5>Last Name</h5></td>
					<td><form:input class="form-control" path="lastName"
							required="required" /></td>
				</tr>
				<tr>
					<td><h5>Email</h5></td>
					<td><form:input class="form-control" type="email" path="email"
							required="required" /></td>
				</tr>
				<tr>
					<td><h5>Phone No</h5></td>
					<td><form:input class="form-control" path="phoneNo"
							required="required" /></td>
				</tr>
				<tr>
					<td><h5>DOB</h5></td>
					<td><form:input class="form-control" type="date" path="dob"
							required="required" /></td>
				</tr>
				<tr>
					<td><h5>Gender</h5></td>
					<td><form:radiobutton class="radio-inline" required="required"
							path="gender" value="M" />&nbsp;MALE <form:radiobutton
							class="radio-inline" path="gender" value="F" />&nbsp;FEMALE</td>
				</tr>
				<tr>
					<td><h5>Country</h5></td>
					<td><form:select class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" path="country.countryID"
							items="${countryList}" required="required">
							<form:option value="-" label="-SELECT-"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><h5>State</h5></td>
					<td><form:select class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" path="state.stateID"
							items="${stateList}" required="required">
						</form:select></td>
				</tr>
				<tr>
					<td><h5>City</h5></td>
					<td><form:select class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" path="city.cityID"
							items="${cityList}" required="required">
						</form:select></td>
				</tr>
				<tr>
					<td align="right"><input class="btn btn-danger" type="reset"
						value="RESET"></td>
					<td align="center"><input class="btn btn-success"
						type="submit" value="REGISTER"></td>
				</tr>
			</table>
		</form:form>
	</div>



</body>
</html>