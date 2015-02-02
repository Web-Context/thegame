'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:FooterCtrl
 * @description
 * # FooterCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('FooterCtrl', ['$scope','GameService',function ($scope,GameService) {
    $scope.gamesByPlatforms = GameService.findGroupByPlatform(5);
  }]);
