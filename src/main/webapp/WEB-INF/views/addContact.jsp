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
		<p style="font-family: verdana; font-size: 40px">Add a contact</p>
		<br /> <br />
		<h1>Enter details</h1>
		<form:form modelAttribute="contact">
			<table>
				<tr>
					<td>Contact Name</td>
					<td><form:input path="name" required="required" /></td>

				</tr>
				<tr>
					<td>Phone number</td>
					<td><form:input path="phone" required="required" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" required="required" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Create Contact" />
		</form:form>
		<br /> <a href="upload">Upload My Contacts Instead</a> <br /> <br />
		<br /> <a href="dashboard">Back to Dashboard</a>
	</center>
</body>
</html>
