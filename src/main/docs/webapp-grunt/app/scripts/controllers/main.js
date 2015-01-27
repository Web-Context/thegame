'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
