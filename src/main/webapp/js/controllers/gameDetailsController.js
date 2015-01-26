'use strict';

angular.module('theGameApp')
	.controller('GameDetailsCtrl',['$scope','$http','$routeParams','Games',function($scope, $http, $routeParams, Games) {
    $scope.game = Games.get({gameId:$routeParams.gameId});
}]);
