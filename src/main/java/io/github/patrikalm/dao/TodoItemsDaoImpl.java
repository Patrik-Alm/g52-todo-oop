package io.github.patrikalm.dao;

import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static io.github.patrikalm.service.MySqlDBConnection.getConnection;

public class TodoItemsDaoImpl implements TodoItemsDao {


    @Override
    public Todo create(Todo todo) {

        String sql = "INSERT INTO todo_item VALUES(?, ?, ?, ?, ?)";

        Date deadlineDate = Date.valueOf(todo.getDeadLine());
        int done = (todo.isDone() ? 1 : 0);


        // try with resources so we do not have to close connection

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedstatement.setString(1, todo.getTitle());
            preparedstatement.setString(2, todo.getDescription());
            preparedstatement.setDate(3, deadlineDate);
            preparedstatement.setInt(4, done);
            preparedstatement.setInt(5, todo.getAssigneeId());


            int rowsAffected = preparedstatement.executeUpdate();

            if (rowsAffected > 0) {

                // Sending the generated id back with the returned instance
                // What if id is not null in the person sent in as argument? - Should not affect as DB does not handle it and below it is overridden.

                int id = PreparedStatement.RETURN_GENERATED_KEYS;

                todo.setId(id);

                return todo;
            }

        } catch (SQLException e) {
            // Putting in a rollback if something happens with the connection as we are changing the database content
            try {
                getConnection().rollback();
            } catch (SQLException e2) {
                e.printStackTrace();
            }

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Todo> findAll() {

        try (Statement statement = getConnection().createStatement())
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM todo_item");

            if (resultSet.getInt("todo_id") < 1) {
                System.out.println("Nothing is found.");
                return null;
            }

            ArrayList<Todo> todos = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("todo_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDate deadLine = resultSet.getDate("deadline").toLocalDate();
                 boolean doneStatus = resultSet.getInt("done") == 1;
                int assigneeId = resultSet.getInt("assignee_id");

                Todo todo = new Todo(id, title, description, deadLine.toString(), doneStatus, assigneeId);

                try {
                    todos.add(todo);
                } catch (RuntimeException e) {
                    throw new RuntimeException("Something went wrong when adding to ArrayList todos " + e.getMessage());
                }
            }
            return todos;

        } catch (SQLException e) {

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
    }

    @Override
    public Todo findById(int id) {

        String sql = "SELECT * FROM todo_item WHERE todo_id = ?";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql)) {

            preparedstatement.setInt(1, id);

            ResultSet resultSet = preparedstatement.executeQuery();

            if (resultSet.next()) {

                int dbId = resultSet.getInt("todo_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDate deadLine = resultSet.getDate("deadline").toLocalDate();
                boolean doneStatus = resultSet.getInt("done") == 1;
                int assigneeId = resultSet.getInt("assignee_id");

                return new Todo(dbId, title, description, deadLine.toString(), doneStatus, assigneeId); // choosing to give the returning instance the id from the database, so eventually problem with id can be detected.

            }

            System.out.println("Sorry, no person with that id exists in the database.");

            return null;

        } catch (SQLException e) {

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
    }

    @Override
    public Collection<Todo> findByDoneStatus(Boolean isDone) {

        String sql = "SELECT * FROM todo_item WHERE done = ?";

        int done = isDone ? 1 : 0;

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql)) {

            preparedstatement.setInt(1, done );

            ResultSet resultSet = preparedstatement.executeQuery();
            if (resultSet.getInt("todo_id") < 1) {
                System.out.println("Nothing is found.");
                return null;
            }

            ArrayList<Todo> todos = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("todo_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                LocalDate deadLine = resultSet.getDate("deadline").toLocalDate();
                boolean doneStatus = resultSet.getInt("done") == 1;
                int assigneeId = resultSet.getInt("assignee_id");

                Todo todo = new Todo(id, title, description, deadLine.toString(), doneStatus, assigneeId);

                try {
                    todos.add(todo);
                } catch (RuntimeException e) {
                    throw new RuntimeException("Something went wrong when adding to ArrayList todos " + e.getMessage());
                }
            }
            return todos;

        } catch (SQLException e) {

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }

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
