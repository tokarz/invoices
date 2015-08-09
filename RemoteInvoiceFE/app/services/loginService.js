'use strict';
app.factory('loginService', ['$http', '$q', function($http, $q) {
	return {
		authenticate : function(username, password) {
			var deferred = $q.defer();
			$http.get('rest/authenticate', {
				params : {
					username : username,
					password : password
				}
			}).success(function(data){
				if(data == true) {
					deferred.resolve(true);
				} else {
					deferred.resolve(false);
				}
			}).error(function(err) {
				console.error(err);
				deferred.resolve(false);
			})
			
			
			return deferred.promise;
			
			
			
		}
		
		
	}
	
}]);