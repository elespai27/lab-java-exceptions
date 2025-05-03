package com.ironhack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    @DisplayName("Should throw an Exception if the age is 0 or negative")
    void setMethodAge() {
        Person p = new Person(1, "Test User", 25, "Tester");
        assertThrows(IllegalArgumentException.class, () -> p.setMethodAge(-1));
    }
}