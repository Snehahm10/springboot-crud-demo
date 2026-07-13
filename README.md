# Spring Boot CRUD Application

A RESTful CRUD (Create, Read, Update, Delete) application built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project demonstrates backend development best practices, including **Soft Delete** functionality for safer data management.

## 🚀 Features

- Create a new student
- Retrieve all active students
- Retrieve a student by ID
- Update student details
- Soft Delete (records are marked as deleted instead of being permanently removed)
- RESTful APIs
- MySQL database integration
- Layered Architecture (Controller, Service, Repository, Entity)

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## 📁 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
└── CrudSpringbootDemoApplication.java
```

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /students | Get all active students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Create a new student |
| PUT | /students/{id} | Update student details |
| DELETE | /students/{id} | Soft delete a student |

## ⚙️ Getting Started

### Prerequisites

- Java 21 or later
- Maven
- MySQL
- IntelliJ IDEA (or any Java IDE)

### Clone the Repository

```bash
git clone https://github.com/Snehahm10/springboot-crud-demo.git
```

### Configure Database

Update the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

## 📚 What I Learned

- Building RESTful APIs using Spring Boot
- Spring Data JPA and Hibernate
- Database integration with MySQL
- Implementing Soft Delete
- Layered Architecture
- Maven project management
- Clean backend development practices

## 🔮 Future Improvements

- Spring Security with JWT Authentication
- Swagger/OpenAPI Documentation
- DTO Pattern
- Validation
- Pagination & Sorting
- Docker Support
- Unit Testing

## 👩‍💻 Author

**Sneha H M**

- GitHub: https://github.com/Snehahm10
- LinkedIn: https://www.linkedin.com/in/sneha-hanjgimath-0188a0257

---

⭐ If you found this project helpful, consider giving it a star!
