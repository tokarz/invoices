'use strict';
app
		.directive(
				'salaryTable',
				function($timeout, $rootScope) {
					return {
						restrict : 'AC',
						link : function(scope, element, attribute) {
							$timeout(function() {

								scope.table = $(element)
										.DataTable(
												{
													"ajax" : {
														"url" : "rest/tableData/tableContents",
														"type" : "GET",
														"data" : {
															"sessionId" : "toBedefined",
															"username" : $rootScope.inputUsername
														}
													},
													"columns" : [
															{
																"data" : "select",
																render : function(
																		data,
																		type,
																		row) {
																	if (type === 'display') {
																		return '<input type="checkbox" class="editor-active">';
																	}
																	return data;
																},
																className : "dt-body-center"
															},
															{
																"data" : "date"
															},
															{
																"data" : "netto"
															},
															{
																"data" : "brutto"
															},
															{
																"data" : "hours"
															}]
												});
								// scope.table.columns.adjust().draw();

							});

						}

					}

				});