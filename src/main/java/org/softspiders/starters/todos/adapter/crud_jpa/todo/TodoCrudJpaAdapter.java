package org.softspiders.starters.todos.adapter.crud_jpa.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.starters.todos.adapter.crud_jpa.todo.entity.TodoEntity;
import org.softspiders.starters.todos.adapter.crud_jpa.todo.mapper.TodoJpaMapper;
import org.softspiders.starters.todos.adapter.crud_jpa.todo.repository.TodoRepository;
import org.softspiders.starters.todos.domain.port.spi.todo.TodoCrudPort;
import org.softspiders.starters.todos.domain.model.todo.TodoDomainModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TodoCrudJpaAdapter implements TodoCrudPort {
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDomainModel> getAllTodos() {
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModelList(todoRepository.findAll());
    }

    @Override
    public TodoDomainModel getById(String id) {
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModel(todoRepository.getById(id));
    }

    @Override
    public TodoDomainModel createTodo(TodoDomainModel todo) {
        var createdTodo = todoRepository.save(TodoJpaMapper.TODO_JPA_MAPPER.toEntity(todo));
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModel(createdTodo);
    }

    @Override
    public TodoDomainModel updateTodo(TodoDomainModel todo) {
        TodoEntity todoEntity = todoRepository.save(TodoJpaMapper.TODO_JPA_MAPPER.toEntity(todo));
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModel(todoEntity);
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
