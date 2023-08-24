<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/ck-content.css">
</head>
<body>
	<div id="container">
		<h1>글 상세보기</h1>
		<div class="btn"><input type="button" onclick="location.href='./updateForm.do?seq=${seq}'" value="수정하기"></div>			
		<div id="content" class="ck-content">
			${content}
		</div>
	</div>
</body>
</html>