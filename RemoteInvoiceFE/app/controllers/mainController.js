'use strict';

app.controller('mainController', ['$scope', function($scope) {
	$scope.isLoggedIn = false;
	
	$scope.$on('loginSuccessfull', function() {
		$scope.isLoggedIn = true;
	});
	
}]);