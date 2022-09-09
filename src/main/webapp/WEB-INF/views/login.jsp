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
		<br /> <br />
		<p style="font-family: verdana; font-size: 30px">Welcome,
			${sessionScope.name}</p>
	</center>
	<p align="right">
		<a href="logout.htm">Logout</a><br /> <a href="profile">My
			profile</a><br />
	</p>
	<br />
	<br />
	<center>
		<a href="contactList.htm">My Contact List</a> <br /> <br /> <br />
		<a href="addContact.htm">Create Contact</a> <br /> <br /> <br /> <a
			href="searchContact.htm">Search for contacts</a> <br /> <br /> <br />
		<a href="update.htm">Update Contact</a> <br /> <br /> <br /> <a
			href="delete.htm">Delete Contact</a> <br /> <br /> <br />
	</center>
</body>
</html>
