# 🎯 Quiz Microservices - Spring Boot Project 🚀  

Welcome to the **Quiz Microservices System**! This project is built using **Spring Boot** and follows a **Microservices Architecture** with **Eureka Service Discovery, Feign Client for communication, and API Gateway for routing.**  

---

## 📌 **Project Overview**  
This system consists of multiple microservices working together:  
1. **📝 Question Service** - Manages quiz questions.  
2. **📊 Quiz Service** - Handles quiz creation and scoring.  
3. **🔎 Eureka Server** - Service registry and discovery.  
4. **📡 API Gateway** - Centralized routing for microservices.  

---

## 🛠 **Tech Stack**  
- 🌱 **Spring Boot** - Backend Framework  
- 🎭 **Spring Cloud** - Microservices  
- 🏗 **Spring Data JPA** - Database Interaction  
- 🛜 **Feign Client** - Service-to-Service Communication  
- 🔍 **Eureka Server** - Service Discovery  
- 🔀 **API Gateway** - Routing & Load Balancing  
- 🛢 **MySQL** - Database  
- 🐳 **Docker** (Optional) - Containerization  

---

## ⚙️ **Microservices Structure**  

### 1️⃣ **Question Service** (`QuestionService`)  
- 📂 **Path**: `kunal.example.QuestionService.Controller.QuestionsController`
- 📌 **Endpoints:**  
  - `GET /question/allquestions` → Fetch all questions  
  - `GET /question/allquestions/{category}` → Get questions by category  
  - `POST /question/addQuestion` → Add a new question  
  - `DELETE /question/delete/{id}` → Delete a question  
  - `POST /question/getScore` → Calculate quiz score  

---

### 2️⃣ **Quiz Service** (`QuizService`)  
- 📂 **Path**: `com.kunal.QuizService.Controller.QuizController`
- 📌 **Endpoints:**  
  - `POST /quiz/create` → Create a new quiz  
  - `GET /quiz/get/{id}` → Get quiz details  
  - `POST /quiz/submit/{id}` → Submit quiz & get results  

---

### 3️⃣ **Eureka Server**  
- Acts as a **Service Registry** where microservices register and discover each other.  
- 📌 **Run Eureka Server Before Starting Other Services!**  

**🛠 Setup:**  
- Navigate to `EurekaServer` directory  
- Run:  
  ```sh
  mvn spring-boot:run
