package com.ada.nflow.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {

    public String serialize(Object object) throws JsonSerializationException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new JsonSerializationException("Exception occurred while serializing the object ...");
        }
    }

    private String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, Object> jsonElementMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonElement.class)) {
                field.setAccessible(true);
                String key = getKey(field);
                Object value = field.get(object);
                jsonElementMap.put(key, value);
            }
        }
        String jsonString = jsonElementMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(",","{","}"));
        return jsonString;
    }

    private String getKey(Field field) {
        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        String key = null;
        if (!"".equals(jsonElement.key())) {
            key = jsonElement.key();
        } else {
            key = field.getName();
        }
        return key;
    }

    private void initializeObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        System.out.println(clazz.getSimpleName());
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private void checkIfSerializable(Object object) throws JsonSerializationException {
        if (Objects.isNull(object)) {
            throw new JsonSerializationException("The object is null");
        }
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException("The class " + clazz.getSimpleName() +
                    " is not annotated with JsonSerializable");
        }
    }
}
