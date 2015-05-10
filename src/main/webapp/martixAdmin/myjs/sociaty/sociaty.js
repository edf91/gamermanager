// 加载列表
var loadData = function(){
	$(".tableList").html("");
	$.getTemplete("socityTemplate.html",function(data){
		$(".tableList").append(data);
		$(data).find("table:first").attr("id",new Date().getTime());
	});
	$.ajaxReq({
		"url":'/sociaty/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				var status = "正常"
				if(result.disabled) status = "冻结";
				var str = "<tr><td>"+ result.name +"</td><td class='center'>"+status+"</td>"+
				  "<td><a onclick=editEntity('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>编辑</a>"+
				  "<a onclick=delEntity('"+result.id+"',this) class='btn btn-danger' href='#'><i class='glyphicon glyphicon-trash icon-white'></i>删除</a></td></tr>";
				$("tbody:first").append(str);
			}
			initDatables();
		}
	});
}
// 编辑工会
function editEntity(id){
	$.ajaxReq({
		"url":'/sociaty/get',
		"type":'POST',
		"data":{id:id},
		success:function(data){
			var result = data.data;
			$.getTemplete("sociatyEdit.html",function(callBackHtml){
				dialog({
					title:'编辑工会',
					content:callBackHtml,
					okValue:'提交',
					ok:function(){
						modifyEntity("编辑工会", "/sociaty/update", "POST", $("div[i='dialog']").find("form").serialize(), loadData);
					},
					cancelValue:'取消',
					cancel:function(){
						
					}
				}).showModal();
				$("div[i='dialog']").find("input[name='id']").val(id);
				$("div[i='dialog']").find("input[name='name']").val(result.name);
			});
		}
	});
	
}
// 删除工会
function delEntity(id){
	delelteEntity("/sociaty/del","POST",{id:id},loadData);
}
$(function(){
	// 加载列表
	loadData();
});