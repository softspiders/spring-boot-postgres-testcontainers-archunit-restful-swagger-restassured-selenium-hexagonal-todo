<div align="center">
    <a href="https://github.com/softspiders/softspiders">
      <img src="https://avatars.githubusercontent.com/u/47006425?v=4"width="100" height="100"/>
    </a>
</div> 

# Spring Boot with PostgresSQL, Flyway, Testcontainers, REST Assured Restful ToDo application starter


## Feature tags

- flyway
- hexagonal
- maven
- mapstruct
- postgres
- rest
- rest-assured
- spring-boot
- spring-data-jpa
- starter
- swagger
- template
- testcontainers
- todo

---

## Direct ancestor

[***- restassured***: spring-boot-psql-testcontainers-todo](https://github.com/softspiders/springboot-postgres-testcontainers-restassured-selenium-restful-todo-app-starter/tree/springboot-psql-testcontainers-restassured-hexagonal-todo#readme)

## Direct descendant

[***+ archunit***: spring-boot-psql-testcontainers-restassured-restful-todo](https://github.com/softspiders/springboot-postgres-testcontainers-restassured-selenium-restful-todo-app-starter/tree/spring-boot-psql-testcontainers-restassured-restful-archunit-hexagonal-todo#readme)

---

## Author

[Alexander Lapygin](https://github.com/AlexanderLapygin) <<alexanderlapygin@gmail.com>>

---

## Requirements

- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/get-docker/)

---

# To run locally
1) Run a Postgres database from the container: ```docker run --name hexagonal_postgres -d -p 5434:5432 -e POSTGRES_USER=sa -e POSTGRES_PASSWORD=password -e POSTGRES_DB=hexagonal postgres```
2) Build it with maven to generate classes. ```mvn compile``` will do the job. (in Intellij you may need to reload maven project to find generated classes from the ```soap.hexagonal.demo..``` package)
3) Run the main class ```DemoApplication``` as any other Spring Boot application.

The project simulates an online store. Take a look at http://localhost:8080/swagger-ui.html.


## Run tests

```sh
mvnw verify
```

### License

Licensed under the [MIT license](./LICENSE)

---

[SOFTSPIDERS](https://github.com/softspiders/softspiders)
