'use strict';
app.controller('loginController', ['$rootScope', '$scope', 'dbService', 'loginService', function($rootScope, $scope, dbService, loginService){
	$scope.databaseVersion = '';
	
	dbService.getDatabaseVersion().then(function(data) {
		$scope.databaseVersion = data;	
		$scope.loginText = 'Witaj w FoxWeb v0.1';
	});
	
	$scope.loginStatus = '';
	$scope.username = 'Nazwa Użytkownika';
	$scope.password = 'Hasło';
	$scope.logIn = 'Zaloguj';
	
	$scope.inputUsername = '';
	$scope.inputPassword = '';
	
	$scope.logInWithCredentials = function() {
		$scope.loginStatus = 'pobieranie danych....';
		loginService.authenticate($scope.inputUsername, $scope.inputPassword).then(function(isAuthenticated) {
			$scope.loginStatus = 'ukończono!';
			if(isAuthenticated == true) {
				$scope.loginError = false;
				$rootScope.inputUsername = $scope.inputUsername;
				$scope.$emit('loginSuccessfull');
			} else {
				$scope.loginError = true;
			}
		});
		
	}
	$scope.loginError = false;
	
}]);