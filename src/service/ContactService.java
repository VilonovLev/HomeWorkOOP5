package service;

import data.Contact;
import data.Person;

import java.util.ArrayList;

public interface ContactService<T extends Contact> {
    T createContact(Person person);

    void addContactToList(T t);

    boolean removeContactFromList(int index);

    ArrayList<T> getAllContacts();

    void save(String fileName, String separator);

    void load();
}
