# Liferay Portlet Spring MVC App

A little project to play around with [Liferay Portal](https://www.liferay.com/), [Spring Framework](https://spring.io/), and [MySQL](https://www.mysql.com/).

Using:
* Java 8
* Maven 3
* Spring Framework 4.3.5
  * Spring Core
  * Spring Transactions
  * Spring Data JPA
  * Spring Portlet MVC
* Liferay 6.2
* Portlet 2.0
* MySQL 5
* JPA 2.1 + Hibernate (as JPA provider)
* JSP + JSTL + Spring Form taglib
* Mixed XML Schema-based and annotation based Spring configuration

![Screenshot](http://i.imgur.com/Vp2YVEM.png)

Usage
-----
```bash
$ git clone https://github.com/naXa777/liferay-portlet-spring-mvc-app.git
$ cd liferay-portlet-spring-mvc-app
$ mvn package
```

First-time configuration
-----
* Define Liferay properties in pom.xml
* Create portal database:
```mysql
CREATE DATABASE lportal
    CHARACTER SET utf8
    COLLATE utf8_general_ci;
```
* Add database portal properties (portal-ext.properties file in $LIFERAY_HOME directory) with your MySQL credentials:

```ini
# MySQL
jdbc.default.driverClassName=com.mysql.jdbc.Driver
jdbc.default.url=jdbc:mysql://localhost/lportal?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
jdbc.default.username=
jdbc.default.password=
```
* Check connection:  
  After Liferay Portal relaunch with the above settings you should have 180 new tables in `lportal` database.

Deploy
------
If you're using Liferay Portal with Tomcat, copy the war to the deploy directory and wait for Liferay to deploy it. After successful deploy you should be able to find the portlet under Sample category.

```
$ cp target/portlet-demo-1.0.war $LIFERAY_HOME/deploy/
```
or 
```
$ mvn liferay:deploy
```

IntelliJ IDEA setup
------
* Import project into IntelliJ IDEA
* Install [Lombok plugin](https://plugins.jetbrains.com/idea/plugin/6317-lombok-plugin) and restart
* For project deployment:
  * [Create Maven Run configuration](https://www.jetbrains.com/help/idea/2016.3/creating-and-editing-run-debug-configurations.html) with `package liferay:deploy` specified in command line.
* For running Liferay from IntelliJ
  * Create [Run configuration for Liferay's Tomcat](https://web.liferay.com/community/wiki/-/wiki/Main/Running+Liferay+from+IntelliJ/maximized#section-Running+Liferay+from+IntelliJ-Liferay+on+Tomcat).
* For debugging your application
  * Create [Remote Run configuration](https://www.jetbrains.com/help/idea/2016.3/run-debug-configuration-remote.html) for remote debug. See [this article](http://blog.trifork.com/2014/07/14/how-to-remotely-debug-application-running-on-tomcat-from-within-intellij-idea/) for details.

Licence
-------

Copyright 2017 Pavel Homal

Licenced under the WTFPL Licence: http://www.wtfpl.net/
