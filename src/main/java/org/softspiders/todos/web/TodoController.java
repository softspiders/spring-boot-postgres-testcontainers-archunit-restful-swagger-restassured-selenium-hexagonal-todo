//package org.softspiders.todos.web;
//
//import org.softspiders.todos.adapter.jpa.todo.entity.TodoEntity;
//import org.softspiders.todos.adapter.jpa.todo.repository.TodoRepository;
//import org.softspiders.todos.domain.model.port.spi.todo.TodoJpaPort;
//import org.softspiders.todos.domain.model.todo.TodoDomainModel;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/todos")
//public class TodoController {
//    private final TodoJpaPort todoJpaPort;
//    public TodoController(TodoJpaPort todoJpaPort) {
//        this.todoJpaPort = todoJpaPort;
//    }
//
//    @GetMapping
//    public Iterable<TodoDomainModel> getAll() {
//        return todoJpaPort.getAllTodos();
//    }
//
//    @GetMapping("/{id}")
////    public ResponseEntity<TodoEntity> getById(@PathVariable String id) {
////        return repository.findById(id)
////                .map(ResponseEntity::ok)
////                .orElseThrow(() -> new TodoNotFoundException(id));
////    }
//    public TodoDomainModel getById(@PathVariable String id) {
//        todoJpaPort.getById(id);
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElseThrow(() -> new TodoNotFoundException(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<TodoEntity> save(@Valid @RequestBody TodoEntity todo) {
//        todo.setId(null);
//        TodoEntity savedTodo = repository.save(todo);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .header("Location", savedTodo.getUrl())
//                .body(savedTodo);
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<TodoEntity> update(@PathVariable String id, @Valid @RequestBody TodoEntity todo) {
//        TodoEntity existingTodo = repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
//        if(todo.getCompleted() != null) {
//            existingTodo.setCompleted(todo.getCompleted());
//        }
//        if(todo.getOrder() != null) {
//            existingTodo.setOrder(todo.getOrder());
//        }
//        if(todo.getTitle() != null) {
//            existingTodo.setTitle(todo.getTitle());
//        }
//        TodoEntity updatedTodo = repository.save(existingTodo);
//        return ResponseEntity.ok(updatedTodo);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteById(@PathVariable String id) {
//        TodoEntity todo = repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
//        repository.delete(todo);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping
//    public ResponseEntity<Void> deleteAll() {
//        repository.deleteAll();
//        return ResponseEntity.ok().build();
//    }
//}
