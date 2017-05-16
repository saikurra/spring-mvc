<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<form:form action="${contextPath}/edit-item" method="post"
		id="edititemform">
		<h2>Edit Action</h2>
		<table>
			<form:input path="id" type="hidden" value="${item.id}" />
			<tr>
				<td><form:label path="todo">To Do</form:label></td>
				<td><form:input path="todo" value="${item.todo}" /></td>
			</tr>
			<tr>
				<td><form:label path="notes">Notes</form:label></td>
				<td><form:textarea path="notes" rows="4" cols="50"
						value="${item.notes}"></form:textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save Changes" /></td>
				<td><input type="submit" value="Cancel" /></td>
			</tr>
		</table>
	</form:form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>