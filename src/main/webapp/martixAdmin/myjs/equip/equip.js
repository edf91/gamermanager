// 加载列表
var loadData = function(){
	$(".tableList").html("");
	$.getTemplete("equipTemplate.html",function(data){
		$(".tableList").append(data);
		$(data).find("table:first").attr("id",new Date().getTime());
	});
	$.ajaxReq({
		"url":'/equip/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				var str = 
				  "<tr><td>"+ result.name +"</td><td>"+ result.quality +"</td>"+
				  "<td class='center'>"+result.price+"</td>"+
				  "<td>"+
				  "<a onclick=editEntity('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>编辑</a>"+
				  "<a onclick=delEntity('"+result.id+"',this) class='btn btn-danger' href='#'><i class='glyphicon glyphicon-trash icon-white'></i>删除</a>" +
				  "</td></tr>";
				$("tbody:first").append(str);
			}
			initDatables();
		}
	});
}
function editEntity(id){
	$.ajaxReq({
		"url":'/equip/get',
		"type":'POST',
		"data":{id:id},
		success:function(data){
			var result = data.data;
			$.getTemplete("equipEdit.html",function(callBackHtml){
				dialog({
					title:'编辑装备',
					content:callBackHtml,
					okValue:'提交',
					ok:function(){
						modifyEntity("编辑装备", "/equip/update", "POST", $("div[i='dialog']").find("form").serialize(), loadData);
					},
					cancelValue:'取消',
					cancel:function(){
						
					}
				}).showModal();
				$("div[i='dialog']").find("input[name='id']").val(id);
				$("div[i='dialog']").find("input[name='name']").val(result.name);
				$("div[i='dialog']").find("input[name='quality']").val(result.quality);
				$("div[i='dialog']").find("input[name='price']").val(result.price);
			});
		}
	});
}
function delEntity(id){
	delelteEntity("/equip/del","POST",{id:id},loadData);
}
$(function(){
	// 加载列表
	loadData();
});