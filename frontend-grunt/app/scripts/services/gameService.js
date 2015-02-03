'use strict';

/**
 * extends String javascript object with a new repeat function.
 */
String.prototype.repeat= function(n){
    n = n || 1;
    return Array(n+1).join(this);
}

/**
 * Transform a value (max 20) in a string of characters
 * @param value to transform
 * @return a string of "+" and "-".
 */
function convert(value){
  value = Math.round(value /4)-1;
  return "+".repeat(value)+"-".repeat(5-(value));
}

/**
 * Transform rate into a label.
 */
function evaluateRate(rate){
  var ratelabel="";
    if(rate<5){
      ratelabel = 'VERY BAD';
    }else if(rate<10){
      ratelabel = 'BAD';
    }else if(rate<13){
      ratelabel = 'MEDIUM';
    }else if(rate<18){
      ratelabel = 'GOOD';
    }else{
      ratelabel = 'VERY GOOD';
    }
  return ratelabel;
}

/**
 * Populate specific attributes of games.
 * @param games  
 *        list of games
 * @param id 
 *        unique identifier for the requested game.
 */
function transformGame(games){
  games.forEach(function(item){
    item = decorateGame(item);
  });
  return games;
}

/**
 * Extract a game from the list.
 * @param games  list of games
 * @param id unique identifier for the requested game.
 */
function extractGame(games, id){
  var game = games[id-1];

  return decorateGame(game);
}

function decorateGame(game){
  game.minus         = game.minus.split(",");
  game.plus          = game.plus.split(",");
  game.platforms     = game.platforms.split(",");
  game.createdAt     = new Date(game.createdAt);
  game.publishedAt   = new Date(game.publishedAt);
  game.rates         = angular.fromJson(game.rates);
  game.rates.gfx     = convert(game.rates.gfx);
  game.rates.sound   = convert(game.rates.sound);
  game.rates.music   = convert(game.rates.music);
  game.rates.feeling = convert(game.rates.feeling);
  game.ratelabel     = evaluateRate(game.rate);
  return game;
}

/**
 * @ngdoc service
 * @name webappGruntApp.News
 * @description
 * # News
 * Factory in the webappGruntApp.
 */
angular.module('webappGruntApp')
  .factory('GameService', ['$http', function ($http) {

    return {
      findById : function(id) {
        return $http.get('rest/games.json',{gameId:id})
          .then(function (response) {
            return extractGame(response.data.games,id);
          });
      },
      findLast : function(size){
        return $http.get('rest/games.json',{pageSize:size})
          .then(function (response) {
            var games = response.data.games.slice(0,size);
            
            return transformGame(games);
          });
      },
      findAll : function(offset,size){
        return $http.get('rest/games.json',{offset:offset, pageSize:size})
          .then(function (response) {
            //var games = response.data.games;
            return transformGame(response.data.games);
          });
      },
      findGroupByPlatform : function(size){
        return $http.get('rest/games_by_platform.json',{pageSize:size})
          .then(function(response){
            var games=response.data.platforms;
          });
          return games;
        }
      }
  }]);
