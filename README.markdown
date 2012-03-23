Stocks example application for combining Scala, Scaladin, Vaadin and Canvas

### Development tools used for this project

Install the following:
* Latest Eclipse for Java EE			http://eclipse.org/
* Latest Scala IDE plugin for Eclipse		http://www.scala-ide.org/
* Latest Vaadin plugin for Eclipse		Install in Help->Eclipse Marketplace...


### How to import this project

Import this project to Eclipse with "Import project"

Download the following libraries and copy them to WebContent/WEB-INF/lib directory:
* vaadin-6.7.6.jar
* scaladin_2.9.1-1.0.0.jar
* scala-library.jar
* canvaswidget-1.1.jar
* gwt-incubator-20100204-r1747.jar
(or any newer version available)

Please choose to compile Vaadin widgetset when asked. When asked, you should choose to create the widgetset to com.example.stocks package. Widgetset compilation takes couple of minutes. This is a one time operation to integrate above libraries to your project. 


### How to run this project

* Choose Run on server for the project
* You can use any Servlet container. For example "J2EE Preview" works just fine.


### Speeding up development cycle

If you get bored for restarting the server to redeploy, you could install JRebel to automatically replace classes in a running server without restarts:
* Install JRebel from Eclipse Marketplace (Help -> Ecliplse Marketplace...)
* Get a free trial license from http://zeroturnaround.com. If you have Vaadin Pro Account subscription, a download full license from https://vaadin.com/jrebel
* From your server settings in Eclipse (double click "J2EE Preview" in Server panel) check "Enable JRebel Agent"
* From the project, choose JRebel -> Generate jrebel.xml in src
* Restart the server

Note that there are limitations to what JRebel can do with anonymous classes in Scala. Sometimes you just have to restart even with JRebel enabled.
