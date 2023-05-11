<div align="center">
    <a href="https://github.com/softspiders/softspiders">
      <img src="https://avatars.githubusercontent.com/u/47006425?v=4"width="100" height="100" alt="wrong link to logo"/>
    </a>
</div> 

# UNDER DEVELOPMENT

# Dockerized ToDo service starter with Hexagonal architecture on Spring Boot and PostgreSQL with Flyway, Swagger support, with testing support based on ArchUnit, Testcontainers, REST Assured and Selenium, with monitoring based on Actuator and Prometheus

## Feature tags

- actuator
- archunit
- assertj
- dbunit
- docker
- flyway
- grafana
- hexagonal
- maven
- mapstruct
- mockmvc
- monorepo
- postgres
- prometheus
- rest
- rest-assured
- selenium
- spring-boot
- spring-data-jpa
- starter
- swagger
- template
- testcontainers
- todo

---

## Direct ancestor

[- prometheus](https://github.com/softspiders/spring-boot-postgres-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-todo/tree/spring-boot-psql-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-monorepo-docker-actuator-todo#readme)

---

## Author

[Alexander Lapygin](https://github.com/AlexanderLapygin) <<alexanderlapygin@gmail.com>>

---

## Inspiration

- [Valery Sloboda.Hexagonal demo](https://github.com/Antilamer1709/hexagonal-demo)
- [Testcontainers SpringBoot Quickstart](https://github.com/testcontainers/testcontainers-java-spring-boot-quickstart)

## Requirements

- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/get-docker/)

---

## Run tests

```sh
mvnw verify
```

# To run locally
1) Run
   ```sh
   mvn package
   ```
2) Run a Postgres database from the container:
   ```sh
   docker run --name todos_postgres -d -p 5434:5432 -e POSTGRES_USER=sa -e POSTGRES_PASSWORD=password -e POSTGRES_DB=todos postgres
   ```
3) Run the Spring Boot application:
   ```sh
   java -jar application/target/application-1.0.0.jar
   ```
4) Take a look at http://localhost:8080/swagger-ui.html.

# To run in Docker
1) Run
   ```sh
   mvn package
   ```
2) If not already done at the preceding "To run locally": Run a Postgres database from the container:
   ```sh
   docker run --name todos_postgres -d -p 5434:5432 -e POSTGRES_USER=sa -e POSTGRES_PASSWORD=password -e POSTGRES_DB=todos postgres
   ```
3) Build the Docker image:
   ```sh
   docker build --tag=todos .
   ```
4) Run an application from the image:
   ```sh
   docker run -p 8080:8080 todos
   ```
5) Take a look at http://localhost:8080.

# To check the actuator

- Take a look at actuator endpoints at http://localhost:8080/actuator.
- Take a look at actuator metrics: http://localhost:8080/actuator/metrics.

# To check the Grafana
TBD

### License

Licensed under the [MIT license](./LICENSE)

---

[SOFTSPIDERS](https://github.com/softspiders/softspiders)
