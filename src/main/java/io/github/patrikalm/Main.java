package io.github.patrikalm;

import io.github.patrikalm.dao.PeopleDao;
import io.github.patrikalm.dao.PeopleDaoImpl;
import io.github.patrikalm.dao.TodoItemsDao;
import io.github.patrikalm.dao.TodoItemsDaoImpl;
import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {


        // System.out.println("Hello world!");

        PeopleDao peopleDao = new PeopleDaoImpl();
        TodoItemsDao todoItemsDao = new TodoItemsDaoImpl();

       /* Person person1 = new Person("Mehrdad", "Javan");

        Person person2 = new Person("Marcus", "Gudmundsen");

        Person person3 = new Person("Göran", "Mårtensson");


        // create - validated
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

        // deleteById - validated
        //peopleDao.deleteById(8);

        //findByName - validated - now also return the first row
        /* Collection<Person> persons = new ArrayList<>();
        persons = peopleDao.findByName("Mehrdad Javan");
        System.out.println(persons); */

        //findById - validated
        /* Person person = new Person();
        person = peopleDao.findById(1);
        System.out.println(person);*/


        //findAll - validated - now also return the first row
        /* Collection<Person> people = peopleDao.findAll();
        for (Person person : people) { System.out.println(person);} */

        //update - validated
        /* Person person = new Person(1, "Mehrdad", "Java");
        peopleDao.update(person); */

        // All functionalities for PeopleDaoImpl validated









    }
}