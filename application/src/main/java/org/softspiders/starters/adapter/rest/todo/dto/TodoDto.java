package org.softspiders.starters.adapter.rest.todo.dto;

import lombok.Data;

@Data
public class TodoDto {

    private String id;
    private String title;
    private Boolean completed = false;
    private Integer order;
}