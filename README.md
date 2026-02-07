# 💰 Budget Analyzer

![Java](https://img.shields.io/badge/Java-21-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green?logo=spring&logoColor=white)
![Database](https://img.shields.io/badge/Database-MySQL-blue)
![Tests](https://img.shields.io/badge/Tests-Present-lightgrey)
![Status](https://img.shields.io/badge/Status-Stable-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

**Budget Analyzer** is a backend REST API built using **Spring Boot** to manage, analyze, and summarize personal expenses.  
The application follows **clean layered architecture**, supports filtering and aggregation, and includes **unit, repository, integration, and exception tests** using an isolated H2 test database.  

This project demonstrates backend fundamentals, Spring Boot best practices, and production-style testing.

---

## ✨ Key Features

- Expense CRUD operations
- Category & sub-category filtering
- Expense type support (EXPENSE / INCOME)
- Payment method tracking
- Monthly expense summaries
-CSV expense DTO support with extensible import design
- Budget alert response models (extensible for alert logic)
- Centralized exception handling
- Fully tested with H2 in-memory database
- Swagger API documentation

The project is **backend-focused**, emphasizing layered architecture, testing, and maintainable code.

---

## 📁 Project Structure

```text
budget-analyzer/
├── src/
│   ├── main/
│   │   ├── java/com/budget/analyzer/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   │   └── impl/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   ├── dto/
│   │   │   └── exception/
│   │   └── resources/
│   │       └── application.yaml
│   └── test/
│       ├── java/com/budget/analyzer/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── integration/
│       │   └── exception/
│       └── resources/
│           └── application-test.yml
├── .gitignore
├── pom.xml
├── LICENSE
└── README.md


```

## 📊 ER Diagram (Database Schema)
---
ER Diagram

The database schema is designed to support expense tracking, categorization, and analysis.

Core entities:

-Expense

-Category

-SubCategory (if applicable)

-PaymentMethod


```text

+-------------------+
|      Expense      |
+-------------------+
| id (PK)           |
| title             |
| amount            |
| expenseType       |  (EXPENSE / INCOME)
| paymentMethod     |
| date              |
| category_id (FK)  |
+-------------------+
          |
          | Many-to-One
          |
+-------------------+
|     Category      |
+-------------------+
| id (PK)           |
| name              |
+-------------------+

```



🛠 Technology Stack
---
### Backend
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-000000?style=for-the-badge&logo=oracle&logoColor=white)

### Database
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![H2](https://img.shields.io/badge/H2-0F4C81?style=for-the-badge&logoColor=white)

### Build & Tools
![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![JUnit 5](https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-00C853?style=for-the-badge&logo=mockito&logoColor=white)


🧠 Application Architecture
---
The system follows a layered architecture:

1️⃣ Controller Layer
-Exposes REST APIs using Spring MVC

-Accepts requests via DTOs

-Delegates business logic to the service layer

-Returns structured API responses

2️⃣ Service Layer
-Contains all business logic

-Validates and processes data

-Converts entities ↔ DTOs

-Interacts with repositories

3️⃣ Repository Layer
-Uses Spring Data JPA

-Handles database operations

-Abstracts SQL using Hibernate

4️⃣ Database Layer
-MySQL for development

-H2 in-memory database for testing

-Schema managed via JPA/Hibernate

5️⃣ Exception Handling
-Centralized using @ControllerAdvice

-Consistent API error responses

-Proper HTTP status codes

6️⃣ Testing Strategy
-Repository tests → verify database behavior

-Service tests → verify business logic

-Controller tests → verify REST APIs

-Integration tests → verify full request flow

-Exception tests → verify global error handling

▶️ How to Run
---
🧱 Prerequisites
Make sure you have the following installed:

1.Java 17 or higher

2.Maven

3.MySQL (or any JDBC-compatible database)

1️⃣ Clone the Repository
        
        git clone https://github.com/pranshu-2203/budget-analyzer-backend.git
        cd budget-analyzer
2️⃣ Configure Database
Update src/main/resources/application.yaml:

        spring:
          datasource:
            url: jdbc:mysql://localhost:3306/budget_analyzer
            username: YOUR_USERNAME
            password: YOUR_PASSWORD


Create the database:

        CREATE DATABASE budget_analyzer;

3️⃣ Run the Application
        
        mvn spring-boot:run
Application runs at:
        
        http://localhost:8080


📄 API Documentation (Swagger)
---
Once running, access:
        
        http://localhost:8080/swagger-ui.html

You can:

-View all available endpoints

-Test APIs directly from the browser

-Inspect request and response schemas


🔗 Sample API Requests & Responses
---

➕ Create Expense

Request
  
    POST /api/expenses
    Content-Type: application/json

-json
    
    {
    "title": "Grocery Shopping",
    "amount": 1500,
    "expenseType": "EXPENSE",
    "category": "Food",
    "paymentMethod": "UPI",
    "date": "2024-02-01"
    }

--Response-201 Created
    
    {
      "id": 12,
      "title": "Grocery Shopping",
      "amount": 1500,
      "expenseType": "EXPENSE",
      "category": "Food",
      "paymentMethod": "UPI",
      "date": "2024-02-01"
    }

📄 Get All Expenses

-Request

    GET /api/expenses


--Response – 200 OK

    [
      {
        "id": 12,
        "title": "Grocery Shopping",
        "amount": 1500,
        "expenseType": "EXPENSE",
        "category": "Food",
        "paymentMethod": "UPI",
        "date": "2024-02-01"
      },
      {
        "id": 13,
        "title": "Salary",
        "amount": 45000,
        "expenseType": "INCOME",
        "category": "Salary",
        "paymentMethod": "BANK_TRANSFER",
        "date": "2024-02-01"
      }
    ]

📊 Monthly Expense Summary

-Request

    GET /api/expenses/summary?month=2&year=2024


--Response – 200 OK

    {
      "month": "FEBRUARY",
      "year": 2024,
      "totalExpense": 18500,
      "totalIncome": 45000,
      "balance": 26500
    }

❌ Error Response Example

-Request

    GET /api/expenses/999


--Response – 404 NOT FOUND

    {
      "timestamp": "2024-02-03T12:45:30",
      "status": 404,
      "error": "Expense not found",
      "path": "/api/expenses/999"
    }





🧪 Running Tests
---
        mvn clean test

Test Configuration

-Uses H2 in-memory database (isolated from MySQL)

-Activated via application-test.yml

-Isolated from MySQL

-Fast and repeatable

Test coverage:
---
-Controller tests

-Service tests

-Repository tests

-Integration tests

-Global exception tests

❗ Global Exception Handling
---
-Centralized using GlobalExceptionHandler

-Handles:

-Resource not found

-Validation errors

-Runtime exceptions

-Returns consistent API error responses

📌 Project Status
---
✔ Stable

✔ Fully tested

✔ Interview-ready

✔ Production-style structure
