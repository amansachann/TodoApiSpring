
# 📝 Todo API - Spring Boot

A simple RESTful API for managing Todo tasks built with **Spring Boot**. This project demonstrates basic CRUD operations using a clean architecture and industry-standard practices.

## 🚀 Features

- 📄 Create a new Todo item  
- 📋 Retrieve all Todos or a specific Todo by ID  
- ✏️ Update an existing Todo  
- ❌ Delete a Todo  
- 📦 Built using Spring Boot (Java 17+ compatible)

## 🛠️ Tech Stack

| Technology         | Description               |
|--------------------|---------------------------|
| Spring Boot 🧰     | Backend framework          |
| Spring Web 🌐      | REST API development       |
| Spring Data JPA 🗂️ | ORM and persistence        |
| H2 Database 🛢️     | In-memory development DB   |
| Maven/Gradle ⚙️    | Build tool                 |

## 📁 Project Structure
```groovy
src
└── main
├── java
│   └── com.example.todoapi
│       ├── controller      # REST controllers
│       ├── model           # Entity classes
│       ├── repository      # Spring Data JPA repositories
│       └── service         # Business logic
└── resources
└── application.properties
```
## 📦 API Endpoints
```
| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| GET    | `/api/todos`       | Get all Todos            |
| GET    | `/api/todos/{id}`  | Get Todo by ID           |
| POST   | `/api/todos`       | Create a new Todo        |
| PUT    | `/api/todos/{id}`  | Update Todo by ID        |
| DELETE | `/api/todos/{id}`  | Delete Todo by ID        |
```
### 📄 Sample Todo JSON

```json
{
  "title": "Finish Spring Boot project",
  "description": "Complete the Todo API and write documentation",
  "completed": false
}
````

## 🧪 How to Run

### 🖥️ Prerequisites

* Java 17+
* Maven or Gradle

### 💻 Run with Maven

```bash
./mvnw spring-boot:run
```

### ⚙️ Run with Gradle

```bash
./gradlew bootRun
```

### 🌐 Access the API

```
http://localhost:8080/api/todos
```

## 🧪 Testing the API

You can test the endpoints using tools like:

* Postman
* curl
* Swagger UI (if integrated)

## 📌 Notes

* Uses **H2 in-memory database** (data resets on restart)
* Can be configured to use MySQL/PostgreSQL in `application.properties`

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


