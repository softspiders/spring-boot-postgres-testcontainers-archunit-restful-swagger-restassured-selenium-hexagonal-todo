package org.softspiders.starters.adapter.rest.todo.dto;

import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

public class TodoDtoTestBuilder {

    private final TodoDto todo;

    public TodoDtoTestBuilder() {
        todo = new TodoDto();
    }

    public TodoDtoTestBuilder defaultTodo() {
        var todoDomainModel = new TodoDomainModelTestBuilder()
                .defaultTodo()
                .build();

        todo.setId(todoDomainModel.getId());
        todo.setTitle(todoDomainModel.getTitle());
        todo.setOrder(todoDomainModel.getOrder());

        return this;
    }

    public TodoDto build() {
        return todo;
    }

    public List<TodoDto> buildMany(Integer amount) {
        List<TodoDto> result = new ArrayList<>();
        result.add(todo); // The first element is the one that has been built

        // Next elements (come from second element) are copy of the original with index added to the fields
        range(2, amount + 1).forEach(index -> {
            var newTodo = new TodoDto();

            newTodo.setId(index + "");
            newTodo.setTitle(todo.getTitle() + index);
            newTodo.setOrder(todo.getOrder() + index - 1);

            result.add(newTodo);
        });

        return result;
    }
}