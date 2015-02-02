'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AdminGamesCtrl
 * @description
 * # AdminGamesCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('AdminGamesCtrl', ['$scope','GameService',function ($scope,GameService) {
    
    GameService.findLast(0,10).then(function(games){
        $scope.games = games;
    });

  }]);
