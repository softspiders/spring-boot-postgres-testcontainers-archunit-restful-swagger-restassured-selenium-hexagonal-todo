package org.softspiders.starters;

import org.junit.jupiter.api.Test;
import org.softspiders.starters.adapter.rest.todo.TodoController;
import org.softspiders.starters.application.service.todo.TodoApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///hexagonal"
})
class ApplicationTests {

    @Autowired
    private TodoApplicationService todoApplicationService;

    @Autowired
    private TodoController todoController;

    @Test
    void contextLoads() {
        assertThat(todoApplicationService).isNotNull();
        assertThat(todoController).isNotNull();
    }

}
