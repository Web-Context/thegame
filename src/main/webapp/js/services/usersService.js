// Define the REST resource service, allowing us to interact with it as a high level service
angular.module('usersService', ['ngResource']).
    factory('Users', function($resource){
  return $resource('rest/users:memberId', {});
});