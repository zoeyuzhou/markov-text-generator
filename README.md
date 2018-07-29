# markov-text-generator
## Overview
This repository is to implement of Markov chain text generator.
A Markov chain algorithm basically determines the next most probable suffix word for a given prefix.
Three input should be provided:
* Source text file
* Prefix word 
* The number of words to generate from

## Installation instructions
### Requirements
* Java 8
* Maven
### Running The Application
The application will start at `http://localhost:8080` by default.
#### Running as a Packaged Application
Build executable jar file using maven 
```
mvn clean install
```
markovtext-0.0.1-SNAPSHOT.jar could be found under target/ directory.
```
java -jar target/markovtext-0.0.1-SNAPSHOT.jar
```
#### Using the Maven Plugin
```
mvn spring-boot:run
```

### Run tests

```
mvn test
```
## System Design
### Technical 
* **Java 8**
* **Spring Boot** - Easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* **Spring Web** - Full-Stack web deployment with tomcat and Spring MVC
* **Thymeleaf** - A modern server-side template engine

