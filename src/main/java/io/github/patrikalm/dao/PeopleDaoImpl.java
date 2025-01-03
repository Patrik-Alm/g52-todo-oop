package io.github.patrikalm.dao;

import io.github.patrikalm.model.Person;
import io.github.patrikalm.model.Todo;
import io.github.patrikalm.service.MySqlDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static io.github.patrikalm.service.MySqlDBConnection.getConnection;

public class PeopleDaoImpl implements PeopleDao {


    @Override
    public Person create(Person person) {

        String sql = "INSERT INTO person VALUES(?, ?)";

        try (PreparedStatement preparedstatement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedstatement.setString(1, person.getFirstName());
            preparedstatement.setString(2, person.getLastName());


            int rowsAffected = preparedstatement.executeUpdate();

            if (rowsAffected > 0) {

                // Sending the generated id with the returned Person
                // TODO What if id is not null in the sent in person?

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

            ArrayList<Person> persons = null;

            if (resultSet.getInt("person_id") < 1) {
                System.out.println("Nothing is found.");
                return null;
            }

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

        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public Boolean deleteById(int id) {
        return null;
    }
}
