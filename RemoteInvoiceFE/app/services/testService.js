app.factory('testService', [ '$q', '$http', function($q, $http) {
	return {

		pokeServer : function() {
			var deferred = $q.defer();
			
			$http.get('rest/invoice')
			.success(function(data) {
				deferred.resolve(data.status);
				
				
			}).error(function(ex) {
				alert('Serwis danych niedostepny!');
				
				
			});

			return deferred.promise;

		}

	}

} ]);