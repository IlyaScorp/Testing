package com.spbstu.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.JDIPages.entities.Data;
import com.spbstu.selenidePages.users.User;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;


public class ResourceLoader {

    private static Map<String, User> USERS;
    private static Map<String, Data> DATA;

    static {
        load();
    }

    @SneakyThrows
    private static void load() {
//        Load Users
        FileReader fileReader = new FileReader(ResourceLoader.class.getClassLoader().getResource("data/users.json").getFile());
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, User>>() {
        }.getType();

        USERS = new Gson().fromJson(jsonReader, type);

//        Load Data
        FileReader fileReaderData = new FileReader(ResourceLoader.class.getClassLoader().getResource("data/metalColor.json").getFile());
        JsonReader jsonReaderData = new JsonReader(fileReaderData);

        Type typeData = new TypeToken<Map<String, Data>>() {
        }.getType();

        DATA = new Gson().fromJson(jsonReaderData, typeData);

    }

    public static User getUser(String userId) {
        return USERS.get(userId);
    }

    public static Data getData(String dataId) {
        return DATA.get(dataId);
    }
}
