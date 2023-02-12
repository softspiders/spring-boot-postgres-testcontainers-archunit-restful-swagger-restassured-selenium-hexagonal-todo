package org.softspiders.starters.adapter.crud_jpa.todo.entity;

import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class TodoEntityTestBuilder {

    private final TodoEntity todo;

    public TodoEntityTestBuilder() {
        todo = new TodoEntity();
    }

    public TodoEntityTestBuilder defaultTodo() {
        var todoDomainModel = new TodoDomainModelTestBuilder()
                .defaultTodo()
                .build();

        todo.setId(todoDomainModel.getId());
        todo.setTitle(todoDomainModel.getTitle());
        todo.setOrder(todoDomainModel.getOrder());
        todo.setCompleted(todoDomainModel.getCompleted());

        return this;
    }

    public TodoEntity build() {
        return todo;
    }

    public List<TodoEntity> buildMany(Integer amount) {
        List<TodoEntity> result = new ArrayList<>();
        result.add(todo); // The first element is the one that has been built

        // Next elements (come from second element) are copy of the original with index added to the fields
        range(2, amount + 1).forEach(index -> {
            var newTodo = new TodoEntity();

            newTodo.setId(index + "");
            newTodo.setTitle(todo.getTitle() + index);
            newTodo.setOrder(todo.getOrder() + index - 1);
            newTodo.setCompleted(todo.getCompleted());

            result.add(newTodo);
        });

        return result;
    }
}