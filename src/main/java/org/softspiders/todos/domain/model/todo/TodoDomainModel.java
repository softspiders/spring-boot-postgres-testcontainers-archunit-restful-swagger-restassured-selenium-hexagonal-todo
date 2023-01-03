package org.softspiders.todos.domain.model.todo;

import lombok.Data;

@Data
public class TodoDomainModel {
    private String id;
    private String title;
    private Boolean completed = false;
    private Integer order;
}
