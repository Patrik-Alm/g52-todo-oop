package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.TodoItem;
import io.github.patrikalm.model.TodoItemTask;

import java.util.Collection;
import java.util.HashSet;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    // DAO implemented in a singleton pattern using private static final Collection and thus not creating new instances
    private static final Collection<TodoItemTask> todoItemTasks = new HashSet<>();


    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {

        todoItemTasks.add(todoItemTask);

        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {


        for (TodoItemTask todoItemTask : todoItemTasks) {

            if (todoItemTask.getId() == id) {

                return todoItemTask;
            }
        }

        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {

        return todoItemTasks;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {

        Collection<TodoItemTask> localTodoItemTasks = new HashSet<>();

        for (TodoItemTask todoItemTask : todoItemTasks) {

            if (todoItemTask.isAssigned()) {

                localTodoItemTasks.add(todoItemTask);
            }
        }

        return localTodoItemTasks;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {

        Collection<TodoItemTask> localTodoItemTasks = new HashSet<>();

        for (TodoItemTask todoItemTask : todoItemTasks) {

            if (todoItemTask.getId() == personId) {

                localTodoItemTasks.add(todoItemTask);
            }
        }

        return localTodoItemTasks;
    }

    @Override
    public void remove(int id) {

        for (TodoItemTask todoItemTask : todoItemTasks) {

            if (todoItemTask.getId() == id) {

                todoItemTasks.remove(todoItemTask);
            }
        }
    }
}
