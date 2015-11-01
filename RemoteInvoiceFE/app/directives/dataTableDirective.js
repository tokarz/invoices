'use strict';
app
		.directive(
				'salaryTable',
				function($timeout, $rootScope, $compile) {
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
													"columns" : [ {
														"data" : "date"
													}, {
														"data" : "netto"
													}, {
														"data" : "brutto"
													}, {
														"data" : "hours"
													}, {
														"data" : "pdf"
													} ],
													"columnDefs" : [ {
														"targets" : 4,
														"createdCell" : function(
																td, cellData,
																rowData, row,
																col) {
															var selectedData = rowData.date;
															var htmlToCompile = "<span class='pdfPrint' ng-click='generatePdfForRow(" +selectedData + ")' title='wygeneruj raport'></span>";
															console.log(htmlToCompile);
															var compiledHtml = $compile(htmlToCompile)(scope);
															$(td).html(compiledHtml);
														}
													} ]
												});

							});

						},
						controller: function($scope, dbService) {
							$scope.generatePdfForRow = function(arg) {
								dbService.getDataForUser(arg).then(function(data) {
									pdfMake.createPdf(data).open();
								});
							}
							
						}
					}

				});