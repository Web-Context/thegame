'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:UserctrlCtrl
 * @description
 * # UserctrlCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('UserCtrl',['$scope','$http' ,function ($scope,$http) {
    $http.get("rest/users.json").success(function(data,status,headers,config){
    	$scope.users = data.users;
    }).error(function(data,status,headers,config){
    	alert("unable to retrieve data");
    });
  }]);
