'use strict';

/**
 * @ngdoc overview
 * @name webappGruntApp
 * @description
 * # webappGruntApp
 *
 * Main module of the application.
 */
angular
  .module('webappGruntApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/news', {
        templateUrl: 'views/games.html',
        controller: 'GamesCtrl'
      })
      .when('/stories', {
        templateUrl: 'views/stories.html',
        controller: 'GamesCtrl'
      })
      .when('/tests', {
        templateUrl: 'views/tests.html',
        controller: 'GamesCtrl'
      })
      .when('/news/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/games/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/admin/users', {
        templateUrl: 'views/admin/user.html',
        controller: 'UserCtrl'
      })
      .when('/admin/profile', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/profile/save', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .otherwise({
        redirectTo: '/news'
      });
  });
