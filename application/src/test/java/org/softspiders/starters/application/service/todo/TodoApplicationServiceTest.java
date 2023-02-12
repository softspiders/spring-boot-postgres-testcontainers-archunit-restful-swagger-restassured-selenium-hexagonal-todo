package org.softspiders.starters.application.service.todo;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.softspiders.starters.domain.port.spi.todo.TodoCrudPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoApplicationServiceTest {
    @Mock
    private TodoCrudPort todoCrudPort;

    @InjectMocks
    private TodoApplicationService underTest;

    @Test
    void shouldGetAllTodos() {
        var jpaTodos = new TodoDomainModelTestBuilder().jpaTodo().buildMany(3);

        when(todoCrudPort.getAllTodos()).thenReturn(jpaTodos);

        val actual = underTest.getAllTodos();

        assertThat(actual).isEqualTo(
                new TodoDomainModelTestBuilder()
                        .defaultTodo()
                        .buildMany(3)
        );

        InOrder inOrder = inOrder(todoCrudPort);
        inOrder.verify(todoCrudPort).getAllTodos();
    }

    @Test
    void shouldGetTodoById() {
        var jpaTodo = new TodoDomainModelTestBuilder().jpaTodo().build();

        when(todoCrudPort.getById(jpaTodo.getId())).thenReturn(jpaTodo);

        val actual = underTest.getTodoById(jpaTodo.getId());

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(
                        new TodoDomainModelTestBuilder()
                                .defaultTodo()
                                .build()
                );

        InOrder inOrder = inOrder(todoCrudPort);
        inOrder.verify(todoCrudPort).getById(jpaTodo.getId());
    }
}
