// Define the REST resource service, allowing us to interact with it as a high level service
angular.module('gamesService', ['ngResource']).
    factory('Games', function($resource){
  return $resource('rest/games:gameId', {});
});