package io.github.patrikalm.data.sequencers;

public class TodoItemIdSequencer {

    static int currentId;


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
