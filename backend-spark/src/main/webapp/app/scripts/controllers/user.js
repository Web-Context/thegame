'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:UserctrlCtrl
 * @description
 * # UserctrlCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
	.controller('UserCtrl',['$scope','UserService' ,function ($scope,UserService) {

		UserService.findAll(0,10).then(function(users){
			$scope.users = users;
		});
	}]);
