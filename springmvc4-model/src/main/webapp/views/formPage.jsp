<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Spring MVC Form Example</title>
</head>
<body>
	<form action="form" method="POST">
		<lable>ID:</lable><br>
		<input type="text" name="id"/><br>
		<lable>NAME:</lable><br>
		<input type="text" name="name"/><br>
		<lable>PHONE:</lable><br>
		<input type="text" name="phone"/><br>
		<input type="Submit" name="Save"/><br>
	</form>
</body>
</html>