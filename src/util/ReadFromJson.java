package util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import data.Contact;

import java.util.ArrayList;

public class ReadFromJson {
    public static ArrayList<Contact> read(String fileName) {
        String string = ReadFromTxt.read(fileName);
        Gson builder = new GsonBuilder()
                .registerTypeAdapter(ArrayList.class,new ContactConverter())
                .create();
        ArrayList<Contact> events = builder.fromJson(string,ArrayList.class);
        return events;
    }
}
