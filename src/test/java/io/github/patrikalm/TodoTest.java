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

        System.out.println(person1.toString());
        System.out.println(person2.toString());

        TodoItem todoItem1 = new TodoItem("Mend bicycle", "Flat tyre, need to change tube.","2024-11-05", person2);
        TodoItem todoItem2 = new TodoItem("Clean workshop", "Weekly maintenance routines.", "2024-11-03", person1);

        System.out.println(todoItem1.toString());

        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem2);

        System.out.println(todoItemTask1.toString());
        System.out.println(todoItemTask2.toString());

        todoItemTask1.setAssignee(person3);
        todoItemTask2.setAssignee(person4);

        System.out.println(todoItemTask1.toString());
        System.out.println(todoItemTask2.toString());


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

    @Test
    void testIsEqualFalseWrongRole() {

        AppUser person1 = new AppUser("Björn32", "0000", AppRole.APP_ROLE_USER);

        AppUser person2 = new AppUser("Björn32", "1234", AppRole.APP_ROLE_ADMIN);

        assertFalse(person1.equals(person2));
    }

    @Test
    void testIsEqualFalseWrongUser() {

        AppUser person1 = new AppUser("Björn32", "0000", AppRole.APP_ROLE_USER);

        AppUser person2 = new AppUser("Björn33", "1234", AppRole.APP_ROLE_ADMIN);

        assertFalse(person1.equals(person2));
    }

    @Test
    void testIsEqualTrue() {

        AppUser person1 = new AppUser("Björn32", "0000", AppRole.APP_ROLE_USER);

        AppUser person2 = new AppUser("Björn32", "1234", AppRole.APP_ROLE_USER);

        assertTrue(person1.equals(person2));
    }



}
