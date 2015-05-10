/**
 * 基础js
 */
var basePath = "http://127.0.0.1:8080"
$.extend({
	"path":basePath,
	ajaxReq:function(params){
		params.url = this.path + params.url;
		$.ajax(params);
	},
	getTemplete:function(url,success){
		var path = 'template/' + url;
        $.get(path,success)
	}
});
// 时间处理
var getDateStrByDateStap = function(dateTimeStap){
	var dateTime = new Date(Number(dateTimeStap));
	return dateTime.getFullYear() + "年" + dateTime.getMonth() + "月" + dateTime.getDay() + "日" + dateTime.getHours() + "时" + dateTime.getMinutes() + "分" + dateTime.getSeconds() + "秒";
}
// 时间处理
var getDateStrByDate = function(dateTimeStap){
	var dateTime = new Date(Number(dateTimeStap));
	return dateTime.getFullYear() + "年" + dateTime.getMonth() + "月" + dateTime.getDay() + "日";
}
// 后台invokeResult返回值提示信息
var invokeCallBackInfo = function(title,data){
	if(data.hasError){
		dialog({
			title:title,
			content: data.errorMsg,
		    cancelValue: '关闭',
		    cancel: function(){}
		}).showModal();
	}else{
		dialog({
			title:title,
			content: data.data,
		    cancelValue: '关闭',
		    cancel: function(){}
		}).showModal();
	}
}
//通用编辑操作
var modifyEntity = function(title,url,type,data,calBack){
	dialog({
		title:title,
		content:'确定'+title+'?',
		okValue:"确定",
		ok:function(){
			var that = this;
			that.title('提交中...');
			$.ajaxReq({
				"url":url,
				"data":data,
				"type":type,
				success:function(data){
					that.remove();
					invokeCallBackInfo(title,data);
					if(calBack) calBack();
				}
			});
			return false;
		},
		cancelValue:'取消',
		cancel:function(){}
	}).showModal();
}
// 添加
var createEntity = function(title,url,type,data){
	modifyEntity(title,url,type,data);
}

// 删除
var delelteEntity = function(url,type,data,calBack){
	modifyEntity("删除",url,type,data,calBack);
}

// 退出系统
function doLogout(){
	$.ajaxReq({
		"url":"/user/logout",
		"type":"POST",
		success:function(data){
			if(data.hasError){
				
			}else{
				window.location.href="login.html"
			}
		}
	});
}