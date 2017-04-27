<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<title>Spring MVC Home Page</title>
</head>
<body>
	<h2>Spring MVC Model Object Demo</h2>
	<p>${message}</p>

	<h2>Technologies List</h2>
	<ul>
		<c:forEach items="${nameList}" var="technology">
			<li>
				<td>${technology}</td>
			</li>
		</c:forEach>
	</ul>


	<h2>User Object Values</h2>
	<p>id :${userDetails.id}, Name: ${userDetails.name} & Phone:
		${userDetails.phone}</p>

	<table>
		<h2>List of User Objects</h2>
		<thead>
			<th>ID</th>
			<th>NAME</th>
			<th>PHONE</th>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>