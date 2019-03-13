app.service('DepService',function($http){
	this.findPage=function(page,rows){
		return $http.get('../dep/findPage.do?page='+page+'&rows='+rows);
	}
	
	this.logicdelById=function(id){
		return $http.get('../dep/logicdelById.do?id='+id);
	}
	
	this.update=function(entity){
		return $http.post('../dep/update.do',entity);
	}
	
	this.findById=function(id){
		return $http.get('../dep/findById.do?id='+id);
	}
	
	this.insert=function(entity){
		return $http.post('../dep/insert.do',entity);
	}
	
	this.delByIds=function(ids){
		return $http.get('../dep/delByIds.do?ids='+ids);
	}
});