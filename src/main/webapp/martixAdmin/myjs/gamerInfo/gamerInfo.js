// 加载列表
var loadData = function(){
	$(".tableList").html("");
	$.getTemplete("gamerTemplate.html",function(data){
		$(".tableList").append(data);
		$(data).find("table:first").attr("id",new Date().getTime());
	});
	$.ajaxReq({
		"url":'/gamer/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				var gender = "男";
				if(result.gender == 'FAMALE') gender = "女";
				var status = "正常"
				if(result.disabled) status = "冻结";
				var num = 0;
				if(result.rechargeIds){
					num = result.rechargeIds.split(",").length;
				}
				var str = 
				  "<tr><td>"+ result.name +"</td><td class='center'>"+gender+"</td>"+
				  "<td>"+ result.level +"</td><td class='center'>"+result.sociatyName+"</td><td class='center'>"+result.profession+"</td>"+
				  "<td>"+ result.email +"</td><td class='center'>"+result.mobile+"</td><td class='center'>"+num+"</td><td class='center'>"+result.totalPrice+"</td>"+
				  "<td class='center'>"+status+"</td>"+
				  "<td><a onclick=addRecharge('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>充值</a>"+
				  "<a onclick=addEquip('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>分配装备</a>"+
				  "<a onclick=editEntity('"+result.id+"') class='btn btn-info' href='#'><i class='glyphicon glyphicon-edit icon-white'></i>编辑</a>"+
				  "<a onclick=delEntity('"+result.id+"',this) class='btn btn-danger' href='#'><i class='glyphicon glyphicon-trash icon-white'></i>删除</a></td></tr>";
				$("tbody:first").append(str);
			}
			initDatables();
		}
	});
}
// 加载装备信息
var loadEquip = function(id){
	$.ajaxReq({
		"url":'/equip/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			$("div[i='dialog']").find("#equipList").html("");
			$("div[i='dialog']").find("input[name='id']").val(id);
			for(var i = 0; results[i]; i++){
				var result = results[i];
				var str = 
				  "<option value='"+result.id+"'>"+ result.name +"</option>";
				$("div[i='dialog']").find("#equipList").append(str);
			}
		}
	});
}
function addEquip(id){
	$.getTemplete("selectEquip.html",function(callBackHtml){
		dialog({
			title : "分配装备",
			content: callBackHtml,
		    button: [
		        {
		        	value: '提交',
		            callback: function () {
		            	var that = this;
						$.ajaxReq({
							"url":"/gamer/grantEquip",
							"type":"POST",
							"data":$("div[i='dialog']").find("form").serialize(),
							success:function(data){
								invokeCallBackInfo('分配装备', data);
								that.remove();
							}
						});
						return false;
		            }
		        },
		        {
		        	value: '查看已有装备',
		            callback: function () {
		            	$.ajaxReq({
		            		"url":"/gamer/get",
		            		"type":"POST",
		            		"data":{id:id},
		            		success:function(data){
		            			var result = data.data.equipmentDTOs;
		            			console.log(result);
		            			var str = "";
		            			for(var i = 0; result[i]; i++){
		            				var entity = result[i];
		            				str += "装备名称："+entity.name + "&nbsp;&nbsp;&nbsp;&nbsp;装备质量："+ entity.quality + "&nbsp;&nbsp;&nbsp;&nbsp;装备价格：" + entity.price + "￥</br>";
		            			}
		            			var htmlData = "<div class='alert alert-success alert-block'> <a class='close' data-dismiss='alert' href='#'>×</a><h4 class='alert-heading'>查看装备!</h4>"+
					              str + "</div>";
				            	dialog({
									title:'已有装备',
									content:htmlData,
									cancelValue:'取消',
									cancel:function(){}
									}).showModal();
		            		}
		            	});
		            	return false;
		            }
		        },
		        {
		            value: '关闭'
		        }
		    ]
		}).showModal();
		
		loadEquip(id);
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
//加载工会
var loadSociaty = function(sociatyName){
	$("div[i='dialog']").find("#sociatyList").html("");
	$.ajaxReq({
		"url":'/sociaty/list',
		"type":"POST",
		success:function(data){
			var results = data.data;
			for(var i = 0; results[i]; i++){
				var result = results[i];
				if(result.disabled) continue;
				var isCheck = "";
				if(sociatyName == result.name) isCheck = "selected=true";
				var str = "<option "+isCheck+" value='"+result.id+"'>"+ result.name +"</option>";
				$("div[i='dialog']").find("#sociatyList").append(str);
			}
		}
	});
}
function editEntity(id){
	$.ajaxReq({
		"url":'/gamer/get',
		"type":"POST",
		"data":{id:id},
		success:function(data){
			var result = data.data;
			$.getTemplete("gamerInfoDetail.html",function(callBackHtml){
				dialog({
					title:"玩家详情",
					content:callBackHtml,
					okValue:"确定",
					ok:function(){
						modifyEntity("编辑玩家", "/gamer/update", "POST", $("div[i='dialog']").find("form").serialize(), loadData);
					}
				}).showModal();
				
				$("div[i='dialog']").find("input[name='name']").val(result.name);
				$("div[i='dialog']").find("input[name='id']").val(id);
				$("div[i='dialog']").find("input[name='email']").val(result.email);
				$("div[i='dialog']").find("input[type='radio']").each(function(index,item){
					if($(this).val() == result.gender && result.gender == 'FAMALE') $(this).attr("checked",true);
					if($(this).val() == result.gender && result.gender == 'MALE') $(this).attr("checked",true);
					
				});
				$("div[i='dialog']").find("input[name='level']").val(result.level);
				$("div[i='dialog']").find("input[name='address']").val(result.address);
				$("div[i='dialog']").find("input[name='telPhone']").val(result.telPhone);
				$("div[i='dialog']").find("input[name='mobile']").val(result.mobile);
				$("div[i='dialog']").find("input[name='email']").val(result.email);
				$("div[i='dialog']").find("input[name='profession']").val(result.profession);
				loadSociaty(result.sociatyName);
				
			});
		}
	});
}
function delEntity(id){
	delelteEntity("/gamer/del","POST",{id:id},loadData);
}
$(function(){
	// 加载列表
	loadData();
});