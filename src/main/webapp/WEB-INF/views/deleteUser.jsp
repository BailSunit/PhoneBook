<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PhoneBook</title>
</head>
<body>
	<center>
		<form action="deleteUser.htm" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">Current User
				List</p>
			<table border="1">
				<tr>
					<th>Select</th>
					<th>User Name</th>
					<th>Phone</th>
					<th>Address</th>
					<th>Email</th>
					<th>Public Registry</th>
				</tr>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td><INPUT TYPE="RADIO" NAME="user" VALUE="${user.id}"></td>
						<td>${user.name}</td>
						<td>${user.phone}</td>
						<td>${user.address}</td>
						<td>${user.email}</td>
						<td>${user.isPublic}</td>

					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="hidden" name="source" value="firstForm" />
			<input type="submit" value="Delete User" />
		</form>
		<br /> <br /> <a href="adminDashboard">Back to Admin Dashboard</a>
	</center>
</body>
</html>
