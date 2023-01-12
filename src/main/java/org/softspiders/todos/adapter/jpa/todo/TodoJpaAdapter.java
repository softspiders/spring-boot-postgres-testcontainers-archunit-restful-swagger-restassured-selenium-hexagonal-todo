package org.softspiders.todos.adapter.jpa.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.adapter.jpa.todo.entity.TodoEntity;
import org.softspiders.todos.adapter.jpa.todo.repository.TodoRepository;
import org.softspiders.todos.domain.port.spi.todo.TodoJpaPort;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.softspiders.todos.adapter.jpa.todo.mapper.TodoJpaMapper.TODO_JPA_MAPPER;

@Component
@RequiredArgsConstructor
public class TodoJpaAdapter implements TodoJpaPort {
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDomainModel> getAllTodos() {
        return TODO_JPA_MAPPER.toDomainModelList(todoRepository.findAll());
    }

    @Override
    public TodoDomainModel getById(String id) {
        return TODO_JPA_MAPPER.toDomainModel(todoRepository.getById(id));
    }

    @Override
    public TodoDomainModel createTodo(TodoDomainModel todo) {
        var createdTodo = todoRepository.save(TODO_JPA_MAPPER.toEntity(todo));
        return TODO_JPA_MAPPER.toDomainModel(createdTodo);
    }

    @Override
    public TodoDomainModel updateTodo(TodoDomainModel todo) {
        TodoEntity todoEntity = todoRepository.save(TODO_JPA_MAPPER.toEntity(todo));
        return TODO_JPA_MAPPER.toDomainModel(todoEntity);
    }

    @Override
    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        todoRepository.deleteAll();
    }
}
