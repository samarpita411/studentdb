<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
<form action="./update" method="post">
		<fieldset title="Search">
			<legend><B>Update Student Info</B></legend>
			<BR/>
			<table height="60%">
			<tr>
			<td>regno</td>
				<td><input type="number" name="regno" placeholder="Insert  student regno"/></td>
			</tr>
			<tr>
			<td>first Name  </td>
				<td><input type="text" name="firstname" placeholder="Insert  student name"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
				<td><input type="submit" value="Reset"/></td>
			</tr>
</table>
</body>
</html>