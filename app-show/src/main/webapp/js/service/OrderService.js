app.service('OrderService',function($http){
	
	this.findPage=function(page,rows){
		return $http.get('../order/findPage.do?page='+page+'&rows='+rows);
	}
	
	this.findById=function(ordId,userId,chargeId){
		return $http.get('../order/findById.do?ordId='+ordId+'&userId='+userId+'&chargeId='+chargeId);
	}
	
	this.update=function(entity){
		return $http.post('../order/update.do?',entity);
	}
	
	this.add=function(entity){
		return $http.post('../order/add.do?',entity);
	}
	
	this.delById=function(id){
		return $http.get('../order/delById.do?id='+id);
	}
	
	this.selectByType=function(page,rows,Queryentity){
		return $http.post('../order/selectByType.do?page='+page+'&rows='+rows,Queryentity);
	}
});