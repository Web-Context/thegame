function HomeCtrl($scope, $http, Games) {
    $scope.refresh = function() {
        $scope.games = Games.query();
    };
   
    $scope.refresh();

}