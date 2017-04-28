<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Example</title>
</head>
<body>
	<h2>User Information</h2>
	<form:form method="POST" action="form">
		<table>
			<tr>
				<td><form:label path="id">ID:</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">NAME:</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">PHONE:</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td colspan="1"></td><td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>