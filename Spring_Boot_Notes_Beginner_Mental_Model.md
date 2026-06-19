# 🚀 Spring Boot Notes (Beginner Mental Model)

## Goal

This document is not meant to teach every Spring Boot feature.

Its purpose is to answer:

- What files exist?
- What does each folder represent?
- Where should I write code?
- Why do tutorials use Controller, Service, Repository, Entity?
- What happens when the application runs?

---

# Spring Boot Project Structure

```text
project/

├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/demo
│   │   │       ├── DemoApplication.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       └── entity/
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
│
├── mvnw
└── mvnw.cmd
```

---

# pom.xml

Think of `pom.xml` as:

**Project Configuration File**

It contains:

- Dependencies
- Java version
- Build configuration
- Project metadata

Example:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Meaning:

> I want web functionality.

Maven reads this file and downloads required libraries.

---

# DemoApplication.java

Usually:

```java
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            DemoApplication.class,
            args
        );
    }
}
```

Think:

**Application Entry Point**

Just like a normal Java program starts from:

```java
public static void main(String[] args)
```

Spring Boot starts here.

---

# application.properties

Located inside:

```text
src/main/resources
```

Purpose:

**Application Settings**

Examples:

```properties
server.port=8081
spring.datasource.url=...
```

Instead of hardcoding settings in Java code, they are placed here.

---

# Why Do We Create Packages?

As applications grow, keeping all classes in one folder becomes difficult.

Packages help organize code by responsibility.

Example:

```text
controller/
service/
repository/
entity/
```

This is not a Spring Boot rule.

It is an organization convention.

---

# Controller

Think:

**Controller = Reception Desk**

Responsibility:

- Receives HTTP requests
- Receives GET requests
- Receives POST requests
- Returns HTTP responses

Example:

```java
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
```

When someone visits:

```text
localhost:8080/hello
```

Spring calls:

```java
hello()
```

and returns:

```text
Hello
```

Controller answers:

> What is being requested?

---

# Service

Think:

**Service = Brain / Business Logic**

Responsibilities:

- Validations
- Calculations
- Rules
- Decision making

Example:

```java
public String createUser(String name) {

    if(name.isBlank()) {
        throw new RuntimeException();
    }

    return name;
}
```

Service answers:

> What should happen?

---

# Repository

Think:

**Repository = Database Communicator**

Responsibilities:

- Save data
- Read data
- Query data
- Delete data

Examples:

```java
repository.save(user);
repository.findAll();
```

Repository answers:

> How do I talk to the database?

---

# Entity

Think:

**Entity = Data Model**

Example:

```java
@Entity
public class Student {

    private Long id;

    private String name;
}
```

Usually represents:

```text
Java Object
        ↓
Database Table
```

Entity answers:

> What data exists?

---

# Typical Flow

```text
Browser
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Response comes back:

```text
Database
    ↓
Repository
    ↓
Service
    ↓
Controller
    ↓
Browser
```

---

# First Spring Boot Flow To Remember

```text
pom.xml
    ↓
Dependencies

DemoApplication
    ↓
Starts Application

Controller
    ↓
Handles Requests

@GetMapping
    ↓
Maps URL

Method
    ↓
Executes Logic

Return Value
    ↓
Response Sent To Browser
```

---

# What Happens When You Run?

You click Run on:

```text
DemoApplication.java
```

Spring Boot:

```text
Starts JVM
↓
Starts Spring
↓
Starts Embedded Tomcat
↓
Scans Controllers
↓
Maps URLs
↓
Waits For Requests
```

# Request Flow

When browser visits:

```text
localhost:8080/hello
```

Flow:

```text
Browser
    ↓
Tomcat
    ↓
Spring
    ↓
HelloController
    ↓
hello()
    ↓
"Hello World"
    ↓
Browser
```
