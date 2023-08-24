$(document).ready(function(){
	$.ajax({
		type:"post",
		url:"./getContent.do",
		data: "seq="+$("#seq").val(),
		dataType:"",
		success:function(data){
			editor.setData(data);
		},
		error:function(){
			alert("getContent.do 잘못된 요청입니다.");
		}
	});
});

function updateBoard(){
	const data = editor.getData();
	$("#editor").text(data);
	$("form").eq(0).submit();
}