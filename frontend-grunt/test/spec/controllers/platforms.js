'use strict';

describe('Controller: PlatformsCtrl', function () {

  // load the controller's module
  beforeEach(module('webappGruntApp'));

  var PlatformsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PlatformsCtrl = $controller('PlatformsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
