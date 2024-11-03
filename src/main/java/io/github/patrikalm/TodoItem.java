package io.github.patrikalm;

import java.time.LocalDate;

public class TodoItem {

    private static int sequencer = 1000;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done = false;
    private Person creator;


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {

        this.id = getId();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);


    }

    private int getId() {

        return sequencer++;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        //have to implement check null or empty not allowed

        this.title = title;
    }

    public String getTaskDescription() {

        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {

        this.taskDescription = taskDescription;

    }

    public LocalDate getDeadLine() {

        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {

        //have to implement check null not allowed

        this.deadLine = deadLine;
    }

    public void setDone() {

        this.done = true;
    }

    public boolean isDone() {

        return done;
    }

    public Person getCreator() {

        return creator;
    }

    public void setCreator(Person creator) {

        this.creator = creator;
    }

    public boolean isOverdue() {

        if (LocalDate.now().isAfter(getDeadLine())) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append("Id: ");
        sb.append(id);
        // add new line with sb.append()
        sb.append("Task: ");
        sb.append(title);
        // add new line with sb.append()
        sb.append("Description: ");
        sb.append(taskDescription);
        // add new line with sb.append()
        sb.append("Deadline: ");
        sb.append(deadLine);
        // add new line with sb.append()
        sb.append("Status: ");

        if (isDone()) {
            sb.append("The task is done.");
        }
        else if (isOverdue()) {
            sb.append("The task is overdue.");
        }
        else {
            sb.append("The task is not done");
        }

        return sb.toString();
    }

}
