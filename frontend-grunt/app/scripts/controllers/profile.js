'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:ProfileCtrl
 * @description
 * # ProfileCtrl
 * Controller of the webappGruntApp
 */
 angular.module('webappGruntApp')
 .controller('ProfileCtrl',['$scope','$routeParams','$http', 
 	function ($scope,$routeParams,$http) {
	 	$http.get('rest/users.json').success(function(data){
	 		$scope.profile = data.users[1];
	 	}).error(function(){
	 		alert('unable to retrieve user details');
	 	});
 }]);
