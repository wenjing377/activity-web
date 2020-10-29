$(function () {
	var columns = [

		{ checkbox: true, align: 'center' },
		{ title: '封面', field: 'picUrl', formatter: function(value, options, row){
				return '<img width="100px" src="'+value+'"></img>';
			} },
		{ title: '标题', field: 'title' },
		{ title: '开始时间', field: 'beginTime' , formatter: function(value, options, row){ return formatDate(value, 'yyyy-mm-dd'); }},
		{ title: '结束时间', field: 'endTime' , formatter: function(value, options, row){ return formatDate(value, 'yyyy-mm-dd'); }},
		{ title: '状态', field: 'status', formatter: function(value, options, row){
				if(value==1){
					return '<span class="label label-success">报名中</span>';
				}else{
					return '<span class="label label-danger">已结束</span>';
				}
			}},
		{ title: '活动人数', field: 'totalNumber' },
		{ title: '志愿服务时间', field: 'volunteerTime' },
		{ title: '已报名人数', field: 'joinNumber' },
		{title:'审核状态',field:'flag', formatter: function(value, options, row){
				if(value==1){
					return '<span class="label label-success">通过</span>';
				}else if(value==2){
					return '<span class="label label-danger">不通过</span>';
				}else {
					return '<span class="label label-info">未审核</span>';
				}
			}
		},
		{ title: '创建时间', field: 'createTime', formatter: function(value, options, row){ return formatTime(value); }},
	]

	$("#table").bootstrapTable({
		url: baseURL + 'activity/list',
		cache: false,
		striped: true,
		pagination: true,
		pageSize: 10,
		pageNumber: 1,
		sidePagination: 'server',

		columns: columns,
		queryParams: function (params) {
			return {
				page: params.offset / params.limit + 1,
				limit: params.limit
			}
		}
	});
});
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		activity: {}

	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			ue.setContent("");
			vm.activity = {
				status: 1,
				schoolName: ''
			};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
			vm.title = "修改";

			vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.activity.id == null ? "activity/save" : "activity/update";
			vm.activity.content = ue.getContent();
			vm.activity.beginTime = $("#start").val();
			vm.activity.endTime = $("#end").val();
			vm.activity.volunteerTime = $("#volunteerTime").val();
			if(vm.activity.picUrl == undefined){
				alert("请上传图片");
				return;
			}
			if(vm.activity.title == ''){
				alert("请填写活动标题");
				return;
			}
			if(vm.activity.totalNumber == ''){
				alert("请填写人数");
				return;
			}
			if(vm.activity.beginTime == ''){
				alert("请填开始时间");
				return;
			}
			if(vm.activity.endTime == ''){
				alert("请填结束时间");
				return;
			}
			if(vm.activity.beginTime >= vm.activity.endTime ){
				alert("结束时间不能早于开始时间");
				return;
			}
			if(vm.activity.volunteer_time == ''){
				alert("请填志愿服务时间");
				return;
			}

			$.ajax({
				type: "POST",
				url: baseURL + url,
				contentType: "application/json",
				data: JSON.stringify(vm.activity),
				success: function(r){
					if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}

			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
					url: baseURL + "activity/delete",
					contentType: "application/json",
					data: JSON.stringify(ids),
					success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "activity/info/"+id, function(r){
				r.activity.beginTime = formatDate(r.activity.beginTime, 'yyyy-mm-dd');
				r.activity.endTime = formatDate(r.activity.endTime, 'yyyy-mm-dd');
				vm.activity = r.activity;
				ue.setContent(r.activity.content);
			});
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		}
	}
});