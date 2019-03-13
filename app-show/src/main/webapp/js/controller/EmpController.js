app.controller('EmpController',function($scope,EmpService){
	
	 //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
	
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 1,
         itemsPerPage: 10,
         perPageOptions: [3,5, 7, 9, 10, 20],
         onChange: function(){
         $scope.reloadList();//重新加载
        	 
     	 }
	}; 
	
	/**
	 * 分页查询
	 */
	$scope.findPage=function(page,rows){
		EmpService.findPage(page,rows).success(
		function(response){
			if(response!=null)
				{
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
				}
		});
	}
	
	$scope.empImg={"Img":""};
	
	$scope.uploadFile=function(){
	
		EmpService.uploadFile().success(
				
				function(response){
			if(response.flag){
				alert(response.message);
			}
			else{
				alert(response.message);
			}
		});
	}
	
	$scope.sava=function(){
		alert("sava");
	}
});