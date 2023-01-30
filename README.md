<div align="center">
    <a href="https://github.com/softspiders/softspiders">
      <img src="https://avatars.githubusercontent.com/u/47006425?v=4"width="100" height="100" alt="wrong link to logo"/>
    </a>
</div> 

# ToDo service starter with Hexagonal architecture on Spring Boot and PostgreSQL with Flyway and Swagger support, with testing support based on ArchUnit, Testcontainers, REST Assured and Selenium

## Feature tags

- archunit
- flyway
- hexagonal
- maven
- mapstruct
- postgres
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

[- selenium](https://github.com/softspiders/spring-boot-psql-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-todo/tree/spring-boot-psql-testcontainers-archunit-restful-swagger-restassured-hexagonal-todo#readme)

## Direct descendant

[+ monorepo](https://github.com/softspiders/spring-boot-psql-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-todo/tree/spring-boot-psql-testcontainers-archunit-restful-swagger-restassured-selenium-hexagonal-monorepo-todo#readme)

---

## Author

[Alexander Lapygin](https://github.com/AlexanderLapygin) <<alexanderlapygin@gmail.com>>

---

## Inspiration

- [Valery Sloboda.Hexagonal demo](https://github.com/Antilamer1709/hexagonal-demo)
- [Testcontainers SpringBoot Quickstart](https://github.com/testcontainers/testcontainers-java-spring-boot-quickstart)

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
