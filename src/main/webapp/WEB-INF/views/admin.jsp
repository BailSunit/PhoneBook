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
		<p style="font-family: verdana; font-size: 50px">Online PhoneBook</p>
		<br /> <br />
		<h1>Administrator Sign In</h1>
		<form:form modelAttribute="user">
			<table>
				<tr>
					<td>Username</td>
					<td><form:input path="username" required="required" /></td>

				</tr>
				<tr>
					<td>Password</td>
					<td><form:input type="password" path="password"
							required="required" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Login" />
		</form:form>
		<br /> <br /> <br />
	</center>
</body>
</html>
