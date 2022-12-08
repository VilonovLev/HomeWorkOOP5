package util;

import com.google.gson.*;
import data.*;
import service.ContactServiceImpl;
import service.PersonServiceImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactConverter implements JsonSerializer<ArrayList<Contact>>, JsonDeserializer<ArrayList<Contact>> {
    PersonConverter personConverter = new PersonConverter();
    ContactServiceImpl contactService = new ContactServiceImpl();

        @Override
        public ArrayList<Contact> deserialize(JsonElement jsonElement, Type type,
                                  JsonDeserializationContext jsonDeserializationContext)
                throws JsonParseException {
            ArrayList<Contact> contacts = new ArrayList<>();
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (var ell: jsonArray) {
                JsonObject jsonObject = (JsonObject) ell;
                Contact contact = contactService.createContact(personConverter.deserialize(jsonObject.get("person"),
                        Person.class,null));
                for (var number : jsonObject.get("numbers").getAsJsonArray()) {
                    contact.addNumber(number.toString());
                }
                contacts.add(contact);
            }
            return contacts;
        }

        @Override
        public JsonElement serialize(ArrayList<Contact> contacts, Type type,
                                     JsonSerializationContext jsonSerializationContext) {
            JsonArray jsonArray = new JsonArray();
            for (var contact:contacts){
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("person", personConverter.serialize(contact.getPerson(),
                        ArrayList.class, null));
                JsonArray jsonArray2 = new JsonArray();
                for (String number : contact.getPersonNumbers()) {
                    jsonArray2.add(number);

                }
                jsonObject.add("numbers", jsonArray2);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }

    }
