'use strict';

describe('Service: Menuservice', function () {

  // load the service's module
  beforeEach(module('webappGruntApp'));

  // instantiate service
  var Menuservice;
  beforeEach(inject(function (_Menuservice_) {
    Menuservice = _Menuservice_;
  }));

  it('should do something', function () {
    expect(!!Menuservice).toBe(true);
  });

});
