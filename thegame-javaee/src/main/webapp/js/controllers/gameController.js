'use strict';

angular.module('theGameApp')
	.controller('GameCtrl', ['$scope','$http','$routeParam','Games', function($scope, $http, $routeParams, Games){
    $scope.refresh = function() {
        $scope.games = Games.query();
    };
    $scope.refresh();
}]);
