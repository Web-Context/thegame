'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
