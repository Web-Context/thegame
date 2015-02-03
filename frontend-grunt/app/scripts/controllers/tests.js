'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('TestsCtrl', ['$scope','GameService',function ($scope,GameService) {
    GameService.findLast(3).then(function(games){
        $scope.games = games;
    });
  }]);
