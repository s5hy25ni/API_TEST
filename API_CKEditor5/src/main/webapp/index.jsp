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
			<div class="demo-update">
				<textarea id="editor" name="content" placeholder="입력해주세요! textarea"></textarea>
			    <div class="demo-update__controls">
			        <span class="demo-update__words"></span>
			        <svg class="demo-update__chart" viewbox="0 0 40 40" width="40" height="40" xmlns="http://www.w3.org/2000/svg">
			            <circle stroke="hsl(0, 0%, 93%)" stroke-width="3" fill="none" cx="20" cy="20" r="17" />
			            <circle class="demo-update__chart__circle" stroke="hsl(202, 92%, 59%)" stroke-width="3" stroke-dasharray="134,534" stroke-linecap="round" fill="none" cx="20" cy="20" r="17" />
			            <text class="demo-update__chart__characters" x="50%" y="50%" dominant-baseline="central" text-anchor="middle"></text>
			        </svg>
			        <button type="button" class="demo-update__send">Send post</button>
			    </div>
			</div>
		</form>
		<div class="btn"><input type="button" onclick="writeBoard()" value="글쓰기"></div>
		<div class="btn"><input type="button" onclick="location.href='./boardList.do'" value="목록보기"></div>
	</div>
<script type="text/javascript" src="./lib/ckeditor5-39.0.1/build/ckeditor.js"></script>
<script type="module" src="./js/ckeditor.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>