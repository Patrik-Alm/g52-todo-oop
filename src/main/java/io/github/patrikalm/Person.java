package io.github.patrikalm;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class Person {

    private static int sequencer = 1000;
    private int id; //is generated
    private String firstName;   //have a null or empty check
    private String lastName;    //have null or empty check
    private String email;


    //constructor

    public Person(String firstName, String lastName, String email) {

        this.id =getId();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }



    //methods

      private int getId() {

        return sequencer++;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName == null || firstName.trim().isEmpty())
            throw new IllegalArgumentException("Firstname can not be null or empty.");

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Lastname can not be null or empty.");


        this.lastName = lastName;
    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty())
            throw new IllegalArgumentException("Email can not be null or empty.");
        this.email = email;
    }

    public String getSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Person id: ");
        sb.append(id);
        sb.append(System.lineSeparator());
        sb.append("Name: ");
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append(System.lineSeparator());
        sb.append("Email: ");
        sb.append(email);

        return sb.toString();
    }
}
