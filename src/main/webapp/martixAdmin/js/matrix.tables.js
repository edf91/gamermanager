var initDatables;
$(document).ready(function(){
	
	initDatables = function(){
		$('.data-table').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers",
			"sDom": '<""l>t<"F"fp>',
			"oLanguage":{
				"sProcessing": "正在加载中......",
				"sLengthMenu": "每页显示 _MENU_ 条记录",
				"sZeroRecords": "对不起，查询不到相关数据！",
				"sEmptyTable": "表中无数据存在！",
				"sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
				"sInfoFiltered": "数据表中共为 _MAX_ 条记录",
				"sSearch": "搜索",
				"oPaginate": {
					"sFirst": "首页",
					"sPrevious": "上一页",
					"sNext": "下一页",
					"sLast": "末页"
				}
			}
		});
		$('.dataTables_filter input').attr("placeholder", "全文搜索...");
		$('input[type=checkbox],input[type=radio],input[type=file]').uniform();
		
		$('select').select2();
		
		$("span.icon input:checkbox, th input:checkbox").click(function() {
			var checkedStatus = this.checked;
			var checkbox = $(this).parents('.widget-box').find('tr td:first-child input:checkbox');		
			checkbox.each(function() {
				this.checked = checkedStatus;
				if (checkedStatus == this.checked) {
					$(this).closest('.checker > span').removeClass('checked');
				}
				if (this.checked) {
					$(this).closest('.checker > span').addClass('checked');
				}
			});
		});	
	}
});
