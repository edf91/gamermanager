

// 添加玩家
$(".entity-add").on("click",function(){
	console.log($("form").serialize());
	createEntity("添加玩家", "/gamer/add", "POST", $("form").serialize());
});

//加载工会
var loadSociaty = function(){
	$("#sociatyList").html("");
	$.ajaxReq({
		"url":'/sociaty/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				if(result.disabled) continue;
				var str = "<option value='"+result.id+"'>"+ result.name +"</option>";
				$("#sociatyList").append(str);
			}
		}
	});
}
$(function(){
	loadSociaty();
});

