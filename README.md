# REST API with Spring boot

This project is an exercise completed as part of the Backend course at IT Academy. It implements a simple CRUD application built using Spring Boot, which handles HTTP requests for a Fruit entity and stores data in an H2 in-memory database.

## Objective

The goal of this project is to become familiar with the following concepts:

- HTTP verbs (GET, POST, PUT, DELETE)

- HTTP headers

- HTTP status codes

- CRUD operations with Spring Boot

- Using an H2 in-memory database for persistence


---

## Technologies Used

- Java 21

- Spring boot

- Gradle

- IntelliJ IDEA

- Postman (for API testing)


---

## Project structure

```
S04T02N01/
├── model/
│   ├── entities/
│   └── exceptions/
├── repository/
├── service/
└── controller/
```


---

## Exercise instructions

An entity called Fruit has the following attributes:

- int id - Unique identifier (auto-generated)
- String name
- Int kilosAmount

This entity is persisted in the H2 database using Spring Data JPA.


### The API supports the following endpoints for CRUD operations:

- ```POST``` - http://localhost:8080/fruit/add

- ```PUT``` - http://localhost:8080/fruit/update/{id}

- ```DELETE``` - http://localhost:8080/fruit/delete/{id}

- ```GET``` - http://localhost:8080/fruit/get/{id}

- ```GET``` - http://localhost:8080/fruit/getAll
  <br>

---


## How to Run the Project

> ⚠️ **Important:**
>
> Ensure that you have Java 21 installed before running the application


1 - Clone the repository or download the zip file

2 - Open the project in your preferred IDE (e.g., IntelliJ IDEA)

3 - Run the application

You can test the API using Postman or another HTTP client.