'use strict';
app.directive('loginScreen', function() {
	return {
		restrict: 'E',
		templateUrl: 'app/views/login.html',
		controller: 'loginController',
		link: function(scope, element, attribute) {
			$("button", element).button({label: scope.logIn});
			
		}
	}
	
});