$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '活动名称', field: 'activity.title' }, 			
			{ title: '姓名', field: 'realName' }, 			
			{ title: '手机号码', field: 'mobile' },
		    { title: '完成状态', field: 'status' , formatter: function(value, options, row){
				if(value==1){
					return '<span class="label label-success">已完成</span>';
				}else{
					return '<span class="label label-danger">未完成</span>';
				}
			   }},
			{ title: '提交时间', field: 'createTime', formatter: function(value, options, row){ return formatTime(value); }}		
]

$("#table").bootstrapTable({
	        url: baseURL + 'activityjoin/list',
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
		        	limit: params.limit,
		        	channelId: vm.q.channelId,
		        	activityId: vm.q.activityId
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		activityJoin: {},
		channelList: [],
		activityList: [],
		q: {
			channelId: '',
			activityId: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		changestatus: function () {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			confirm('确定已完成活动吗？', function(){
				$.ajax({
					type: "POST",
					url: baseURL + "activity/changestatus",
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
		exportJoin: function(){
			window.location.href = baseURL + "activityjoin/exportExcel?token="+token;
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.activityJoin = {};
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
			var url = vm.activityJoin.id == null ? "activityjoin/save" : "activityjoin/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.activityJoin),
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
				    url: baseURL + "activityjoin/delete",
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
			$.get(baseURL + "activityjoin/info/"+id, function(r){
                vm.activityJoin = r.activityJoin;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refresh',  {pageNumber: 1});
		},
		getChannel: function(){
			$.get(baseURL + "channel/listAll", function(r){
				vm.channelList = r.channelList;
			});
		},
		getActivity: function(){
			$.get(baseURL + "activity/listAll", function(r){
				vm.activityList = r.activityList;
			});
		}
	},
	created: function(){
		this.getChannel();
		this.getActivity();
	}
});