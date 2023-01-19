package org.softspiders.todos.adapter.crud.todo.repository;

import org.softspiders.todos.adapter.crud.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    @Query("select t from TodoEntity t where t.completed is false")
    Iterable<TodoEntity> getPendingTodos();
}
