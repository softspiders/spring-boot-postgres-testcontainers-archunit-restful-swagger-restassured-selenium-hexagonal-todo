package org.softspiders.todos.application.service.todo;

import org.softspiders.todos.domain.model.port.spi.todo.TodoJpaPort;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import java.util.List;

public class TodoApplicationService implements TodoJpaPort {
    @Override
    public List<TodoDomainModel> getAllTodos() {
        return null;
    }

    @Override
    public TodoDomainModel getById() {
        return null;
    }

    @Override
    public TodoDomainModel createTodo(TodoDomainModel todo) {
        return null;
    }

    @Override
    public TodoDomainModel updateTodo(TodoDomainModel todo) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
