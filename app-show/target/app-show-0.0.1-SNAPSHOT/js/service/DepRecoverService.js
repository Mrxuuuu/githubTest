app.service('DepRecoverService',function($http){
	
	this.findPage=function(page,rows){
		return $http.get('../deprcv/findPage.do?page='+page+'&rows='+rows);
	}
	
	this.recover=function(id){
		return $http.get('../deprcv/recover.do?id='+id);
	}
	
	this.delById=function(id){
		return $http.get('../deprcv/delById.do?id='+id);
	}
});