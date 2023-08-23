<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
	<div id="container">
		<h1>글 목록</h1>
		<div id="list">
			<ul>
				<c:forEach items="${list}" var="list">
					<li><a href="./detail.do?seq=${list.seq}">${fn:substring(list.content,0,20)}...</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>