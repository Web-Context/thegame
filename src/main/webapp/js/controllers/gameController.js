function GameCtrl($scope, $http, $routeParams, Games) {
    $scope.refresh = function() {
        $scope.games = Games.query();
    };
    $scope.refresh();
}

function GameDetailCtrl($scope, $http, $routeParams, Games) {
    $scope.game = Games.get({gameId:$routeParams.gameId});
}
