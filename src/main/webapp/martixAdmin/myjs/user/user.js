// 加载列表
var loadData = function(){
	$(".tableList").html("");
	$.getTemplete("userTemplate.html",function(data){
		$(".tableList").append(data);
		$(data).find("table:first").attr("id",new Date().getTime());
	});
	$.ajaxReq({
		"url":'/user/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				var status = "正常"
				if(result.disabled) status = "冻结";
				var str = 
				  "<tr><td>"+ result.userAccount +"</td><td>"+ result.email +"</td>"+
				  "<td class='center'>"+status+"</td>"+
				  "<td>"+
				  "<a onclick=restPassword('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>重置密码</a>"+
				  "<a onclick=delEntity('"+result.id+"',this) class='btn btn-danger' href='#'><i class='glyphicon glyphicon-trash icon-white'></i>删除</a>" +
				  "</td></tr>";
				$("tbody:first").append(str);
			}
			initDatables();
		}
	});
}
function addRecharge(id){
	$.getTemplete("rechargeAddTemplete.html",function(calBackHtml){
		dialog({
			title:'请输入金额',
			content:"<input type='text' class='span3' name='price' placeholder='请输入金额' />",
			okValue:'提交',
			ok:function(){
				var that = this;
				var price = $("div[i='dialog']").find("input[name='price']").val();
				$.ajaxReq({
					"url":"/gamer/recharge",
					"data":{id:id,price:price},
					"type":"POST",
					success:function(data){
						invokeCallBackInfo('充值',data);
						that.remove();
						loadData();
					}
				});
				return false;
				},
			cancelValue:'取消',
			cancel:function(){}
		}).showModal();
	});
}
function restPassword(id){
	modifyEntity("重置密码", '/user/resetPassword', "POST", {id:id});
}
function delEntity(id){
	delelteEntity("/user/del","POST",{id:id},loadData);
}
$(function(){
	// 加载列表
	loadData();
});