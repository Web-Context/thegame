'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('GamesCtrl', ['$scope','$routeParams','GameService',function ($scope,$routeParams,GameService) {
    $scope.games = [];
    
  	if($routeParams.code){
	    GameService.findByPlatform($routeParams.code, 0,5).then(function(games){
	        $scope.games = games;
	    });
	}else{
	    GameService.findAll(0,5).then(function(games){
	        $scope.games = games;
	    });		
	}

	if($scope.games.length==0){
		$scope.appmessage='There is no games for the platform '+code;
	}
  }]);
