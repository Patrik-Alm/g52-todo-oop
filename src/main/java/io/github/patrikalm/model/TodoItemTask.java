package io.github.patrikalm.model;

public class TodoItemTask {

    private static int sequencer = 1000;
    private int id;
    private boolean assigned = false;
    private Person assignee;
    private Todo todo;




    public TodoItemTask(Todo todo) {

        id = sequencer++;
        setTodoItem(todo);
    }


    public int getId() {
        //changed due to DAO implementation to public and to return int id
        return this.id;
    }

    public boolean isAssigned() {

        return assigned;
    }

    public void setAssigned() {

        assigned = true;
    }

    public Todo getTodoItem() {

        return todo;
    }

    public void setTodoItem(Todo todo) {

        if (todo == null) throw new IllegalArgumentException("Can not be null.");

        this.todo = todo;
    }

    public Person getAssignee() {

        return assignee;
    }

    public void setAssignee(Person assignee) {

        this.assignee = assignee;
        setAssigned();
    }

   /* public String getSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Task Id; ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Task todo: ");
        sb.append(todo.getTitle());
        sb.append(System.lineSeparator());
        sb.append("Assigned to: ");
        if (isAssigned()) {
            sb.append(assignee.getFirstName());
            sb.append(" ");
            sb.append(assignee.getLastName());
            sb.append(", Email: ");
            sb.append(assignee.getEmail());
        }
        else {
            sb.append("Is not assigned to anyone.");
        }

        return sb.toString();
    } */

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Task Id; ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Task todo: ");
        sb.append(todo.getTitle());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        TodoItemTask localTodoItemTask = (TodoItemTask) obj;

        if (this.id == localTodoItemTask.id
                && this.todo == localTodoItemTask.todo) {

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {

        return todo.hashCode();
    }


}
