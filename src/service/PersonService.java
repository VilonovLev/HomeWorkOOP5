package service;

import data.Person;

import java.util.ArrayList;

public interface PersonService<T extends Person> {
    T create(String name,String lastName);
    T create(String name);
    void addPersonToList(T t);
    boolean removePersonFromList(int index);
}

