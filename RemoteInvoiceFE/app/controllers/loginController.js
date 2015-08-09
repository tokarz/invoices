'use strict';
app.controller('loginController', ['$scope', 'dbService', 'loginService', function($scope, dbService, loginService){
	$scope.databaseVersion = '';
	
	dbService.getDatabaseVersion().then(function(data) {
		$scope.databaseVersion = data;	
		$scope.loginText = 'Witaj w FoxWeb v0.1';
	});
	
	$scope.username = 'Nazwa Uzytkownika';
	$scope.password = 'Haslo';
	$scope.logIn = 'Zaloguj';
	
	$scope.inputUsername = '';
	$scope.inputPassword = '';
	
	$scope.logInWithCredentials = function() {
		loginService.authenticate($scope.inputUsername, $scope.inputPassword).then(function(isAuthenticated) {
			if(isAuthenticated == true) {
				$scope.loginError = false;
				$scope.$emit('loginSuccessfull');
			} else {
				$scope.loginError = true;
			}
		});
		
	}
	$scope.loginError = false;
	
}]);