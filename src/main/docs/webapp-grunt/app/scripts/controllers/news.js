'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('NewsCtrl', ['$scope','$http',function ($scope,$http) {
    $http.get("rest/games.json").success(function(data,status,headers,config){
    	$scope.articles = data.games;
    	$scope.articles.forEach(function(item){
    		item.plus      = item.plus.split(",");
    		item.minus     = item.minus.split(",");
    		item.platforms = item.platforms.split(",");
    		item.createdAt = new Date(item.createdAt);
			item.publishedAt = new Date(item.publishedAt);
    	});
    }).error(function(data,status,headers,config){
    	alert("unable to retrieve data");
    });
  }]);
