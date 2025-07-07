# RentACar Backend API

This is a **Java Spring Boot backend project** developed as part of my learning journey into the Spring ecosystem. The project simulates the backend logic of a simple Rent-A-Car system, with structured API endpoints and layered architecture.

> 🎓 I developed this project by following [Engin Demiroğ's](https://www.youtube.com/@engindemirog) YouTube Spring Boot course.  
> 📘 It was my first experience with Spring Boot, and I learned a lot about backend development, architecture, and best practices.

---

## 📌 Project Purpose

The main goal of this project is to practice backend development using **Spring Boot**, understand how to build RESTful APIs, and implement clean architecture principles.  
This is a **backend-only** project — no frontend or UI is included. The application is fully API-driven.

---

## ⚙️ Technologies & Tools

- **Java 17**  
- **Spring Boot**  
- **Spring Web**  
- **Spring Data JPA**  
- **Hibernate**  
- **Lombok**  
- **ModelMapper**  
- **Swagger (OpenAPI)**  
- **Maven**  
- **H2 / PostgreSQL**

---

## 📦 Project Structure

![Project Structure](https://github.com/serdararici/rent-a-car/blob/main/images/Project_Architecture.JPG)

---

## 🧠 What I Learned

Through building this project, I learned and practiced:

- ✅ Spring Boot fundamentals and project setup  
- ✅ Creating layered architecture with separation of concerns  
- ✅ Dependency injection using Spring  
- ✅ Working with JPA, Hibernate, and relational databases  
- ✅ Building RESTful APIs with CRUD operations  
- ✅ DTO creation and mapping using ModelMapper  
- ✅ Using `@Valid` for request validation  
- ✅ Global exception handling and custom exceptions  
- ✅ Implementing business rules and validation logic  
- ✅ API documentation with Swagger  
- ✅ Organizing clean and scalable backend code  

---

## ✅ Implemented Features

### 🏷️ Brand API

- `GET /api/brands` – List all brands  
- `GET /api/brands/{id}` – Get brand by ID  
- `POST /api/brands/add` – Add a new brand (with validation)  
- `PUT /api/brands` – Update a brand  
- `DELETE /api/brands/{id}` – Delete a brand  

Includes DTO mapping, validation, and custom business rules (e.g., unique brand name check).

---

### 📦 Model API

- `GET /api/models` – List all models  
- `POST /api/models/add` – Add a new model  

Includes one-to-many relationship with `Brand`.

---

### 🚗 Car Entity

- Created `Car` entity with many-to-one relation to `Model`  
- Not yet exposed via API (can be extended easily)

---

## ❗ Exception Handling

- Custom business rule handling via `BusinessException`  
- Field validation with `@Valid` and global handling via `ValidationProblemDetails`  
- Clean, structured error responses using `ProblemDetails`  
- System internals are not exposed in error responses  

---

## 📸 Swagger UI Preview

Here's a preview of the automatically generated Swagger UI documenting all API endpoints:

![Swagger UI Screenshot](https://github.com/serdararici/rent-a-car/blob/main/images/Swagger_ui.JPG)

---

## 🛠️ How to Run

1. Clone the repository  
2. Open in your preferred IDE (e.g., IntelliJ, Eclipse)  
3. Run `RentACarApplication.java`  
4. Access Swagger UI or test APIs with Postman  

---

## 🔄 Future Improvements

- 🔐 Add authentication and authorization (e.g., Spring Security + JWT)  
- 🚗 Create APIs for `Car` entity  
- 🔍 Implement pagination and filtering  
- 🧾 Use PostgreSQL in production  

---

## 🙌 Acknowledgments

Thanks to **Engin Demiroğ** for his detailed and practical Spring Boot course that guided me through every step of this project.

---
