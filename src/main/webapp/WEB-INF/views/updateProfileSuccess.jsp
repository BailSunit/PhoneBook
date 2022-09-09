<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PhoneBook</title>
</head>
<body>
	<center>
		<br /> <br /> <br /> <br /> <br />
		<p style="font-family: verdana; font-size: 50px">Updated Profile
			Successfully</p>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Email</th>
			</tr>
			<tr>
				<td>${requestScope.user.name}</td>
				<td>${requestScope.user.phone}</td>
				<td>${requestScope.user.address}</td>
				<td>${requestScope.user.email}</td>
			</tr>
		</table>
		Currently consenting to presence in a public registry : <b>${requestScope.consent}</b>
		<br /> <br /> <a href="dashboard">Back to dashboard</a>
	</center>
</body>
</html>
