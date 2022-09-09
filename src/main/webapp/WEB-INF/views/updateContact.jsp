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
		<p style="font-family: verdana; font-size: 40px">Update a contact</p>
		<br /> <br />
		<h1>Update details</h1>
		<form:form modelAttribute="contact">
			<table>
				<tr>
					<td>Contact Name</td>
					<td><form:input path="name" /></td>

				</tr>
				<tr>
					<td>Phone number</td>
					<td><form:input path="phone"/></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address"/></td>
				</tr>
			</table>
			<br />
			<form:input type="hidden" path="id"/>
			<input type="hidden" name="source" value="finalForm" />
			<input type="submit" value="Update Contact" />
		</form:form>
	</center>
</body>
</html>
