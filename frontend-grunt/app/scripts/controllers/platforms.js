'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:PlatformsCtrl
 * @description
 * # PlatformsCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('PlatformsCtrl', ['$scope','PlatformService',function ($scope,PlatformService) {
    PlatformService.findLast(0,10).then(function(platforms){
        $scope.platfoms = platforms;
    });

}]);
