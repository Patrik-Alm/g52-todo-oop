package io.github.patrikalm.data.sequencers;

public class TodoItemTaskIdSequencer {

    // Sequencer implemented using private static variable to secure each instance has the same id sequence
    // Ready but not in use
    private static int currentId;


    public static int nextId() {

        currentId++;

        return currentId;
    }

    public static int getCurrentId() {

        return currentId;
    }

    public static void setCurrentId(int newId) {

        currentId = newId;
    }

}
