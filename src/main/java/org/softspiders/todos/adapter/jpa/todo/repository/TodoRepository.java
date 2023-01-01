package org.softspiders.todos.adapter.jpa.todo.repository;

import org.softspiders.todos.adapter.jpa.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TodoRepository extends PagingAndSortingRepository<TodoEntity, String> {
    @Query("select t from TodoEntity t where t.completed is false")
    Iterable<TodoEntity> getPendingTodos();
}
