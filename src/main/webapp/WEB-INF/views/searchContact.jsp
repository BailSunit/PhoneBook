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
		<p style="font-family: verdana; font-size: 40px">Search contact</p>
		<br /> <br />
		<form action="searchContact.htm" method="post">
			Keyword : <input type="text" name="keyword" /> <br /> <INPUT
				TYPE="RADIO" NAME="parameter" VALUE="name" required="required">Search
			By Name<br /> <INPUT TYPE="RADIO" NAME="parameter" VALUE="phone">Search
			By Phone<br /> <INPUT TYPE="RADIO" NAME="parameter" VALUE="address">Search
			By Address<br /> <br /> <input type="submit" value="Search Contact" />
		</form>
		<br />
		<br /> <br /> <a href="dashboard">Back to Dashboard</a>
	</center>
</body>
</html>
