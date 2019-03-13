$(function(){
	
	layui.use('table',function(){
		var table=layui.table;
		//执行渲染
		table.render({
			elem:'#demo',//指定原始表格元素
			height:300,
			cols:[[{field:'pid',title:'编号'},{field:'pname',title:'用户名',style:{'color':'red'}}]],//设置表头
		});
		
	})  
	
	
	
/*	$.ajax({
		url:"part_query",
		dataType:'json',
		data:,
		success:function(message){
			//把数据填充到表格中
		  layer.use('table',function(){
		  	var table=layui.table();
		  	
		  })
		}
	});*/
})
