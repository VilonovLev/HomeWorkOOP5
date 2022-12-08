package data;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {
    private Person person;
    private ArrayList<String> personNumbers;

    private Contact(Person person, ArrayList<String> personNumbers) {
        this.person = person;
        this.personNumbers = personNumbers;
    }

    private Contact(Person person) {
        this.person = person;
        this.personNumbers = new ArrayList<>();
    }

    private Contact() {
        this(null);
    }

    public static Contact createContact(Person person, ArrayList<String> personNumbers) {
        return new Contact(person,personNumbers);
    }

    public static Contact createContact(Person person) {
        return new Contact(person);
    }

    public static Contact createContact() {
        return new Contact();
    }


    public void addNumber(String number) {
        personNumbers.add(number);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<String> getPersonNumbers() {
        return personNumbers;
    }

    public void setPersonNumbers(ArrayList<String> personNumbers) {
        this.personNumbers = personNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return person.equals(contact.person) && personNumbers.equals(contact.personNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, personNumbers);
    }

    @Override
    public String toString() {
        return "Contact{" + person +
                ", personNumbers=" + personNumbers +
                '}';
    }
}
