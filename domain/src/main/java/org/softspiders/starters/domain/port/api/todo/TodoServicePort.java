package org.softspiders.starters.domain.port.api.todo;

import org.softspiders.starters.domain.model.todo.TodoDomainModel;

import java.util.List;

/**
 * Primary port is used to manage todos
 */
public interface TodoServicePort {

    /**
     * Gets all available todos without pagination and filtering
     *
     * @return list of all available todos
     */
    List<TodoDomainModel> getAllTodos();

    /**
     * Finds a todo by the given id
     *
     * @param id of the todo
     * @return the todo with the given id
     */
    TodoDomainModel getTodoById(String id);

    /**
     * Create a new todo of the given todoId
     *
     * @param todoDomainModel data about todo to create it
     * @return a newly created or updated todo
     */
    TodoDomainModel create(TodoDomainModel todoDomainModel);

    /**
     * Update the todo
     *
     * @param id of the todo
     * @param todoDomainModel data about todo to update it
     * @return the updated todo
     */
    TodoDomainModel update(String id, TodoDomainModel todoDomainModel);

    /**
     * Delete the todo
     *
     * @param id of the todo to be deleted
     */
    void deleteById(String id);


    /**
     * Delete all todos
     */
    void deleteAll();
}