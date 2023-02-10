package org.softspiders.starters.adapter.rest.todo.dto;

import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;

public class TodoDetailsDtoTestBuilder {

    private final TodoDetailsDto todo;

    public TodoDetailsDtoTestBuilder() {
        todo = new TodoDetailsDto();
    }

    public TodoDetailsDtoTestBuilder defaultTodo() {
        var todoDomainModel = new TodoDomainModelTestBuilder()
                .defaultTodo()
                .build();

        todo.setId(todoDomainModel.getId());
        todo.setTitle(todoDomainModel.getTitle());
        todo.setOrder(todoDomainModel.getOrder());

        return this;
    }

    public TodoDetailsDto build() {
        return todo;
    }
}