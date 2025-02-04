# SAND Netflix Clone - Backend

This project is a backend service for a Netflix-like web application, built using **Spring Boot**, **Spring Data JPA**, **Feign Client**, and **Eureka** for microservices communication.

## Prerequisites

Make sure you have the following installed before running the project:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi)

## Running the Project

### Step 1: Start Services with Docker

The project uses **MariaDB** and **Eureka** as dependencies. To spin up the required services, run:

```sh
docker-compose up -d
```

This will start the necessary containers in detached mode.

### Step 2: Run the Backend Server

Once the database and other services are up, start the Spring Boot application using Maven:

```sh
mvn spring-boot:run
```

Alternatively, if you prefer running the built JAR file:

```sh
mvn clean package
java -jar target/sand-backend.jar
```

### Step 3: Verify the Application

Once the server is running, you can verify the endpoints:
- **API Endpoints:** [http://localhost:8080/api/](http://localhost:8080/swagger-ui)
- STILL BROKEN (SWAGGER)

## Stopping the Application

To stop the services, use:

```sh
docker-compose down
```

## Troubleshooting
- If you encounter **port conflicts**, modify the `docker-compose.yml` file or change the application’s default ports in `application.properties`.
- If Maven fails to start, ensure you have **Java 17+** installed and properly set up.
---

**Enjoy coding! 🎬🍿**
This readme contributed by
Pattaradanai Ysb
and ChatGPT(Emoji and cleanup)
