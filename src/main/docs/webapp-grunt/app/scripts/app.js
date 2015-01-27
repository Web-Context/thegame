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
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/users', {
        templateUrl: 'views/user.html',
        controller: 'UserCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
