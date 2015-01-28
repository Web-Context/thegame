'use strict';

/**
 * @ngdoc function
 * @name webappGruntApp.controller:NewsreadCtrl
 * @description
 * # NewsreadCtrl
 * Controller of the webappGruntApp
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
  .controller('NewsReadCtrl', ['$scope','$http','$routeParams',function ($scope,$http,$routeParams) {
    $http.get("rest/games.json").success(function(data,status,headers,config){
    	var id=$routeParams.id-1;
    	var game = data.games[id];
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

		$scope.game = game;

    }).error(function(data,status,headers,config){
    	alert("unable to retrieve data");
    });

  }]);
