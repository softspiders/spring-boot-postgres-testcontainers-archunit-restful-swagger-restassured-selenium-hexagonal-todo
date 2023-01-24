package org.softspiders.starters.todos.domain.model.todo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class TodoDomainModel {
    private String id;
    private String title;
    private Boolean completed = false;
    private Integer order;
}
