'use strict';

describe('Service: Platforms', function () {

  // load the service's module
  beforeEach(module('webappGruntApp'));

  // instantiate service
  var Platforms;
  beforeEach(inject(function (_Platforms_) {
    Platforms = _Platforms_;
  }));

  it('should do something', function () {
    expect(!!Platforms).toBe(true);
  });

});
