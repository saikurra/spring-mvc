<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<div>
		<a href="${actionUrl}">New Item</a>
	</div>
	<div>
		<table>
			<thead>
				<th>To do</th>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td><a href="${contextPath}/items/${item.id}/edit">${item.todo}</a></td>
						<td>${item.notes}</td>
						<td>${item.type}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>