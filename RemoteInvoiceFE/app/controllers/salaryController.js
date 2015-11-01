'use strict';
app.controller('salaryController', function($scope, dbService) {
	$scope.salaryHeader = 'Zestawienie wypłat';
	$scope.menu = {
		overview : 'Wypłaty',
		freeDays : 'Dni wolne',
		documents : 'Szablony dokumentów',
		calendar : 'Kalendarz'
	};

	$scope.headers = {
		select : 'Zaznacz',
		date : 'Data',
		netto : 'Netto',
		brutto : 'Brutto',
		hours : 'Ilość godzin',
		pdf: 'Raport pdf'
	};

	$scope.topmenu = {
		desktop : 'Pulpit',
		userProfile : 'Profil Użytkownika',
		help : 'Pomoc',
		logout : 'Wyloguj'
	}

	$scope.docDefinitionPattern = {
		content : [ 'Test Testowicza 00004', {
			columns : [

			],
			// optional space between columns
			columnGap : 10
		} ]
	};

	

});