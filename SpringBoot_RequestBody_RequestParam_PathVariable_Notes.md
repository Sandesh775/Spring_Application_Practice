# 🚀 Spring Boot Notes - Path Variables, Request Parameters & Request Body

## Goal

Understand:

* Path Variables
* Request Parameters
* Request Body
* JSON
* How Spring creates Java Objects from JSON
* Why only one Request Body is allowed

---

# 1. Path Variables

Used when data is part of the URL path.

Example URL:

```text
localhost:8080/student/Ram/21
```

Controller:

```java
@GetMapping("/student/{name}/{age}")
public String student(
        @PathVariable String name,
        @PathVariable int age){

    return name + " is " + age + " years old";
}
```

Spring extracts:

```text
{name} = Ram
{age} = 21
```

and calls:

```java
student("Ram", 21);
```

---

## Mental Model

```text
URL
 ↓
@PathVariable
 ↓
Method Parameter
```

---

# 2. Request Parameters

Used when data comes after `?`

Example:

```text
localhost:8080/student?name=Ram&age=21
```

Controller:

```java
@GetMapping("/student")
public String studentInfo(
        @RequestParam String name,
        @RequestParam int age){

    return "Student name : " + name;
}
```

Spring extracts:

```text
name = Ram
age = 21
```

---

## Missing Request Parameter

Example:

```text
/student?name=Ram
```

but controller expects:

```java
@RequestParam int age
```

Result:

```text
400 Bad Request
```

Reason:

```text
Spring considers RequestParams required by default.
```

---

## Optional Request Parameter

```java
@RequestParam(required = false)
Integer age
```

Now age may be missing.

---

## Mental Model

```text
URL Query String
 ↓
@RequestParam
 ↓
Method Parameter
```

---

# Path Variable vs Request Parameter

Path Variable:

```text
/user/John
/book/100
/student/Ram
```

Used for:

```text
Identifying a specific resource
```

---

Request Parameter:

```text
/search?keyword=spring
/users?page=2
/products?category=laptop
```

Used for:

```text
Filtering
Searching
Sorting
Paging
```

---

# 3. Request Body

Data is sent inside HTTP Request Body.

Example JSON:

```json
{
  "name": "Ram",
  "age": 21
}
```

Controller:

```java
@PostMapping("/student")
public String student(
        @RequestBody Student obj){

    return obj.getName();
}
```

---

# Student Class

```java
public class Student {

    private String name;
    private int age;

    // getters
    // setters
}
```

---

# What Spring Does

Incoming JSON:

```json
{
  "name": "Ram",
  "age": 21
}
```

Spring automatically creates:

```java
Student student = new Student();

student.setName("Ram");
student.setAge(21);
```

Then:

```java
student(student);
```

gets called.

---

## The Big Realization

Before learning Spring:

```java
Scanner
 ↓
Manual Object Creation
 ↓
Setters
```

Example:

```java
Student student = new Student();
student.setName(name);
student.setAge(age);
```

---

Now:

```text
User
 ↓
Form
 ↓
JSON
 ↓
HTTP Request
 ↓
Spring Boot
 ↓
Student Object
```

The object becomes alive because real data traveled through the system.

---

# Why RequestBody Felt Like Magic

Code:

```java
@PostMapping("/student")
public String student(
        @RequestBody Student student)
```

Notice:

```java
new Student()
```

was never written.

Yet:

```java
Student student
```

appeared automatically.

Spring created and populated it.

---

# Invalid JSON Mapping

Sent:

```json
{
  "name": 21,
  "age": "Ram"
}
```

Result:

```text
400 Bad Request
```

Reason:

```text
name expects String
age expects int
```

Types do not match.

Spring cannot convert them.

---

# Extra JSON Properties

Student class:

```java
private String name;
private int age;
```

Sent:

```json
{
  "name":"Ram",
  "age":21,
  "college":"ABC College"
}
```

Unexpected Discovery:

```text
Request succeeded.
```

Reason:

```text
Spring/Jackson ignored the unknown field.
```

Only matching properties were mapped.

---

# One Request = One Body

This DOES NOT work:

```java
@PostMapping("/enroll")
public String enroll(
        @RequestBody Student student,
        @RequestBody Course course)
```

Reason:

```text
HTTP Request
 ↓
One Request
 ↓
One Body
```

Spring cannot split a single body into two separate root objects.

---

# Solution: Wrapper Object

```java
public class Enrollment {

    private Student student;
    private Course course;

    // getters
    // setters
}
```

JSON:

```json
{
  "student": {
    "name": "Ram",
    "age": 21
  },
  "course": {
    "title": "Spring Boot",
    "duration": 30
  }
}
```

Controller:

```java
@PostMapping("/enroll")
public String enroll(
        @RequestBody Enrollment enrollment)
```

---

# JSON Mirrors Object-Oriented Design

Java:

```text
Enrollment
├── Student
└── Course
```

JSON:

```json
{
  "student": { ... },
  "course": { ... }
}
```

Observation:

```text
JSON structures often mirror Java object structures.
```

---

# Mental Model Summary

@GetMapping

```text
Read Data
```

@PostMapping

```text
Create Data
```

@PathVariable

```text
Data from URL path
```

@RequestParam

```text
Data from query string
```

@RequestBody

```text
Data from JSON body
```

Spring Boot

```text
JSON
 ↓
Java Object
 ↓
Controller Method
```

---

# Most Important Insight From Today

When learning OOP:

```java
Student student = new Student();
```

felt artificial.

Today:

```text
User
 ↓
Form
 ↓
JSON
 ↓
Spring
 ↓
Student Object
```

showed how objects represent real-world information moving through a real application.

The Student object finally became alive.
🚀
