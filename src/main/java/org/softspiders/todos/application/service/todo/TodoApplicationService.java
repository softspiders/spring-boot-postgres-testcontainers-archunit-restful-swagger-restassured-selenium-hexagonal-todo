package org.softspiders.todos.application.service.todo;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;
import org.softspiders.todos.domain.port.api.todo.TodoServicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoApplicationService implements TodoServicePort {
  @Override
  public List<TodoDomainModel> getAllTodos() {
    throw new UnsupportedOperationException();
  }

  @Override
  public TodoDomainModel getTodoById(String id) {
    throw new UnsupportedOperationException();
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
