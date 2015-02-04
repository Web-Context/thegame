'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('MainCtrl', ['$scope','$http','PlatformService',function ($scope,$http,PlatformService) {
  	$http.get("rest/users.json").success(function(data,status,headers,config){
 		$scope.user = data.users[1];
 		PlatformService.findAll().then(function(platforms){
			$scope.platforms = platforms;
		});
		$scope.page = {mode: $scope.user.profile};
 	}).error(function(data,status,headers,config){
 		alert("unable to retrieve user details");
 	});
  }]);
