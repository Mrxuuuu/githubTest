app.controller('OrderController',function($scope,OrderService){
	
	 //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码  
    	$scope.selectByType( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 1,
         itemsPerPage: 10,
         perPageOptions: [3,5,7, 9, ],
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
		if($scope.entity.order.ordId==null)
			{//id为空则新增
			//新增代码
			OrderService.add($scope.entity).success(function(response){
				if(response.flag==true)
				{
				$scope.reloadList();//重新加载页码
				
				}
				else{
					alert(response.message);
				}
			});
			}
		else{//不为空则修改
			OrderService.update($scope.entity).success(function(response){
				if(response.flag==true)
				{
				$scope.reloadList();//重新加载页码
				alert("ok");
				}
				else{
					alert(response.message);
				}
			});
		}
		
	}
	
	/**
	 * 根据id删除
	 */
	$scope.delById=function(id){
		OrderService.delById(id).success(function(response){
			if(response.flag==true)
				{
				$scope.reloadList();//重新加载页码
				}
			else{
				alert(response.message);
			}
		});
	}
	
	/**
	 * 定义查询类别
	 */
	$scope.Queryentity={"info":"","type":""};
	
	
	/**
	 * 根据查询类别来查询
	 */
	$scope.selectByType=function(page,rows){
		OrderService.selectByType(page,rows,$scope.Queryentity).success(function(response){
			if(response!=null){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		});
	}
	
	/**
	 * 复选框集合
	 */
	$scope.selectIds=[];
	
	/**
	 * 更新复选集合
	 */
	$scope.updateSelect=function($event,id){
		if($event.target.checked)
		{
		$scope.selectIds.push(id);
		}
		else{
		  var index =$scope.selectIds.indexOf(id);
		  $scope.selectIds.splice(index,1);
 		}
	}
	
});