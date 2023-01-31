package org.softspiders.starters.application.service.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.starters.domain.model.todo.TodoDomainModel;
import org.softspiders.starters.domain.port.api.todo.TodoServicePort;
import org.softspiders.starters.domain.port.spi.todo.TodoCrudPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoServicePort {

  private final TodoCrudPort todoCrudPort;

  @Override
  public List<TodoDomainModel> getAllTodos() {
    return todoCrudPort.getAllTodos();
  }

  @Override
  public TodoDomainModel getTodoById(String id) {
//    return TODO_APPLICATION_SERVICE_MAPPER.toDomainModel(todoCrudPort.getById(id));
    return todoCrudPort.getById(id);
  }

  @Override
  public TodoDomainModel create(TodoDomainModel todoDomainModel) {
    return todoCrudPort.createTodo(todoDomainModel);
  }

  @Override
  public TodoDomainModel update(String id, TodoDomainModel todoDomainModel) {
    return todoCrudPort.updateTodo(todoDomainModel);
  }

  @Override
  public void deleteById(String id) {
    todoCrudPort.deleteById(id);
  }

  @Override
  public void deleteAll() {
    todoCrudPort.deleteAll();
  }
}
