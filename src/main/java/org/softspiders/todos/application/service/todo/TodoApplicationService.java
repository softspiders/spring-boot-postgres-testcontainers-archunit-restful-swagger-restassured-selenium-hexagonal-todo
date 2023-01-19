package org.softspiders.todos.application.service.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import org.softspiders.todos.domain.port.api.todo.TodoServicePort;
import org.softspiders.todos.domain.port.spi.todo.TodoCrudPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoServicePort {

  private final TodoCrudPort todoJpaPort;

  @Override
  public List<TodoDomainModel> getAllTodos() {
    return todoJpaPort.getAllTodos();
  }

  @Override
  public TodoDomainModel getTodoById(String id) {
//    return TODO_APPLICATION_SERVICE_MAPPER.toDomainModel(todoJpaPort.getById(id));
    return todoJpaPort.getById(id);
  }

  @Override
  public TodoDomainModel create(TodoDomainModel todoDomainModel) {
    return todoJpaPort.createTodo(todoDomainModel);
  }

  @Override
  public TodoDomainModel update(String id, TodoDomainModel todoDomainModel) {
    return todoJpaPort.updateTodo(todoDomainModel);
  }

  @Override
  public void deleteById(String id) {
    todoJpaPort.deleteById(id);
  }

  @Override
  public void deleteAll() {
    todoJpaPort.deleteAll();
  }
}
