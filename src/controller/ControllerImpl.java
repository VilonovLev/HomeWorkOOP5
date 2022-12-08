package controller;

import data.Contact;
import service.ContactServiceImpl;
import service.PersonServiceImpl;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerImpl implements Controller<Contact> {
    ContactServiceImpl contactService = new ContactServiceImpl();
    PersonServiceImpl personService = new PersonServiceImpl();
    Scanner scanner = new Scanner(System.in);
    static int indexEll;

    static {
        indexEll = 0;
    }

    @Override
    public void showAll() {
        ArrayList<Contact> contacts = contactService.getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            String output = "";
            if (i == indexEll)
                output += " >>> ";
            System.out.println(output + contacts.get(i));
        }
    }

    @Override
    public Contact showCurrent() {
        Contact contact = contactService.getContact(indexEll);
        System.out.println(contact);
        return contact;
    }

    @Override
    public Contact nextElement() {
        int size = contactService.getSizeContacts();
        ++indexEll;
        if (indexEll > size - 1) {
            indexEll = 0;
        }
        return contactService.getContact(indexEll);
    }

    @Override
    public Contact previousElement() {
        int size = contactService.getSizeContacts();
        --indexEll;
        if (indexEll < 0) {
            indexEll = size - 1;
        }
        return contactService.getContact(indexEll);
    }

    @Override
    public void addNumber() {
        System.out.println("Введите номер: ");
        String number = scanner.nextLine();
        Contact contact = contactService.getContact(indexEll);
        contact.addNumber(number);
    }

    @Override
    public void createElement() {
        System.out.println("Для создания укажите имя: ");
        contactService.createContact(personService.create(scanner.nextLine()));
    }

    @Override
    public void saveAs() {
        System.out.println("Укажите имя:");
        String fileName = scanner.nextLine();
        System.out.println("Укажите разделитель:");
        String separator = scanner.nextLine();
        contactService.save(fileName,separator);
    }

    @Override
    public void save() {
        contactService.save("json.json","");
    }


    @Override
    public void load() {
        contactService.load();
    }


}
