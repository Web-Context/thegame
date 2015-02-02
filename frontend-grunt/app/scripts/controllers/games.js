'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('GamesCtrl', ['$scope','GameService',function ($scope,GameService) {
    GameService.findAll(0,5).then(function(games){
        $scope.articles = games;
    });
  }]);
