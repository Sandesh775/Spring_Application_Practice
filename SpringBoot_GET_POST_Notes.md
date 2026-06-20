# 🚀 Spring Boot Learning Notes - Controllers, Endpoints, GET & POST

## What I Learned

### Controllers

A Controller is responsible for handling HTTP requests.

```java
@RestController
public class HelloController {
}
```

Think of it as:

```text
Browser/Postman
        ↓
    Controller
        ↓
    Response
```

---

## Endpoints

Endpoints are URLs exposed by a controller.

Example:

```java
@GetMapping("/hello")
```

Endpoint:

```text
http://localhost:8080/hello
```

---

## GET Request

Handled using:

```java
@GetMapping(...)
```

Used primarily to:

```text
Read data
Fetch information
Return responses
```

Example:

```java
@GetMapping("/motivation")
public String getMotivation() {
    return "Read Motivation";
}
```

### Browser Testing

Browsers naturally send GET requests when visiting a URL.

Example:

```text
localhost:8080/motivation
```

### Demo

![GET Request Demo](image(5).png)

---

## POST Request

Handled using:

```java
@PostMapping(...)
```

Usually used to:

```text
Create data
Submit data
Trigger actions
Modify application state
```

Example:

```java
@PostMapping("/motivation")
public String postMotivation() {
    return "Create Motivation : Keep Learning Spring Boot";
}
```

---

## Important Discovery

Visiting:

```text
localhost:8080/motivation
```

from a browser sends:

```text
GET /motivation
```

NOT:

```text
POST /motivation
```

Therefore:

```java
@PostMapping("/motivation")
```

cannot be tested directly from the browser address bar.

---

## Why We Used Postman

Postman allows us to send:

```text
GET
POST
PUT
DELETE
PATCH
```

requests manually.

This makes it possible to test endpoints that browsers cannot easily trigger.

### Demo

![POST Request Demo](image(6).png)

---

## Same URL, Different HTTP Methods

Both can exist simultaneously:

```java
@GetMapping("/motivation")
public String readMotivation() {
    return "Read Motivation";
}
```

```java
@PostMapping("/motivation")
public String createMotivation() {
    return "Create Motivation : Keep Learning Spring Boot";
}
```

Spring decides which method to run based on the HTTP method.

---

## Request Flow

### GET Request Flow

```text
Browser
    ↓
Tomcat
    ↓
Spring Boot
    ↓
Controller
    ↓
@GetMapping Method
    ↓
Response
    ↓
Browser
```

---

### POST Request Flow

```text
Postman
    ↓
Tomcat
    ↓
Spring Boot
    ↓
Controller
    ↓
@PostMapping Method
    ↓
Response
    ↓
Postman
```

---

## Key Takeaways

- Controllers handle HTTP requests.
- Endpoints are URLs exposed by controllers.
- `@GetMapping` handles GET requests.
- `@PostMapping` handles POST requests.
- Browsers naturally send GET requests.
- Postman can send POST requests.
- The same URL can support different HTTP methods.
- Spring chooses the correct method based on the incoming HTTP request.