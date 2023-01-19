package org.softspiders.todos.adapter.crud.todo.mapper;

import java.time.LocalDateTime;
import java.util.List;
import org.mapstruct.Mapper;
import static org.mapstruct.factory.Mappers.getMapper;

import org.softspiders.todos.adapter.crud.todo.entity.TodoEntity;
import org.softspiders.todos.domain.model.todo.TodoDomainModel;

@Mapper(imports = LocalDateTime.class)
public interface TodoJpaMapper {

    TodoJpaMapper TODO_JPA_MAPPER = getMapper(TodoJpaMapper.class);
    TodoEntity toEntity(TodoDomainModel todoDomainModel);
    TodoDomainModel toDomainModel(TodoEntity todoEntity);
    List<TodoDomainModel> toDomainModelList(List<TodoEntity> todoDomainModelList);
}
