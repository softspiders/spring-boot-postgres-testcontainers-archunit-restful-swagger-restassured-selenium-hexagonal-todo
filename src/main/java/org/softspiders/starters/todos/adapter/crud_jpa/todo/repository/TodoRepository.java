package org.softspiders.starters.todos.adapter.crud_jpa.todo.repository;

import org.softspiders.starters.todos.adapter.crud_jpa.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    @Query("select t from TodoEntity t where t.completed is false")
    Iterable<TodoEntity> getPendingTodos();
}
