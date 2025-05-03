package com.ironhack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private final List<Person> persons = new ArrayList<>();

    public PersonsList() {
        persons.add(new Person(1, "Robert Crumb", 79, "Comic Artist"));
        persons.add(new Person(2, "Art Spiegelman", 73, "Cartoonist"));
        persons.add(new Person(3, "Gilbert Shelton", 77, "Comic Artist"));
        persons.add(new Person(4, "Trina Robbins", 75, "Cartoonist"));
        persons.add(new Person(5, "Mary Fleener", 65, "Comic Artist"));
        persons.add(new Person(6, "Kim Deitch", 75, "Cartoonist"));
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person findByName(String name) {
        if (!name.matches("^\\S+ \\S+$")) {
            throw new IllegalArgumentException("The input is not properly formatted. " +
                    "Should be formatted as 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public Person clone(Person person, int newId) {
        if (person == null) {
            throw new IllegalArgumentException("The person cannot be null");
        }
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());

    }

    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(person.toString() + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing person to file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "PersonsList{" +
                "persons=" + persons +
                '}';
    }
}
