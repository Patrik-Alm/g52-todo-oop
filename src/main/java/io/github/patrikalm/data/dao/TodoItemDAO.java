package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItem;
import java.time.LocalDate;
import java.util.Collection;


public interface TodoItemDAO {

    TodoItem persist(TodoItem todoItem);

    TodoItem findById(int id);

    Collection<TodoItem> findAll();

    Collection<TodoItem> findAllByDoneStatus(boolean done);

    Collection<TodoItem> findByTitleContains(String title);

    Collection<TodoItem> findByPersonId(int personId);

    Collection<TodoItem> findByDeadLineBefore(LocalDate date);

    Collection<TodoItem> findByDeadLineAfter(LocalDate date);

    void remove(int id);


}
