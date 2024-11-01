package io.github.patrikalm;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person person1 = new Person("Mehrdad", "Javan", "Mehrdad@javan.com");

        Person person2 = new Person("Marcus", "Gudmundsen");

        System.out.println(person1.getSummary());
        System.out.println(person2.getSummary());



    }

}