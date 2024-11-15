package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO {

    TodoItemTask persist(TodoItemTask todoItemTask);

    TodoItemTask findById(int id);

    Collection<TodoItemTask> findAll();

    Collection<TodoItemTask> findByAssignedStatus(boolean status);

    Collection<TodoItemTask> findByPersonId(int personId);

    void remove(int id);


}
