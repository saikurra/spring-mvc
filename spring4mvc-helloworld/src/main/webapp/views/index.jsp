<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<title>Spring MVC Home Page</title>
</head>
<body>
	<h2>HelloWorld!</h2>
	<p>Dispatcher servlet in web.xml took the browser request "/",
		component scan in mvc-config helped to find any matching
		RequestMapping handlers, it found one in
		@Controller HomeController --> @RequestMapping("/") home().</p>
	<p>The home() returned index. The view resolver in
		mvc-config added prefix /views and suffix .jsp and looked for
		/views/index.jsp. It found index.jsp and then sent it to browser.</p>
</body>
</html>