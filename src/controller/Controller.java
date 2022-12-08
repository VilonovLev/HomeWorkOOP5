package controller;

import data.Contact;

import java.util.ArrayList;

public interface Controller<T extends Contact> {
    void showAll();
    T showCurrent();
    T nextElement();
    T previousElement();
    void addNumber();
    void createElement();
    void saveAs();
    void save();
    void load();
}
