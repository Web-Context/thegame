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
    // Service logic
    // ...

    // Public API here
    return {
      findByUsername: function(username,password){
        return $http.get('rest/users.json',{username:username})
          .then(function (response) {
            var users = response.data.users;
            var retUser = null;
            users.forEach(function(user){
              if(user.username == username &&
                 user.password == password){
                 retUser = user;
              }
            },retUser);
          return retUser;
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
