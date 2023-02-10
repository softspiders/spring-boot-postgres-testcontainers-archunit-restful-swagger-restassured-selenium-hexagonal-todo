package org.softspiders.starters.domain.model.todo;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static java.util.stream.IntStream.range;

public class TodoDomainModelTestBuilder {
    public static final String TEST_ID = "1";
    public static final int TEST_ORDER = 1;
    public static final String TEST_TODO_TITLE = "Test todo title";

    private final TodoDomainModel todo;

    public TodoDomainModelTestBuilder() {
        todo = new TodoDomainModel();
    }

    public TodoDomainModelTestBuilder defaultTodo() {
        jpaTodo();

        return this;
    }

    public TodoDomainModelTestBuilder jpaTodo() {
        todo.setId(TEST_ID);
        todo.setTitle(TEST_TODO_TITLE);
        todo.setOrder(TEST_ORDER);

        return this;
    }

    public TodoDomainModelTestBuilder withId(String id) {
        todo.setId(id);

        return this;
    }

    public TodoDomainModel build() {
        return todo;
    }

    public List<TodoDomainModel> buildMany(Integer amount) {
        List<TodoDomainModel> result = new ArrayList<>();
        result.add(todo); // The first element is the one that has been built

        // Next elements (come from second element) are copy of the original with index added to the fields
        range(2, amount + 1).forEach(index -> {
            var newTodo = new TodoDomainModel();

            if (nonNull(todo.getId()))
                newTodo.setId(todo.getId() + (index - 1));
            if (nonNull(todo.getTitle()))
                newTodo.setTitle(todo.getTitle() + index);
            if (nonNull(todo.getOrder()))
                newTodo.setOrder(todo.getOrder() + index * 10);

            result.add(newTodo);
        });

        return result;
    }
}