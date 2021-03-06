<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

<script src="./js/app.js"></script>

<script>
	$(document).ready(function(e) {
		$("#email").blur(function(event) {
			$("#dupEmail").html("");
			var emailId = $("#email").val();
			$.ajax({
				url : 'validateEmail?email=' + emailId,
				success : function(response) {
					if (response == 'duplicate') {
						$("#dupEmail").html("Email already Exist");
						$("#email").focus();
					}
				}
			});
		});
	});
</script>
<title>User Management Application</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container" align="center">
		<h3 class="text text-success">${msg }</h3>
		<form:form action="data" method="POST" modelAttribute="userModel">
			<table class="table-hover">
				<tr class="primary">
					<td colspan="2">
						<h2 class="text text-primary">Register Here</h2>
					</td>
				</tr>
				<tr>
					<td><h5>First Name</h5></td>
					<td><form:input class="form-control" path="firstName"
							required="required" placeholder="INPUT FIRST NAME" /></td>
				</tr>
				<tr>
					<td><h5>Last Name</h5></td>
					<td><form:input class="form-control" path="lastName"
							required="required" placeholder="INPUT LAST NAME" /></td>
				</tr>
				<tr>
					<td><h5>Email</h5></td>
					<td><form:input class="form-control" type="email" path="email"
							required="required" placeholder="INPUT EMAIL ADDRESS" /> <font
						color='red'>
							<div id="dupEmail"></div>
					</font></td>
				</tr>
				<tr>
					<td><h5>Phone No</h5></td>
					<td><form:input class="form-control" path="phoneNo"
							required="required" placeholder="INPUT PHONE NUMBER" /></td>
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
							type="button" data-toggle="dropdown" path="countryID"
							required="required">
							<form:option class="btn btn-default dropdown-toggle" value="">-SELECT-</form:option>
							<form:options class="btn btn-default dropdown-toggle"
								items="${countryMap}"></form:options>
						</form:select></td>
				</tr>

				<tr>
					<td><h5>State</h5></td>
					<td><form:select class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" path="stateID">
							<form:option value="">-SELECT</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><h5>City</h5></td>
					<td><form:select class="btn btn-default dropdown-toggle"
							type="button" data-toggle="dropdown" path="cityID">
							<form:option value="">-SELECT</form:option>
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