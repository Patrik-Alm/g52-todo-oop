package io.github.patrikalm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @BeforeEach
    void setUp() {

        Person person = new Person("Johan", "Ragnarsson", "johan.ragnarsson@email.com");


    }

    @Test
    void testPersonGetId() {

        assertEquals(1000, );
    }





}
