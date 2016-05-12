## Trove Level Three Front End Developer's Test

Requires [Apache Maven](http://maven.apache.org) 3.1 or greater, and JDK 7+ in order to run.

To build, run

    mvn clean install

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver

For further information, consult the [Java App Engine](https://cloud.google.com/appengine/docs/java/) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine