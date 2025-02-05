# SSOTEST

This project is a SSOTEST Mini solo project

## Prerequisites

Make sure you have the following installed before running the project:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/download.cgi)

## Running the Project

### Step 1: Start Services with Docker

The project uses **PostgresDB** To spin up the required services, run:

```sh
docker-compose up -d
```

This will start the necessary containers in detached mode.
also make sure that the container is running in docker!

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
- **API Endpoints:** [Swagger Link](http://localhost:8080/swagger-ui/index.html)
- Swagger is up!

## Stopping the Application

To stop the services, use:

```sh
docker-compose down
```

## Testing step
### Step one Head to post API
![Capture](https://github.com/user-attachments/assets/af651562-63a3-4132-a869-d1e5a5a920e0)
<br>
Then Press try it out<br>
It will show Request body<br>
### Testing example
```sh
{
  "ssoType": "SSOData",
  "systemId": "VATDEDEV",
  "systemName": "ระบบบันทึกข้อมูลภาษีมูลค่าเพิ่มทดสอบ)",
  "systemTransactions": "PRIV-010,PRIV-020,PRIV-040,PRIV-050",
  "systemPrivileges": "0|0|0|0",
  "systemUserGroup": "GRP-010,GRP-020,GRP-040",
  "systemLocationGroup": "CliC001",
  "userId": "WS233999",
  "userFullName": "ประสาท จันทร์อังคาร ",
  "userRdOfficeCode": "01000999",
  "userOfficeCode": "01001139",
  "clientLocation": "01001139",
  "locationMachineNumber": "CLI00000718-9999",
  "tokenId": "eyJzdWIiOiIxMjM0IiwiYXVkIjpbImFkbWluIl0sImlzcyI6Im1hc29uLm1ldGFtdWcubmV0IiwiZXhwIjoxNTc0NTEyNzY1LCJpYXQiOjE1NjY3MzY3NjUsImp0aSI6ImY3YmZlMzNmLTdiZjctNGViNC04ZTU5LTk5MTc5OWI1ZWI4YSJ9"
}

```
### Expected result
![EQW](https://github.com/user-attachments/assets/e12bc79d-ab97-4bb0-8df2-c80d54386014)

## Troubleshooting
- If you encounter **port conflicts**, modify the `docker-compose.yml` file or change the application’s default ports in `application.properties`.
- If Maven fails to start, ensure you have **Java 17+** installed and properly set up.
---

**Enjoy coding! 🎬🍿** <br>
This readme contributed by 
### Pattaradanai Ysb
### ChatGPT(Emoji and cleanup)
