package io.github.patrikalm.dao;

import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;

import java.util.Collection;
import java.util.List;

public class TotoItemsDaoImpl implements TodoItemsDao {


    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public Collection<Todo> findAll() {
        return List.of();
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(Boolean isDone) {
        return List.of();
    }

    @Override
    public Collection<Todo> findByAssignee(int assigneeId) {
        return List.of();
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return List.of();
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return List.of();
    }

    @Override
    public Todo update() {
        return null;
    }

    @Override
    public Boolean deleteById(int id) {
        return null;
    }
}
