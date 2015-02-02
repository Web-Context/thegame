'use strict';

/* Define any routes for the app
 * Note that this app is a single page app, and each partial is routed to using the URL fragment. 
 * For example, to select the 'home' route, the URL is http://localhost:8080/wildfly-thegame-angularjs/#/home
 */
var app = angular.module('theGameApp', [ 'usersService', 'gamesService' ]);
app.config([ '$routeProvider', '$locationProvider',
		function($routeProvider, $locationProvider) {
			$routeProvider.when('/users', {
				templateUrl : 'partials/users.html',
				controller : UsersCtrl
			// Add a default route
			}).when('/games', {
				templateUrl : 'partials/games.html',
				controller : GameCtrl
			}).when('/game/view/:gameId', {
				templateUrl : 'partials/game.html',
				controller : GameDetailCtrl
			}).otherwise({
				redirectTo : '/games'
			});
			//$locationProvider.html5Mode(true).hashPrefix('!');
		} ]);
