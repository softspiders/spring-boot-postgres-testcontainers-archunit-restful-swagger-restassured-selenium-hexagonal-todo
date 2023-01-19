package org.softspiders.todos.adapter.crud_jpa.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.adapter.crud_jpa.todo.mapper.TodoJpaMapper;
import org.softspiders.todos.adapter.crud_jpa.todo.repository.TodoRepository;
import org.softspiders.todos.domain.port.spi.todo.TodoCrudPort;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TodoJpaAdapter implements TodoCrudPort {
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDomainModel> getAllTodos() {
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModelList(todoRepository.findAll());
    }

    @Override
    public TodoDomainModel createTodo(TodoDomainModel todo) {
        var createdTodo = todoRepository.save(TodoJpaMapper.TODO_JPA_MAPPER.toEntity(todo));
        return TodoJpaMapper.TODO_JPA_MAPPER.toDomainModel(createdTodo);
    }
}
