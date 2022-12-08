package data;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Person {

    @SerializedName("person name: ")
    private String name;

    @SerializedName("person last name:")
    private String lastName;

    private Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    protected Person() {
    }

    private Person(String name) {
        this(name, name);
    }

    public static Person createPerson(String name, String lastName) {
        return new Person(name, lastName);
    }

    public static Person createPerson(String name) {
        return createPerson(name, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
