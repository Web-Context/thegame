# TheGame

_created on January 2015, by [McG](mailto:contact@web-context.com "Send a mail to McG.")._

This a demonstration project to serve a small web application providing Video Games tests and news.

A Short Java web project proposing multiple versoin of the same technical architecture, but build upon toolset or not:

* build as a 2 maven projects (backend and frontend), 
* or as a single project (backend integrate fronend).

## Front end

* The `frontend-grunt` is designed with HTML5/CSS/AngularJS and based on the [Yeoman](http://yeoman.io)+[Grunt](http://gruntjs.com)+[Bower](http://bower.io) toolset.

![The rule of 3](http://yeoman.io/assets/img/workflow.c3cc.jpg =250x "The rule of three")

## Back end

* The `thegame-javaee` is a mix of CDI, JPA and JAX-RS, to server a standard REST backend, build uppon the Kitchensink-angularjs project from the [Wildfly-quickstart](https://github.com/wildfly/quickstart/tree/master/kitchensink-angularjs).

* The `backend-spark` is a low dependency foot print http server edition, to serve aplication as a single jar. It relies on the [SparkJava framework](http://sparkjava.com)



For more information, please visit the [BitBucket home project](http://bitbucket.org/WebContext/thegame).