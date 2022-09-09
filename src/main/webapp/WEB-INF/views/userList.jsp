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
		<br /> <br />
		<p style="font-family: verdana; font-size: 40px">My user List</p>
		<table border="1">
			<tr>
				<th>User Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Email</th>
				<th>Public Registry</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.name}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td>${user.isPublic}</td>

				</tr>
			</c:forEach>
		</table>
		<br />
		<!-- <form action="login" method="post">
			<input type="button" value="Download My users" />
		</form> -->
		<br /> <a href="adminDashboard">Back to Dashboard</a>
	</center>
</body>
</html>
