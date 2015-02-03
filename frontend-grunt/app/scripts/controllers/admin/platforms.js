'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:AdminPlatformCtrl
 * @description
 * # AdminPlatformCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('AdminPlatformsCtrl', ['$scope','PlatformService',function ($scope,PlatformService) {
    PlatformService.findAll(0,10).then(function(platforms){
        $scope.platforms = platforms;
    });
}]);
