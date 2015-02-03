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
        controller: 'TestsCtrl'
      })
      .when('/news/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/games/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/games/edit/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/games/delete/:id', {
        templateUrl: 'views/gameDetails.html',
        controller: 'GameDetailsCtrl'
      })
      .when('/platforms', {
        templateUrl: 'views/platforms.html',
        controller: 'PlatformsCtrl'
      })
      .when('/platforms/:id', {
        templateUrl: 'views/platformDetails.html',
        controller: 'PlatformDetailsCtrl'
      })
      .when('/admin/users', {
        templateUrl: 'views/admin/users.html',
        controller: 'AdminUsersCtrl'
      })
      .when('/admin/user/edit', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/user/delete', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/profile', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/profile', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/profile/save', {
        templateUrl: 'views/admin/profile.html',
        controller: 'ProfileCtrl'
      })
      .when('/admin/games', {
        templateUrl: 'views/admin/games.html',
        controller: 'AdminGamesCtrl'
      })
      .when('/admin/platforms', {
        templateUrl: 'views/admin/platforms.html',
        controller: 'AdminPlatformsCtrl'
      })
      .otherwise({
        redirectTo: '/news'
      });
  });
