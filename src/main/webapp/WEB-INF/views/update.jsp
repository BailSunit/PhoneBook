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
		<form action="update.htm" method="post">
			<br /> <br />
			<p style="font-family: verdana; font-size: 40px">My Contact List</p>
			<table border="1">
				<tr>
					<th>Select</th>
					<th>Contact Name</th>
					<th>Phone</th>
					<th>Address</th>
				</tr>
				<c:forEach items="${contactList}" var="contact">
					<tr>
						<td><INPUT TYPE="RADIO" NAME="contact"
							VALUE="${contact.id}"></td>
						<td>${contact.name}</td>
						<td>${contact.phone}</td>
						<td>${contact.address}</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br /> <input type="hidden" name="source" value="firstForm" />
			<input type="submit" value="Update Contact" />
		</form>
		<br /> <br /> <a href="dashboard">Back to Dashboard</a>
	</center>
</body>
</html>
