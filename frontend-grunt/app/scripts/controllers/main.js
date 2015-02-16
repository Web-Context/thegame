'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappGruntApp
 */
 angular.module('webappGruntApp')
 .controller('MainCtrl', ['$scope','$log','$http','$location','PlatformService','UserService',
 	function ($scope, $log, $http, $location, PlatformService, UserService) {
		PlatformService.findAll().then(function(platforms){
			$scope.platforms = platforms;
		});

		$scope.user={
			profile:'default'
		};

		$scope.application = {
			profile: { mode: 'profile-default'}, 
			menu:[]
		};
		var username='admin', password='password';
		UserService.findByUsername(username, password).then(function(user){
			$scope.user = user;
			if(user.profile === 'admin'){
				$scope.application = {
					profile: { 
						mode: 'profile-'+user.profile
					},
					menu : [
						{ title:'Administration', url:'', role:'presentation', css:'dropdown-header'},
						{ title:'Users', url:'#/admin/users', role:'menuitem', css:''},
						{ title:'Platforms', url:'#/admin/platforms', role:'menuitem',css:''},
						{ title:'Games', url:'#/admin/games', role:'menuitem',css:''},
						{ title:'User', url:'', role:'presentation', css:'dropdown-header'},
						{ title:'Profile', url:'#/admin/profile', role:'menuitem',css:''},
						{ title:'Logout', url:"#/login", role:'menuitem',css:''}
					]};
			}else{
				$scope.application = {
					profile: { 
						mode: 'profile-'+user.profile
					},
					menu : [
						{ title:'User', url:'', role:'presentation', css:'dropdown-header'},
						{ title:'Profile', url:'#/admin/profile', role:'menuitem',css:''},
						{ title:'Logout', "url":"#/logout", role:'menuitem',css:''}
					]};
			}
			$scope.application = {profile: { mode: 'profile-'+user.profile}};
		});

}]);
