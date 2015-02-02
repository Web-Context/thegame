// feaures/steps/login-base.js
var Login = function(){
	this.world = require("../support/world.js").World;
	
	this.Given(/^I am on the login page$/, function(callback) {
	  // express the regexp above with the code you wish you had
	  callback.pending();
	});

		this.When(/^I login$/, function(callback) {
	  // express the regexp above with the code you wish you had
	  callback.pending();
	});

		this.Then(/^I should be logged in$/, function(callback) {
	  // express the regexp above with the code you wish you had
	  callback.pending();
	});
};