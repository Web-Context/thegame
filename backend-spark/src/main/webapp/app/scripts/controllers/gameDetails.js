'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:NewsreadCtrl
 * @description
 * # NewsreadCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('GameDetailsCtrl', ['$scope','$routeParams','GameService',function ($scope,$routeParams,GameService) {
    GameService.findById($routeParams.id).then(function(game){
    	$scope.game = game;
    });
  }]);
