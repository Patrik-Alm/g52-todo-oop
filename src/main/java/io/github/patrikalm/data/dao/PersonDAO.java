package io.github.patrikalm.data.dao;

import io.github.patrikalm.model.Person;

import java.util.Collection;


public interface PersonDAO {

Person persist(Person person);

Person findById(int id);

Collection<Person> findAll();

void remove(int id);

}
