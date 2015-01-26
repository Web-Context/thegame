'use strict';
angular.module('theGameApp')
	.controller('UsersCtrl',['$scope','$http','Users',function($scope, $http, Users) {

    // Define a refresh function, that updates the data from the REST service
    $scope.refresh = function() {
        $scope.users = Users.query();
    };

    // Define a reset function, that clears the prototype newUser object, and
    // consequently, the form
    $scope.reset = function() {
        // clear input fields
        $scope.newUser = {};
    };

    // Define a register function, which adds the User using the REST service,
    // and displays any error messages
    $scope.register = function() {
        $scope.successMessages = '';
        $scope.errorMessages = '';
        $scope.errors = {};

        Users.save($scope.newUser, function(data) {

            // mark success on the registration form
            $scope.successMessages = [ 'User Registered' ];

            // Update the list of users
            $scope.refresh();

            // Clear the form
            $scope.reset();
        }, function(result) {
            if ((result.status == 409) || (result.status == 400)) {
                $scope.errors = result.data;
            } else {
                $scope.errorMessages = [ 'Unknown server error' ];
            }
            $scope.$apply();
        });

    };

    // Call the refresh() function, to populate the list of users
    $scope.refresh();

    // Initialize newUser here to prevent Angular from sending a request
    // without a proper Content-Type.
    $scope.reset();

    // Set the default orderBy to the name property
    $scope.orderBy = 'name';
}]);