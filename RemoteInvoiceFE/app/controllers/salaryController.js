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
		hours : 'Ilść godzin'
	};

	$scope.docDefinitionPattern = {
		content : [ 'Test Testowicza 00004', {
			columns : [

			],
			// optional space between columns
			columnGap : 10
		} ]
	};

	dbService.getDataForUser().then(function(data) {
		$.each(data, function(i, element) {
			var row = {
				// auto-sized columns have their widths based on their content
				width : 'auto',
				text : element[0].lname
			};
			$scope.docDefinitionPattern.content[1].columns.push(row);
		});
		$scope.docDefinition = $scope.docDefinitionPattern;
	});

	$scope.exportPdf = function() {
		pdfMake.createPdf($scope.docDefinition).open();
	};

});