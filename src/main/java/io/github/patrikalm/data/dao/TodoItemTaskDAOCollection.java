package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItemTask;

import java.util.Collection;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {


    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
