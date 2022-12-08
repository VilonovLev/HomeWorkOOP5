package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Contact;

import java.util.ArrayList;

public class WriteToJson {
    public static void write(String fileName, ArrayList<Contact> contacts) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(ArrayList.class, new ContactConverter());

        Gson gson = builder.create();
        String string = gson.toJson(contacts);
        WriteToFile.write(string,fileName);
    }
}
