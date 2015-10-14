'use strict';
app.controller('SalaryController', function($scope, dbService) {
	$scope.docDefinitionPattern = {
	  content: [
	    'Test Testowicza 00004',
	    {
	      columns: [
	       
	      ],
	      // optional space between columns
	      columnGap: 10
	    },
	    'This paragraph goes below all columns and has full width'
	  ]
	};
	
	dbService.getDataForUser().then(function(data) {
		$.each(data, function(i, element) {
			var row = {
			          // auto-sized columns have their widths based on their content
			          width: 'auto',
			          text: element[0].lname
			        };
			$scope.docDefinitionPattern.content[1].columns.push(row);
		});
		$scope.docDefinition = $scope.docDefinitionPattern;
	});
	
	$scope.exportPdf = function() {
		pdfMake.createPdf($scope.docDefinition).open();
	};

});