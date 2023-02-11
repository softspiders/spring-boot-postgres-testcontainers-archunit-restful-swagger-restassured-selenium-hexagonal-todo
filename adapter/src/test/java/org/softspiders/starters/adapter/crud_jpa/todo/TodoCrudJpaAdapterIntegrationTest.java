package org.softspiders.starters.adapter.crud_jpa.todo;

import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.softspiders.starters.adapter.crud_jpa.AbstractAdapterIntegrationTest;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = {TodoCrudJpaAdapter.class})
public class TodoCrudJpaAdapterIntegrationTest extends AbstractAdapterIntegrationTest {

    @Autowired
    private TodoCrudJpaAdapter underTest;

    @Test
    @DataSet(value = {"todos.xml"})
    void shouldGetTodoById() {
        var actual = underTest.getById("10001");

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder()
                                .jpaTodo()
                                .withId("10001")
                                .build()
                );
    }

    @Test
    @DataSet(value = {"todos.xml"})
    void shouldGetAllTodoByIds() {
//        var actual = underTest.getAllTodoByIds(List.of("10001", "10002"));
        var actual = underTest.getAllTodos();

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder()
                                .jpaTodo()
                                .withId("10001")
                                .buildMany(2)
                );
    }
}