package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

io.github.patrikalm.model.TodoItem;


public interface TodoItemDAO {

    TodoItem persist(TodoItem todoItem);

    TodoItem findById(int id);

    Collection<TodoItem> findAllByDoneStatus(boolean done);

    Collection<TodoItem> findByTitleContains(String title);

    Collection<TodoItem> findByPersonId(int personId);

    Collection<TodoItem> findByDeadLineBefore(LocalDate date);

    Collection<TodoItem> findByDeadLineAfter(LocalDate date);

    void remove(int id);


}
