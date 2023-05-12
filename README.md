<div align="center">
    <a href="https://github.com/softspiders/softspiders">
      <img src="https://avatars.githubusercontent.com/u/47006425?v=4"width="100" height="100"/>
    </a>
</div> 

# Spring Boot with Spring Data JPA, PostgresSQL, Flyway, Testcontainers ToDo service starter


## Feature tags

- flyway
- postgres
- spring-boot
- spring-data-jpa
- starter
- swagger
- template
- testcontainers
- todo

---

## Direct ancestor

[- swagger](https://github.com/softspiders/spring-boot-postgres-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-todo/tree/spring-boot-psql-testcontainers-todo#readme)

---

## Author

[Alexander Lapygin](https://github.com/AlexanderLapygin) <<alexanderlapygin@gmail.com>>

---

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


### License

Licensed under the [MIT license](./LICENSE)

---

[SOFTSPIDERS](https://github.com/softspiders/softspiders)
