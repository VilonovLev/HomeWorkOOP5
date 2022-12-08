package util;


import com.google.gson.*;
import data.Person;

import java.lang.reflect.Type;

public class PersonConverter implements JsonSerializer<Person>, JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement jsonElement, Type type,
                              JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        Person person = Person.createPerson("");
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        person.setName(jsonObject.get("name").getAsString());
        person.setLastName(jsonObject.get("lastName").getAsString());
        return person;
    }

    @Override
    public JsonElement serialize(Person person, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", person.getName());
        jsonObject.addProperty("lastName", person.getLastName());
        return jsonObject;
    }
}
