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

### Branch prefixes

- **feature/:** Each new feature should reside in its own branch, which can be pushed to the central repository for `backup/collaboration`.

More information: [Gitflow Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow).

---
