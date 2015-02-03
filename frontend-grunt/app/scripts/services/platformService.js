'use strict';


/**
 * Extract a game from the list.
 * @param platforms  list of platforms
 * @param id unique identifier for the requested game.
 */
function extractPlatform(platforms, id){
  var platform = platforms[id-1];
  return platform;
}

/**
 * @ngdoc service
 * @name webappGruntApp.Platforms
 * @description
 * # Platforms
 * Service in the webappGruntApp.
 */
angular.module('webappGruntApp')
  .service('PlatformService', ['$http', function ($http) {

    return {
      findById : function(id) {
        return $http.get('rest/platforms.json',{gameId:id})
          .then(function (response) {
            return extractPlatform(response.data.platforms,id);
          });
      },
      findLast : function(size){
        return $http.get('rest/platforms.json',{pageSize:size})
          .then(function (response) {
            var platforms = response.data.platforms.slice(0,size);
            return platforms;
          });
      },
      findAll : function(offset,size){
        return $http.get('rest/platforms.json',{offset:offset, pageSize:size})
          .then(function (response) {
            var platforms = response.data.platforms;
            return platforms;
          });
      },
      findGroupByPlatform : function(size){
        return $http.get('rest/platforms_by_platform.json',{pageSize:size})
          .then(function(response){
            var platforms=response.data.platforms;
			return platforms;
          });
        }
      }
  }]);
