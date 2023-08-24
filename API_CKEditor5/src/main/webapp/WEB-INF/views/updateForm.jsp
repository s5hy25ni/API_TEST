<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
<link rel="stylesheet" href="./css/ckeditor.css">
<link rel="stylesheet" href="./css/index.css">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body data-editor="ClassicEditor" data-collaboration="false" data-revision-history="false">
	<div id="container">
		<h1>CKEditor5 Update</h1>
		<h3>made by tadak</h3>
		<form action="./updateBoard.do" method="post" >
			<input type="hidden" id="seq" name="seq" value="${seq}">
			<textarea id="editor" name="content"></textarea>
		</form>
		<div class="btn"><input type="button" onclick="updateBoard()" value="수정하기"></div>
	</div>
<script type="text/javascript" src="./lib/ckeditor5-39.0.1/build/ckeditor.js"></script>
<script type="text/javascript" src="./js/ckeditor.js"></script>
<script type="text/javascript" src="./js/update.js"></script>
</body>
</html>