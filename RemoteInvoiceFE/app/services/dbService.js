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

				getDataForUser : function(date) {
					var deferred = $q.defer();

					$http.get('rest/tableData/pdfContents', {
						params : {
							sessionId : "toBedefined",
							username : $rootScope.inputUsername,
							date: date
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