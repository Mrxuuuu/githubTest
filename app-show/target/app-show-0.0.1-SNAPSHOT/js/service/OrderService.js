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
});