package com.ironhack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonsListTest {

    @Test
    @DisplayName("Should return a valid object Person")
    void findByName() {
       PersonsList list = new PersonsList();
        Person person = list.findByName("Mary Fleener");
        assertNotNull(person);
        assertEquals("Mary Fleener", person.getName());
    }
    @Test
    @DisplayName("Should return a exception if the formatted is incorrect")
    void findByNameIncorrect() {
       PersonsList list = new PersonsList();
       assertThrows(IllegalArgumentException.class, () -> list.findByName("Mary"));
       assertThrows(IllegalArgumentException.class, () -> list.findByName("Mary Fleener Plus"));
    }

    @Test
    void testClone() {
        PersonsList list = new PersonsList();
        Person original = list.findByName("Mary Fleener");
        Person clone = list.clone(original, 99);
        assertNotNull(clone);
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getAge(), clone.getAge());
        assertEquals(original.getOccupation(), clone.getOccupation());
        assertNotEquals(original.getId(), clone.getId());
    }
}