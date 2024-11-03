package io.github.patrikalm;

import java.time.LocalDate;

public class TodoItem {

    private static int sequencer = 1000;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {

        this.id = getId();
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;



    }

    private int getId() {

        return sequencer++;

    }

    public String getTitle() {


    }




}
