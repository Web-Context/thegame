'use strict';
angular.module('theGameApp')
	.controller('MenuCtrl',['$scope','Users',function($scope,Users) {
	$scope.menu={
		'items': [ 
            { "name" : "Games", "code" : "home", "title" : "see last games"}, 
            { "name" : "Users", "code" : "users", "title" : "Manage userslast games" } 
        ]
	};
	$scope.user=Users.findById("0");
}]);
