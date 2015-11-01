'use strict';
app.directive('salary', function() {
	return {
		restrict: 'E',
		templateUrl: 'app/views/salary.html',
		controller: 'salaryController'
	}

});