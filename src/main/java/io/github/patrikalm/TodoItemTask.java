package io.github.patrikalm;

public class TodoItemTask {

    private static int sequencer = 1000;
    private int id;
    private boolean assigned = false;
    private Person assignee;
    private TodoItem todoItem;




    public TodoItemTask(TodoItem todoItem) {

        id = getId();
        setTodoItem(todoItem);
    }


    private int getId() {

        return sequencer++;
    }

    public boolean isAssigned() {

        return assigned;
    }

    public void setAssigned() {

        assigned = true;
    }

    public TodoItem getTodoItem() {

        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {

        if (todoItem == null) throw new IllegalArgumentException("Can not be null.");

        this.todoItem = todoItem;
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
        sb.append(todoItem.getTitle());
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
        sb.append(todoItem.getTitle());
        sb.append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        TodoItemTask localTodoItemTask = (TodoItemTask) obj;

        if (this.id == localTodoItemTask.id
                && this.todoItem == localTodoItemTask.todoItem) {

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {

        return todoItem.hashCode();
    }


}
