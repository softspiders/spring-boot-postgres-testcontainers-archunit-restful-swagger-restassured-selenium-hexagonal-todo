package org.softspiders.todos.application.service.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import org.softspiders.todos.domain.port.api.todo.TodoServicePort;
import org.softspiders.todos.domain.port.spi.todo.TodoJpaPort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.softspiders.todos.application.service.todo.TodoApplicationServiceMapper.TODO_APPLICATION_SERVICE_MAPPER;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoServicePort {

  private final TodoJpaPort todoJpaPort;

  @Override
  public List<TodoDomainModel> getAllTodos() {
    return todoJpaPort.getAllTodos();
  }

  @Override
  public TodoDomainModel getTodoById(String id) {
    return TODO_APPLICATION_SERVICE_MAPPER.toDomainModel(todoJpaPort.getById(id));

//    return repository.findById(id)
//            .map(ResponseEntity::ok)
//            .orElseThrow(() -> new TodoNotFoundException(id));
  }

  @Override
  public TodoDomainModel save(TodoDomainModel todoDomainModel) {
    throw new UnsupportedOperationException();
  }

  @Override
  public TodoDomainModel update(String id, TodoDomainModel todoDomainModel) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteById(String id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException();
  }
}
