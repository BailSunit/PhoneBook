<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PhoneBook</title>
</head>
<body>
	<center>
		<br /> <br />
		<p style="font-family: verdana; font-size: 40px">Register for
			PhoneBook</p>
		<br /> <br />
		<h1>Enter details</h1>
		<form:form modelAttribute="user">
			<table>
				<tr>
					<td>Full Name*</td>
					<td><form:input path="name" required="required" /></td>

				</tr>
				<tr>
					<td>Email*</td>
					<td><form:input path="email" type="email" required="required" /></td>

				</tr>
				<tr>
					<td>Phone*</td>
					<td><form:input path="phone" required="required" /></td>

				</tr>
				<tr>
					<td>Username*</td>
					<td><form:input path="username" required="required" /></td>

				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="password" path="password"
							required="required" /></td>
				</tr>
			</table>
			<br />
			<br />
			<input type="radio" id="truth" name="consent" value="truth" required="required">
			<label for="truth"><i>I consent to being added to a
					public registry</i></label>
			<br />
			<input type="radio" id="falsehood" name="consent" value="falsehood">
			<label for="truth"><i>I do not consent to being added to
					a public registry</i></label>
			<br />
			<br />
			<input type="submit" value="Register" />
		</form:form>
	</center>
</body>
</html>
