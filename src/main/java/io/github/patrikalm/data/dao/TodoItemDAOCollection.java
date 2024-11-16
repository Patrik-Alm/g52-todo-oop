package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;


public class TodoItemDAOCollection implements TodoItemDAO {

    // DAO implemented in a singleton pattern using private static final Collection and thus not creating new instances
    private static final Collection<TodoItem> todoItems = new HashSet<>();

    @Override
    public TodoItem persist(TodoItem todoItem) {

        todoItems.add(todoItem);

        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {

        for (TodoItem todoItem : todoItems) {

            if (todoItem.getId() == id) {

                return todoItem;
            }
        }

        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {

        return todoItems;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {

        Collection<TodoItem> localTodoItems = new HashSet<>();

        for (TodoItem todoItem : todoItems) {

            if (todoItem.isDone()) {

                localTodoItems.add(todoItem);
            }
        }

        return localTodoItems;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {

        Collection<TodoItem> localTodoItems = new HashSet<>();

        for (TodoItem todoItem : todoItems) {

            if (todoItem.getTitle().equalsIgnoreCase(title)) {

                localTodoItems.add(todoItem);
            }
        }

        return localTodoItems;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {

        Collection<TodoItem> localTodoItems = new HashSet<>();

        for (TodoItem todoItem : todoItems) {

            if (todoItem.getId() == personId) {

                localTodoItems.add(todoItem);
            }
        }

        return localTodoItems;
    }

    @Override
    public Collection<TodoItem> findByDeadLineBefore(LocalDate date) {

        Collection<TodoItem> localTodoItems = new HashSet<>();

        for (TodoItem todoItem : todoItems) {

            if (todoItem.getDeadLine().isBefore(date)) {

                localTodoItems.add(todoItem);
            }
        }

        return localTodoItems;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate date) {

        Collection<TodoItem> localTodoItems = new HashSet<>();

        for (TodoItem todoItem : todoItems) {

            if (todoItem.getDeadLine().isAfter(date)) {

                localTodoItems.add(todoItem);
            }
        }

        return localTodoItems;
    }

    @Override
    public void remove(int id) {

        for (TodoItem todoItem : todoItems) {

            if (todoItem.isDone()) {

                todoItems.remove(todoItem);
            }
        }
    }
}
