'use strict';

describe('Controller: NewsreadCtrl', function () {

  // load the controller's module
  beforeEach(module('webappGruntApp'));

  var NewsreadCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    NewsreadCtrl = $controller('NewsreadCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
