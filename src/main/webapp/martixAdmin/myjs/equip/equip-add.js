

// 添加管理员
$(".entity-add").on("click",function(){
	console.log($("form").serialize());
	createEntity("添加装备", "/equip/add", "POST", $("form").serialize());
});


