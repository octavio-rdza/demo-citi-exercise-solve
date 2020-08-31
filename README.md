# demo-citi-exercise-solve
Demo project to test Citi exercise solve.

In the branch demo-spring-project there is a demo project with the tests and some services to validate the correct functionality of the RequestHeadersUtility.java

In this branch, there is only the class with the solution. To compile is need to follow these steps

1. Setup the Java environment variable correctly.
2. Put on the directory where the file is

`cd [<directory>]`

3. Compile the class with `javac` but it needs to have `javax.servlet-api-<version>.jar` dependency or otherwise `tomcat-embed-core-<version>.jar` and specify the classpath because it needs the package javax.servlet to compile.

`javac [-cp <directory-where-be-dependency> RequestHeadersUtility.java]`