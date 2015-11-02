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
													"language": {
														"sProcessing":    "Wyszukiwanie...",
												        "lengthMenu": "Widoczne _MENU_ elementów na stronę",
												        "zeroRecords": "Brak danych do wyświetlenia",
												        "sEmptyTable":    "Brak elementów do wyświetlenia",
												        "info": "Strona _PAGE_ z _PAGES_",
												        "infoEmpty": "Brak danych do wyświetlenia",
												        "infoFiltered": "(odfiltrowano z _MAX_ elementów)",
												        "sSearch":        "Wyszukaj",
												        "sUrl":           "",
												        "sInfoThousands":  ",",
												        "sLoadingRecords": "Ładowanie...",
												        "oPaginate": {
												            "sFirst":    "Pierwsza",
												            "sLast":    "Ostatnia",
												            "sNext":    "Następna",
												            "sPrevious": "Poprzednia"
												        },
												        "oAria": {
												            "sSortAscending":  ": Posortuj rosnąco",
												            "sSortDescending": ": Posortuj malejąco"
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
													}  ],
													"columnDefs" : [ {
														"targets" : 4,
														"searchable": false,
														'defaultContent': '',
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
													}, ]
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