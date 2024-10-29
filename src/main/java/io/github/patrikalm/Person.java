package io.github.patrikalm;

import java.util.Objects;

public class Person {

    private static int sequencer = 1000;
    private int id;
    private String firstName;   //have to fix check null not allowed
    private String lastName;    //have to fix check null not allowed
    private String email;


    //constructor

    public Person(String firstName, String lastName, String email) {

        this.id =getId();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);

    }

    public Person(String firstName, String lastName){

        new Person(firstName, lastName, "Email not available.");
    }

    //methods

    public int getId() {

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

    public void getSummary() {

        StringBuilder sb = new StringBuilder();

        sb.append("ID number: " + id);
        sb.append(", Name: " + firstName + " " + lastName);
        sb.append(", Email: " + email);

        System.out.println(sb);
    }
}
