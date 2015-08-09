'use strict';
app.factory('dbService', ['$q', '$http', function($q, $http) {
	return {
		
		getDatabaseVersion: function() {
			var deferred = $q.defer();
			
			$http.get('rest/dbVersion').success(function(data){
				
				deferred.resolve(data);
			}).error(function(err) {
				deferred.reject(err)
			});
			
			return deferred.promise;
			
			
		}
		
		
	}
	
}]);