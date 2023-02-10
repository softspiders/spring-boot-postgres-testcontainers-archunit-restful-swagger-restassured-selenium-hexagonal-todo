package org.softspiders.starters.adapter.rest.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDetailsDtoTestBuilder;
import org.softspiders.starters.adapter.rest.todo.dto.TodoDtoTestBuilder;
import org.softspiders.starters.domain.model.todo.TodoDomainModelTestBuilder;
import org.softspiders.starters.domain.port.api.todo.TodoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = SpringExtension.class)
@WebMvcTest(controllers = TodoController.class)
@ContextConfiguration(classes = {TodoController.class})
class TodoControllerIntegrationTest {

    private static final String UNDER_TEST = "/todos";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoServicePort todoServicePort;

    @Disabled
    @Test
    void shouldFindAllTodos() throws Exception {
        when(todoServicePort.getAllTodos()).thenReturn(
                new TodoDomainModelTestBuilder().defaultTodo().buildMany(3)
        );

        mockMvc.perform(get(UNDER_TEST))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(
                        new TodoDtoTestBuilder().defaultTodo().buildMany(3)
                )));
    }

    @Test
    void shouldFindTodoDetailsById() throws Exception {
        var todoId = "1";

        when(todoServicePort.getTodoById(todoId)).thenReturn(
                new TodoDomainModelTestBuilder()
                        .defaultTodo()
                        .build()
        );

        mockMvc.perform(get(UNDER_TEST + "/" + todoId))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(
                        new TodoDetailsDtoTestBuilder()
                                .defaultTodo()
                                .build()
                )));
    }
}