package io.github.patrikalm.dao;

import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;

import java.util.Collection;

public interface TodoItemsDao {

    Todo create(Todo todo);
    Collection<Todo> findAll();
    Todo findById(int id);
    Collection<Todo> findByDoneStatus(Boolean isDone);
    Collection<Todo> findByAssignee(int assigneeId);
    Collection<Todo> findByAssignee(Person person);
    Collection<Todo> findByUnassignedTodoItems();
    Todo update(Todo todo);
    Boolean deleteById(int id);
}
