<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CKEditor5 API Sample</title>
<link rel="stylesheet" href="./css/ckeditor.css">
<link rel="stylesheet" href="./css/index.css">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body data-editor="ClassicEditor" data-collaboration="false" data-revision-history="false">
	<div id="container">
		<h1>CKEditor5 API Sample</h1>
		<h3>made by tadak</h3>
		<form action="./write.do" method="post" >
			<textarea id="editor" name="content"></textarea>
		</form>
		<div class="btn"><input type="button" onclick="writeBoard()" value="글쓰기"></div>
		<div class="btn"><input type="button" onclick="location.href='./boardList.do'" value="목록보기"></div>
	</div>
<script type="text/javascript" src="./lib/ckeditor5-39.0.1/build/ckeditor.js"></script>
<script type="module" src="./js/ckeditor.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>