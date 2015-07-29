'use strict';
app.controller('loginController', ['$scope', function($scope){
	
	
	$scope.username = 'Nazwa Uzytkownika';
	$scope.password = 'Haslo';
	$scope.logIn = 'Zaloguj';
	$scope.loginText = 'Witaj w FoxWeb v0.1';
	
	$scope.inputUsername = '';
	$scope.inputPassword = '';
	
	$scope.logInWithCredentials = function() {
		if($scope.inputUsername == 'mmt' && $scope.inputPassword == 'paszcz') {
			$scope.loginError = false;
			$scope.$emit('loginSuccessfull');
		} else {
			$scope.loginError = true;
		}
		
	}
	$scope.loginError = false;
	
}]);