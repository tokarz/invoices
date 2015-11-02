'use strict';
app.controller('topPanelController', ['$scope', function($scope) {
	$scope.logOut = function() {
		$scope.$broadcast('logOut');
	}
	
	
}]);