'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the webappGruntApp
 */
angular.module('webappGruntApp')
  .controller('LoginCtrl', function ($scope) {
$scope.user = {
        user: 'name',
        password: null
    };

    $scope.open = function () {

        $modal.open({
            templateUrl: 'login.html',
            backdrop: true,
            windowClass: 'modal',
            controller: function ($scope, $modalInstance, $log, user) {
                $scope.user = user;
                $scope.submit = function () {
                    $log.log('Submiting user info.');
                    $log.log(user);
                    $modalInstance.dismiss('cancel');
                }
                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };
            },
            resolve: {
                user: function () {
                    return $scope.user;
                }
            }
        });
    };
  });
