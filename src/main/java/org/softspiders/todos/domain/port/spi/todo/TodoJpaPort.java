package org.softspiders.todos.domain.port.spi.todo;

import org.softspiders.todos.domain.model.todo.TodoDomainModel;

import java.util.List;

/**
 * Secondary port is used to manage todos on persistence level
 */
public interface TodoJpaPort {
    /**
     * Gets all created todos
     *
     * @return list of todos
     */
    List<TodoDomainModel> getAllTodos();

    /**
     * Creates a new todo
     *
     * @param todo to be created
     * @return the newly created todo
     */
    TodoDomainModel createTodo(TodoDomainModel todo);
}