function writeBoard(){
	const data = editor.getData();
	$("#editor").text(data);
	$("form").eq(0).submit();
}