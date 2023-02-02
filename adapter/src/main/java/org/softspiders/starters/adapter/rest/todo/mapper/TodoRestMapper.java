package org.softspiders.starters.adapter.rest.todo.mapper;

import org.mapstruct.Mapper;
import org.softspiders.starters.adapter.rest.todo.dto.CreateTodoDto;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDetailsDto;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDto;
import org.softspiders.starters.domain.model.todo.TodoDomainModel;

import java.util.List;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TodoRestMapper {
    TodoRestMapper TODO_REST_MAPPER = getMapper(TodoRestMapper.class);
    TodoDetailsDto toTodoDetailsDto(TodoDomainModel todoDomainModel);
    TodoDto toDto(TodoDomainModel todoDomainModel);
    List<TodoDto> toDtoList(List<TodoDomainModel> todoDomainModelList);
    TodoDomainModel toDomainModel(CreateTodoDto createTodoDto);
    TodoDomainModel toDomainModel(TodoDto todoDto);
}