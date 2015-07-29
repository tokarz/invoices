'use strict';
var app = angular.module('InvoiceFE', ['ngRoute']);

app.config(['$routeProvider',
                  function($routeProvider) {
                    $routeProvider.
                      when('/salary', {
                        templateUrl: 'app/views/salary.html',
                        controller: 'SalaryController'
                      }).
                      otherwise({
                        redirectTo: '/salary'
                      });
                  }]);