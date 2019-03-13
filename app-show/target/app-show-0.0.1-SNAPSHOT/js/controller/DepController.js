app.controller('DepController',function($scope,DepService){
	
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
		DepService.findPage(page,rows).success(
		function(response){
			if(response!=null)
				{
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
				}
		});
	}
	
	/**
	 * 逻辑删除
	 * 置status为0
	 */
	$scope.logicdelById=function(id){
		DepService.logicdelById(id).success(function(response){
			if(response.flag==true)
				{
				
				
				$scope.reloadList();
				/*alert(response.message);*/
				}
			else{
				alert(response.message);
			}
		});
	}
	
	/**
	 * 修改并保存部门信息
	 */
	$scope.save=function(){
		if($scope.entity.depId!=null)
			{//id不为空就修改
			DepService.update($scope.entity).success(function(response){
				if(response.flag==true){
					$scope.reloadList();
					/*alert(response.message);*/
				}
				else{
					c
				}
			});
			}
		else{//id为空就插入
			DepService.insert($scope.entity).success(function(response){
				if(response.flag==true){
					$scope.reloadList();
					/*alert(response.message);*/
				}
				else{
					alert(response.message);
				}
			});
		}	
	}
	
	
	/**
	 * 点击修改前查找实体信息
	 */
	$scope.findById=function(id){
		DepService.findById(id).success(function(response){
			$scope.entity=response;
		});
	}
	
	//批量勾选
	$scope.selectIds=[];//选中的ID集合 
	//更新复选
	$scope.updateSelection = function($event, id) {		
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push(id);			
		}else{
			var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 
		}
	}
	
	
	//批量删除勾选的选项
	$scope.delByIds=function(){
		DepService.delByIds($scope.selectIds).success(function(response){
			if(response.flag==true)
				{
				$scope.reloadList();
				}
			else{
                alert(response.message);
			}
		})
	}
});