    package org.softspiders.starters.adapter.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CreateTodoDto {

    @NotNull
    private String title;
    private String description;
    @NotNull
    private Boolean completed = false;
    @NotNull
    @Positive
    private Integer order;

}