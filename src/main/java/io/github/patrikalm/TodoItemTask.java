package io.github.patrikalm;

public class TodoItemTask {

    private static int sequencer = 1000;
    private int id;
    private boolean assigned = false;
    private TodoItem todoItem;
    private Person assignee;



    public TodoItemTask(Person assignee, TodoItem todoItem) {

        this.id = getId();
        this.assignee = assignee;
        this.todoItem = todoItem;

    }

    private int getId() {

        return sequencer++;
    }


}
