package org.softspiders.starters.application.service.todo.mapper;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.softspiders.starters.application.service.todo.mapper.TodoApplicationServiceMapper.TODO_APPLICATION_SERVICE_MAPPER;

@SpringBootTest(classes = TodoApplicationServiceMapper.class)
public class TodoApplicationServiceMapperTest {

    @Test
    void shouldMapToDetailsDomainModel() {
        var jpaTodo = new TodoDomainModelTestBuilder()
                .jpaTodo()
                .build();

        val actual = TODO_APPLICATION_SERVICE_MAPPER.toDomainModel(jpaTodo);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder()
                                .defaultTodo()
                                .build()
                );
    }

    @Test
    void shouldMapToListDomainModel() {
        var jpaTodo = new TodoDomainModelTestBuilder()
                .jpaTodo()
                .build();

        val actual = TODO_APPLICATION_SERVICE_MAPPER.toDomainModel(jpaTodo);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder()
                                .defaultTodo()
                                .build()
                );
    }
}
