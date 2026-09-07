# 📦 Ride Booking — Shared Entity Library

Shared domain model library used across the Ride Booking Microservices System.

This project contains common JPA entities and base models that are reused by multiple services to maintain consistency and avoid duplicating domain model definitions.

---

## 🎯 Purpose

The Entity Library provides common models such as:

* `BaseModel`
* `Passenger`
* `Driver`
* `Booking`
* Other shared domain models

These classes can be packaged and consumed by individual microservices as a Gradle dependency.

---

## 🛠️ Tech Stack

| Technology                | Purpose                         |
| ------------------------- | ------------------------------- |
| Java                      | Programming language            |
| Spring Boot               | Initial project structure       |
| JPA / Hibernate           | Entity mapping                  |
| Gradle                    | Build and dependency management |
| MySQL-compatible entities | Persistent model definitions    |

---

## 🏗️ Architecture

```text
                    ┌────────────────────────┐
                    │   Entity Library       │
                    │                        │
                    │ BaseModel              │
                    │ Passenger              │
                    │ Driver                 │
                    │ Booking                │
                    │ Other shared models    │
                    └────────────┬───────────┘
                                 │
                            Shared JAR
                                 │
             ┌───────────────────┼───────────────────┐
             │                   │                   │
             ▼                   ▼                   ▼
        Auth Service       Booking Service      Review Service
```

---

## ⚠️ Important: Not a Runtime Microservice

Although this project was created using Spring Boot project structure, it is used as a **shared library**.

It is not deployed as an independent service in the Ride Booking runtime architecture.

The project is packaged and consumed by other services as a JAR dependency.

---

## 📚 Shared Models

### BaseModel

Provides common fields shared by entities, such as:

* ID
* Created timestamp
* Updated timestamp

---

### Passenger

Represents passenger-related domain information.

Used by services that require passenger information.

---

### Driver

Represents driver-related domain information.

Used by services that require driver information.

---

### Booking

Represents the common booking domain model used across relevant services.

---

## 🔗 Dependency Model

```text
Entity Library
      │
      │ Gradle dependency
      ▼
Consumer Service
      │
      ▼
Shared Entity Classes
```

This avoids maintaining separate copies of the same domain model across multiple repositories.

---

## 🧠 Why Use a Shared Library?

Without a shared library:

```text
Auth Service
 └── Passenger.java

Booking Service
 └── Passenger.java

Review Service
 └── Passenger.java
```

This can result in duplicated models and inconsistent changes.

With the shared library:

```text
Entity Library
 └── Passenger.java
       │
       ├── Auth Service
       ├── Booking Service
       └── Review Service
```

---

## ⚠️ Architectural Consideration

A shared entity library creates compile-time coupling between services.

Therefore, only genuinely shared domain models should be placed here.

Service-specific DTOs and business logic should remain inside their respective services.

---

## 🔮 Future Improvements

* Separate common DTO library if required
* Version the library independently
* Publish the library to a Maven repository
* Reduce shared models where service ownership becomes clearer
* Introduce backward-compatible library versioning

---

## 🔗 Related Services

* [Auth Service](https://github.com/adarsh25tiwari/Ride-Booking-AuthService)
* [Booking Service](https://github.com/adarsh25tiwari/Ride-Booking-BookingService)
* [Location Service](https://github.com/adarsh25tiwari/Ride-Booking-LocationService)
* [Socket Service](https://github.com/adarsh25tiwari/Ride-Booking-SocketService)
* [Review Service](https://github.com/adarsh25tiwari/Ride-Booking-ReviewService)
