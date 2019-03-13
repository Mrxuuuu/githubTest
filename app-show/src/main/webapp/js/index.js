$(function(){
	$("#username").onfocusout(function(){
		var name=$("#username").val();
		var psd=$("#password").val();
		if(name.length==0){
			layer.tips('用户名不能为空！','#username',{
				tipsMore:true,
				tips:[2,'red']
			});
		}else {
			//判断用户名是否重名
			$.ajax({
				type:"post",
				}
				
			);
			
		}
	})
	
	
	
})
