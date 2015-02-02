'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('MainCtrl', ['$scope','$http',function ($scope,$http) {
  	$http.get("rest/users.json").success(function(data,status,headers,config){
 		$scope.user = data.users[1];
 	}).error(function(data,status,headers,config){
 		alert("unable to retrieve user details");
 	});
  }]);
