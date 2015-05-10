

// 添加管理员
$(".entity-add").on("click",function(){
	console.log($("form").serialize());
	createEntity("添加管理员", "/user/add", "POST", $("form").serialize());
});


