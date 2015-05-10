// 添加工会
$(".entity-add").on("click",function(){
	createEntity("添加工会","/sociaty/add","POST",$("form").serialize());
});
