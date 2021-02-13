# api-employee

Basic api REST to manage employees

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### Recommended facilities

To test api easily, you should install the next applications

- [Postman](https://www.postman.com/)

---

## Configurations

### Execution port

The port where the application runs is 8080, you can change the port in the `application.yml` file.

### Database

The applications database is postgresql, TO RUN THE PROJECT you must to replace the next variables with your own values in `application.yml` file:

- username
- password

---

## Instalation

To install the project, you should follow the next steps:

  ```shell
  git clone https://github.com/Alula96/api-employee.git
  cd api-employee
  mvm install
  ```

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.test.apiemployee.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

---

## Repository branches

`Gitflow` was used as a tool to manage repository structure as follow:

### Develop and Master Branches

- **master:** Stores the official release history.
- **develop:** Serves as an integration branch for features.

---
