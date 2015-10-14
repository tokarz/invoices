'use strict';
app.factory('dbService', [ '$rootScope', '$q', '$http',
		function($rootScope, $q, $http) {
			return {

				getDatabaseVersion : function() {
					var deferred = $q.defer();

					$http.get('rest/dbVersion').success(function(data) {

						deferred.resolve(data);
					}).error(function(err) {
						deferred.reject(err)
					});

					return deferred.promise;

				},

				getDataForUser : function() {
					var deferred = $q.defer();

					$http.get('rest/tableData', {
						params : {
							sessionId : "toBedefined",
							username : $rootScope.inputUsername
						}
					}).success(function(data) {
						deferred.resolve(data);
					}).error(function(err) {
						deferred.reject(err)
					});

					return deferred.promise;

				}

			}

		} ]);