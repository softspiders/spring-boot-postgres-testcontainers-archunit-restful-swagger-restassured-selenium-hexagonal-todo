package org.softspiders.starters.adapter.rest.dto;

import lombok.Data;

@Data
public class TodoDetailsDto {

    private String id;
    private String title;
    private String description;
    private Boolean completed = false;
    private Integer order;
}