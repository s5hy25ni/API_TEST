<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<ul>
		<c:forEach items="${list}" var="list">
			<li><a href="./detail.do?seq=${list.seq}">${list.seq}</a></li>
		</c:forEach>
	</ul>
</body>
</html>