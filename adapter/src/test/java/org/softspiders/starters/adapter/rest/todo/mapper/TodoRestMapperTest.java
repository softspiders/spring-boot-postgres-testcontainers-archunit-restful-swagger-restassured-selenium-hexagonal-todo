package org.softspiders.starters.adapter.rest.todo.mapper;

import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDetailsDtoTestBuilder;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDtoTestBuilder;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.softspiders.starters.adapter.rest.todo.mapper.TodoRestMapper.TODO_REST_MAPPER;

@SpringBootTest(classes = TodoRestMapper.class)
class TodoRestMapperTest {

    @Test
    void shouldMapToTodoDetailsDto() {
        val actual = TODO_REST_MAPPER.toTodoDetailsDto(
                new TodoDomainModelTestBuilder()
                        .defaultTodo()
                        .build()
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDetailsDtoTestBuilder()
                                .defaultTodo()
                                .build()
                );
    }

    @Test
    void shouldMapToDto() {
        val actual = TODO_REST_MAPPER.toDto(
                new TodoDomainModelTestBuilder()
                        .defaultTodo()
                        .build()
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDtoTestBuilder()
                                .defaultTodo()
                                .build()
                );
    }

    @Test
    void shouldMapToDtoList() {
        val actual = TODO_REST_MAPPER.toDtoList(
                new TodoDomainModelTestBuilder()
                        .defaultTodo()
                        .buildMany(3)
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDtoTestBuilder()
                                .defaultTodo()
                                .buildMany(3)
                );
    }
}