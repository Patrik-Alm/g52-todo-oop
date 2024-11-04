package io.github.patrikalm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    void testMainRun() {


        Person person1 = new Person("Mehrdad", "Javan", "Mehrdad@javan.com");
        Person person2 = new Person("Marcus", "Gudmundsen", "marcus.gudmundsen@lexicon.se");
        Person person3 = new Person("Göran", "Mårtensson", "goran.martensson@email.com");
        Person person4 = new Person("Johan", "Ragnarsson", "johan.ragnarsson@email.com");

        System.out.println(person1.getSummary());
        System.out.println(person2.getSummary());

        TodoItem todoItem1 = new TodoItem("Mend bicycle", "Flat tyre, need to change tube.","2024-11-05", person2);
        TodoItem todoItem2 = new TodoItem("Clean workshop", "Weekly maintenance routines.", "2024-11-03", person1);

        System.out.println(todoItem1.getSummary());

        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem2);

        System.out.println(todoItemTask1.getSummary());
        System.out.println(todoItemTask2.getSummary());

        todoItemTask1.setAssignee(person3);
        todoItemTask2.setAssignee(person4);

        System.out.println(todoItemTask1.getSummary());
        System.out.println(todoItemTask2.getSummary());


    }

    @Test
    void testIsAssignedIsTrue() {

        Person person1 = new Person("Mehrdad", "Javan", "Mehrdad@javan.com");
        TodoItem todoItem1 = new TodoItem("Mend bicykle", "Flat tyre, need to change tube.","2024-11-05", person1);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1);
        todoItemTask1.setAssignee(person1);

        assertTrue(todoItemTask1.isAssigned());

    }

    @Test
    void testIsAssignedIsFalse() {

        Person person1 = new Person("Mehrdad", "Javan", "Mehrdad@javan.com");
        TodoItem todoItem1 = new TodoItem("Mend bicykle", "Flat tyre, need to change tube.","2024-11-05", person1);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1);

        assertFalse(todoItemTask1.isAssigned());

    }





}
