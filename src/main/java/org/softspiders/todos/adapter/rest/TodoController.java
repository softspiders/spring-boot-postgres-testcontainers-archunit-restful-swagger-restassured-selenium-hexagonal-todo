package org.softspiders.todos.adapter.rest;

import lombok.RequiredArgsConstructor;
import org.softspiders.todos.adapter.rest.dto.CreateTodoDto;
import org.softspiders.todos.adapter.rest.dto.TodoDetailsDto;
import org.softspiders.todos.adapter.rest.dto.TodoDto;
import org.softspiders.todos.domain.port.api.todo.TodoServicePort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.softspiders.todos.adapter.rest.mapper.TodoRestMapper.TODO_REST_MAPPER;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
  private final TodoServicePort todoServicePort;

  @GetMapping
  public Iterable<TodoDto> getAll() {
    return TODO_REST_MAPPER.toDtoList(todoServicePort.getAllTodos());
  }

  @GetMapping("{id}")
  public TodoDetailsDto getById(@PathVariable String id) {
    return TODO_REST_MAPPER.toTodoDetailsDto(todoServicePort.getTodoById(id));
  }

  @PostMapping
  public TodoDto save(@Valid @RequestBody CreateTodoDto todo) {
    return TODO_REST_MAPPER.toDto(todoServicePort.save(TODO_REST_MAPPER.toDomainModel(todo)));
  }

  @PatchMapping("/{id}")
  public TodoDto update(@PathVariable String id, @Valid @RequestBody TodoDto todo) {
    return TODO_REST_MAPPER.toDto(todoServicePort.update(id, TODO_REST_MAPPER.toDomainModel(todo)));
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id) {
    todoServicePort.deleteById(id);
  }

  @DeleteMapping
  public void deleteAll() {
    todoServicePort.deleteAll();
  }
}
