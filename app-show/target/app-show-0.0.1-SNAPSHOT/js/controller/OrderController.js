app.controller('OrderController',function($scope,OrderService){
	
	 //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 1,
         itemsPerPage: 10,
         perPageOptions: [3,10, 20, 30, 40, 50],
         onChange: function(){
         $scope.reloadList();//重新加载
        	 
     	 }
	}; 
	
	/**
	 * 分页查询
	 */
	$scope.findPage=function(page,rows){
		OrderService.findPage(page,rows).success(
		function(response){
			if(response!=null)
				{
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
				}
		});
	}
	
	/**
	 * 根据ID进行查找
	 * 
	 */
	$scope.findById=function(ordId,userId,chargeId){
		OrderService.findById(ordId,userId,chargeId).success(function(response){
			
			$scope.entity=response;
		});
	}
	
	/**
	 * 保存修改后的对象
	 */
	$scope.save=function(){
		OrderService.update($scope.entity).success(function(response){
			if(response.flag==true)
			{
			$scope.reloadList();//重新加载页码
			alert(response.message);
			}
			else{
				alert(response.message);
			}
		});
	}
	
	
});