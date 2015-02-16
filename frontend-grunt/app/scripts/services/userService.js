'use strict';

/**
 * @ngdoc service
 * @name webappGruntApp.UserService
 * @description
 * # UserService
 * Factory in the webappGruntApp.
 */
angular.module('webappGruntApp')
  .factory('UserService', ['$http',function ($http) {
    return {
      findByUsername: function(username,password){
        return $http.get('rest/users/'+username+'.json',{username:username})
          .then(function (response) {
            var user = response.data.user;
            return user;
        });
      },
      findAll: function (offset,pageSize) {
        return $http.get('rest/users.json',{offset:offset, pageSize:pageSize})
          .then(function (response) {
            var users = response.data.users;
            return users;
          });
      }
    };
  }]);
