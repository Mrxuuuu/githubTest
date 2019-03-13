app.controller('DepRecoverController',function($scope,DepRecoverService){
	
	 //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,               //当前页
         totalItems: 1,               //总记录数
         itemsPerPage: 10,            //每页大小
         perPageOptions: [3,5,7,9,15,20,30],
         onChange: function(){
        	 $scope.reloadList();//重新加载
     	 }
	}; 
	
	/**
	 * 分页查询
	 * dep_statu=0
	 */
	$scope.findPage=function(page,rows){
		DepRecoverService.findPage(page,rows).success(function(response){
			if(response!==null)
				{
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
				}
		});
	}
	
	/**
	 * 部门恢复按钮
	 */
	$scope.recover=function(id){
		DepRecoverService.recover(id).success(function(response){
			if(response.flag==true)
			{
				$scope.reloadList();//重新加载
				}
			else{
				alert(response.message);
			}
		});
	}
	
//	根据id删除
	$scope.delById=function(id){
		DepRecoverService.delById(id).success(function(response){
			if(response.flag==true)
			{
				$scope.reloadList();//重新加载
			}
			else{
				alert(response.message);
			}
		});
	}
	
	
});