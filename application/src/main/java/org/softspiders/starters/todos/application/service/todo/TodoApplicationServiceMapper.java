package org.softspiders.starters.todos.application.service.todo;

import org.mapstruct.Mapper;
import org.softspiders.starters.todos.domain.model.todo.TodoDomainModel;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface TodoApplicationServiceMapper {

    TodoApplicationServiceMapper TODO_APPLICATION_SERVICE_MAPPER = getMapper(TodoApplicationServiceMapper.class);

    TodoDomainModel toDomainModel(TodoDomainModel todoDomainModel);
}