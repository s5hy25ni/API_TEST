<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CKEditor</title>
<link rel="stylesheet" href="./css/index.css">
</head>
<body data-editor="ClassicEditor" data-collaboration="false" data-revision-history="false">
<div id="container">
	<form action="./home.do" method="post">
		<textarea class="editor"></textarea>
	</form>
</div>
<script type="text/javascript" src="./lib/ckeditor5-39.0.1/build/ckeditor.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>