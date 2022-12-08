package service;

import data.*;

import java.util.ArrayList;

public class PersonServiceImpl implements PersonService<Person> {
    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public Person create(String name, String lastName) {
        Person person = Person.createPerson(name,lastName);
        persons.add(person);
        return person;
    }

    @Override
    public Person create(String name) {
        Person person = Person.createPerson(name);
        persons.add(person);
        return person;
    }

    @Override
    public void addPersonToList(Person person) {
        persons.add(person);
    }

    @Override
    public boolean removePersonFromList(int index) {
        return persons.remove(persons.get(index));
    }


}
