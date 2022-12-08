package service;

import data.Contact;
import data.Person;
import util.ReadFromJson;
import util.WriteToFile;
import util.WriteToJson;

import java.util.ArrayList;

public class ContactServiceImpl implements ContactService<Contact>{
    private ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    public Contact createContact(Person person) {
        Contact contact = Contact.createContact(person);
        contacts.add(contact);
        return contact;
    }

    @Override
    public void addContactToList(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public boolean removeContactFromList(int index) {
        return contacts.remove(contacts.get(index));
    }

    @Override
    public ArrayList<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public void save(String fileName, String separator) {
        if (fileName.contains(".json")) {
            WriteToJson.write(fileName,contacts);
        }else{
            WriteToFile.write(contacts.toString(),fileName);
        }
    }

    @Override
    public void load() {
        contacts.addAll(ReadFromJson.read("json.json"));
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public int getSizeContacts() {
        return contacts.size();
    }


}
