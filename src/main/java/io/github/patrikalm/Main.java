package io.github.patrikalm;

import io.github.patrikalm.dao.PeopleDao;
import io.github.patrikalm.dao.PeopleDaoImpl;
import io.github.patrikalm.dao.TodoItemsDao;
import io.github.patrikalm.dao.TodoItemsDaoImpl;
import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        // System.out.println("Hello world!");

        PeopleDao peopleDao = new PeopleDaoImpl();
        TodoItemsDao todoItemsDao = new TodoItemsDaoImpl();

       /* Person person1 = new Person("Mehrdad", "Javan");

        Person person2 = new Person("Marcus", "Gudmundsen");

        Person person3 = new Person("Göran", "Mårtensson");



        peopleDao.create(person1);
        peopleDao.create(person2);
        peopleDao.create(person3);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        Todo todoItem1 = new Todo("Mend bicykle", "Flat tyre, need to change tube.","2024-11-05");

        System.out.println(todoItem1);

        todoItemsDao.create(todoItem1);

        System.out.println(todoItem1); */

        todoItemsDao.deleteById(8);







    }
}