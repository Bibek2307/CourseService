# 🎓 Spring Boot Microservices - Academy Platform

This repository contains a microservice-based architecture built using **Spring Boot**, **Spring Cloud**, **Eureka Server**, and **OpenFeign**.  
It demonstrates how to develop, register, and communicate between microservices in a service discovery environment.

---

## 📦 Microservices Overview

### 1. 🧑‍🏫 `InstructorService`
- Manages instructor-related data.
- Exposes REST endpoints to provide instructor info by ID.
- Uses PostgreSQL and Spring Data JPA.

### 2. 📘 `CourseService`
- Handles course-related operations.
- Each course is linked to an instructor via `instructorId`.
- Uses PostgreSQL and Spring Data JPA.

### 3. 🏛️ `AcademyService` (Aggregator)
- Aggregates data from both `CourseService` and `InstructorService`.
- Uses **Feign Client** to fetch data from other services.
- Returns a combined response: course + instructor info.

### 4. 📡 `EurekaServer`
- Service registry for all microservices.
- All services register themselves here for dynamic discovery.
- Required to run before the other services.

---

## ⚙️ Dependencies Used (Shared by Most Services)

```xml
<!-- Core Dependencies -->
<dependency>spring-boot-starter-web</dependency>
<dependency>spring-boot-starter-data-jpa</dependency>
<dependency>spring-boot-starter-actuator</dependency>

<!-- Eureka Client -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
  <version>4.3.0</version>
</dependency>

<!-- OpenFeign (only in AcademyService) -->
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<!-- Database -->
<dependency>postgresql</dependency>

<!-- Dev & Test -->
<dependency>spring-boot-devtools</dependency>
<dependency>lombok</dependency>
<dependency>spring-boot-starter-test</dependency>

```
## Eureka Server Configuration
🔹 application.properties for Eureka Server:
properties

spring.application.name=EurekaDemo
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

🔹 Dependencies (Eureka Server pom.xml):
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>

## Microservices application.properties Example
All services should use different ports:
```xml
spring.application.name=AcademyService
server.port=9000

spring.datasource.url=jdbc:postgresql://localhost:5432/academy
spring.datasource.username=postgres
spring.datasource.password=23fortnite
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgresPlusDialect

eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
eureka.instance.prefer-ip-address=true
```
Update the above config in each service's properties file, changing only the name & port (e.g., CourseService, InstructorService).

## How To Run
1. Start the Eureka Server
2. Start the respective microservices
3. Start PostMan to communicate with the respective endpoints 

## ✅ Notes
Each service registers itself to Eureka at startup.
You can always change the server.port and endpoints in application properties and controller class
You can view Eureka dashboard at:
👉 http://localhost:8761

Test aggregated output via AcademyService API:
http://localhost:9000/academy/course-details/1
