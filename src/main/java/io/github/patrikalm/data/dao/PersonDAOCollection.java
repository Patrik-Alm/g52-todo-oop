package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.Person;

import java.util.Collection;
import java.util.HashSet;

public class PersonDAOCollection implements PersonDAO {

    // DAO implemented in a singleton pattern using private static final Collection and thus not creating new instances

    private static final Collection<Person> persons = new HashSet<>();

    @Override
    public Person persist(Person person) {

        persons.add(person);

        return person;
    }

    @Override
    public Person findById(int id) {

        for (Person person : persons) {

            if (person.getId() == id) {

                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : persons) {

            if (person.getEmail().equalsIgnoreCase(email)) {

                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {

        return persons;
    }

    @Override
    public void remove(int id) {

        for (Person person : persons) {

            if (person.getId() == id) {

                persons.remove(person);
            }
        }
    }
}
