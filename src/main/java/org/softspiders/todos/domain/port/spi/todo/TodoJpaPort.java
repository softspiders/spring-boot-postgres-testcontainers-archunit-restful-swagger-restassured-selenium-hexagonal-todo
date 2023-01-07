package org.softspiders.todos.domain.port.spi.todo;

import java.util.List;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;

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
     * Get todo by id
     *
     * @return todo
     */
    TodoDomainModel getById(String id);

    /**
     * Creates a new todo
     *
     * @param todo to be created
     * @return the newly created todo
     */
    TodoDomainModel createTodo(TodoDomainModel todo);

    /**
     * Update todo by the given model
     *
     * @param todo new value of the model
     * @return the updated todo
     */
    TodoDomainModel updateTodo(TodoDomainModel todo);

    /**
     * Delete todo by the given id
     *
     * @param id todo id
     */
    void deleteById(String id);

    /**
     * Delete all todos
     */
    void deleteAll();
}