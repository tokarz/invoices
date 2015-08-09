'use strict';
app.directive('mmtTable', function($timeout) {
	return {
		restrict : 'AC',
		link : function(scope, element, attribute) {
			$timeout(function() {

				scope.table = $(element).DataTable({
					"ajax" : {
						"url" : "rest/tableData",
						"type" : "GET"
					},
					"columns" : [ {
						"data" : "select",
						render: function ( data, type, row ) {
		                    if ( type === 'display' ) {
		                        return '<input type="checkbox" class="editor-active">';
		                    }
		                    return data;
		                },
		                className: "dt-body-center"
					},
					{
						"data" : "date"
					}, {
						"data" : "fname"
					}, {
						"data" : "lname"
					}, {
						"data" : "salary"
					} ]
				});
				//scope.table.columns.adjust().draw();

			});

		}

	}

});