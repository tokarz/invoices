'use strict';

app.controller('mainController', ['$scope', 'testService', function($scope, testService) {
	$scope.isLoggedIn = false;
	
	$scope.$on('loginSuccessfull', function() {
		$scope.isLoggedIn = true;
	});
	
	testService.pokeServer().then(function(data) {
		$scope.connectionStatus = data;
		
	});
	
}]);