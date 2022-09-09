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
		<p style="font-family: verdana; font-size: 50px">Updated
			Successfully</p>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Address</th>
			</tr>
			<tr>
				<td>${requestScope.contact.name}</td>
				<td>${requestScope.contact.phone}</td>
				<td>${requestScope.contact.address}</td>
			</tr>
		</table>
		<br /> <br /> <a href="dashboard">Back to dashboard</a>
	</center>
</body>
</html>
