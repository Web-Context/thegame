'use strict';

/**
 * @ngdoc service
 * @name webappGruntApp.News
 * @description
 * # News
 * Factory in the webappGruntApp.
 */
String.prototype.repeat= function(n){
    n= n || 1;
    return Array(n+1).join(this);
}

function convert(value){
  value = Math.round(value /4)-1;
  return "+".repeat(value)+"-".repeat(5-(value));
}

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
angular.module('webappGruntApp')
  .factory('GameService', ['$http', function ($http) {

    return {
      findById : function(id) {
        return $http.get('rest/games.json',{gameId:id})
          .then(function (response) {

            var games = response.data.games
            var game = games[id-1];
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
          });
      },
      findLast : function(size){
        return $http.get('rest/games.json',{pageSize:size})
          .then(function (response) {
            var games = response.data.games;
            games.forEach(function(item){
                item.plus      = item.plus.split(",");
                item.minus     = item.minus.split(",");
                item.platforms = item.platforms.split(",");
                item.createdAt = new Date(item.createdAt);
                item.publishedAt = new Date(item.publishedAt);
            });
            return games;
          });
      },
      findAll : function(offset,pageSize){
        return $http.get('rest/games.json',{offset:offset, pageSize:size})
          .then(function (response) {
            var games = response.data.games;
            games.forEach(function(item){
                item.plus      = item.plus.split(",");
                item.minus     = item.minus.split(",");
                item.platforms = item.platforms.split(",");
                item.createdAt = new Date(item.createdAt);
                item.publishedAt = new Date(item.publishedAt);
            });
            return games;
          });
        }
      }
  }]);
