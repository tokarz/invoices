'use strict';
app.directive('mmtDataTable', function() {
	return {
		restrict: 'A',
		link: function(scope, element, attribute) {
			 $(document).ready(function() {
				 scope.table = $('table', element).DataTable();
				 scope.table.columns.adjust().draw();
			} );
			
		}
		
	}
	
});