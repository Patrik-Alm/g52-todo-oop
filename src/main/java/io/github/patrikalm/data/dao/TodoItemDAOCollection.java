package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;


public class TodoItemDAOCollection implements TodoItemDAO {

    @Override
    public TodoItem persist(TodoItem todoItem) {
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDeadLineBefore(LocalDate date) {
        return null;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate date) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

}
