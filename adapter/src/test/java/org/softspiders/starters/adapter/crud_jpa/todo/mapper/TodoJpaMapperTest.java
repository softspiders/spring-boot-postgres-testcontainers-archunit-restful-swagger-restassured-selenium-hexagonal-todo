package org.softspiders.starters.adapter.crud_jpa.todo.mapper;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.softspiders.starters.adapter.crud_jpa.todo.entity.TodoEntityTestBuilder;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.softspiders.starters.adapter.crud_jpa.todo.mapper.TodoJpaMapper.TODO_JPA_MAPPER;

@SpringBootTest(classes = TodoJpaMapper.class)
class TodoJpaMapperTest {

    @Test
    void shouldMapToDomainModel() {
        val actual = TODO_JPA_MAPPER.toDomainModel(
                new TodoEntityTestBuilder().defaultTodo().build()
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder().jpaTodo().build()
                );
    }

    @Test
    void shouldMapToDomainModelList() {
        val actual = TODO_JPA_MAPPER.toDomainModelList(
                new TodoEntityTestBuilder().defaultTodo().buildMany(3)
        );

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder().jpaTodo().buildMany(3)
                );
    }
}