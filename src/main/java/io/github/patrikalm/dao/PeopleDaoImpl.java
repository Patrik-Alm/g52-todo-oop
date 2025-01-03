package io.github.patrikalm.dao;

import io.github.patrikalm.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import static io.github.patrikalm.service.MySqlDBConnection.getConnection;

public class PeopleDaoImpl implements PeopleDao {


    @Override
    public Person create(Person person) {

        String sql = "INSERT INTO person VALUES(?, ?)";

        // try with resources so we do not have to close connection

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedstatement.setString(1, person.getFirstName());
            preparedstatement.setString(2, person.getLastName());


            int rowsAffected = preparedstatement.executeUpdate();

            if (rowsAffected > 0) {

                // Sending the generated id with the returned Person
                // What if id is not null in the person sent in as argument? - Should not affect as DB does not handle it and below it is overridden.

                int id = PreparedStatement.RETURN_GENERATED_KEYS;

                person.setId(id);

                return person;
            }

        } catch (SQLException e) {
            // Putting in a rollback if something happens with the connection as we are changing the database content
            try {
                getConnection().rollback();
            } catch (SQLException e2) {
                e.printStackTrace();
            }

           throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }

        return null;

    }

    @Override
    public ArrayList<Person> findAll() {

        try (Statement statement = getConnection().createStatement())
        {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            if (resultSet.getInt("person_id") < 1) {
                System.out.println("Nothing is found.");
                return null;
            }

            ArrayList<Person> persons = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("person_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Person person = new Person(id, firstName, lastName);
                try {
                    persons.add(person);
                } catch (RuntimeException e) {
                    throw new RuntimeException("Something went wrong when adding to ArrayList persons " + e.getMessage());
                }
            }

            return persons;

    } catch (SQLException e) {

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
    }

    @Override
    public Person findById(int id) {

        String sql = "SELECT * FROM person WHERE person_id = ?";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql)) {

            preparedstatement.setInt(1, id);

            ResultSet resultSet = preparedstatement.executeQuery();

            if (resultSet.next()) {

                return new Person(resultSet.getInt("person_id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"));
            }

            System.out.println("Sorry, no person with that id exists in the database.");

                return null;

        } catch (SQLException e) {

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Person> findByName(String name) {

        String [] nameSplit = name.trim().split("\\s+", 2);

        String namePart1 = nameSplit[0];
        String namePart2 = nameSplit[1]; // regex limit set to 2 if  is two "names" with spaces between.

        String sql = "SELECT * FROM person WHERE first_name = ? AND last_name = ?";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql)) {

            preparedstatement.setString(1, namePart1);
            preparedstatement.setString(2, namePart2);

            preparedstatement.executeQuery();

            ResultSet resultSet = preparedstatement.executeQuery();

            if (resultSet.getInt("person_id") < 1) {

                System.out.println("Nothing is found.");
                return null;
            }

            ArrayList<Person> persons = new ArrayList<>();

            while (resultSet.next()) {

                int id = resultSet.getInt("person_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                Person person = new Person(id, firstName, lastName);

                persons.add(person);
            }

            return persons;

        } catch (SQLException e) {

        throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
    }

    @Override
    public Person update(Person person) {
         // TODO Assumption made that person_id brought by argument is not null and is valid. Has to be checked elsewhere
        // All values are overwritten so it does not matter if first_name or last_name is updated or both. Id is autogenerated and not touched by the DB.


        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql)) {
            preparedstatement.setString(1, person.getFirstName());
            preparedstatement.setString(2, person.getLastName());
            preparedstatement.setInt(3, person.getId());


            int rowsAffected = preparedstatement.executeUpdate();

            if (rowsAffected > 0) {

                return person;
            }

        } catch (SQLException e) {
            // Putting in a rollback if something happens with the connection as we are changing the database content

            try {
                getConnection().rollback();
            } catch (SQLException e2) {
                e.printStackTrace();
            }
            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean deleteById(int id) {

        // TODO Assumption made that person_id brought by argument is not null and is valid. Has to be checked elsewhere

        String sql = "DELETE FROM person WHERE person_id = ?";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedstatement.setInt(1, id);

            int rowsAffected = preparedstatement.executeUpdate();

            if (rowsAffected > 0) {

                return true;
            }

        } catch (SQLException e) {
            // Putting in a rollback if something happens with the connection as we are changing the database content

            try {
                getConnection().rollback();
            } catch (SQLException e2) {
                e.printStackTrace();
            }

            throw new RuntimeException("Oops, something went wrong! " + e.getMessage());
        }
        return false;
    }
}
