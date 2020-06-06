package com.ada.nflow.annotation;

public class JsonSerializerTest {
    public static void main(String[] args) throws JsonSerializationException {
        Employee employee = new Employee("abhishek", "das", 38);
        JsonSerializer jsonSerializer = new JsonSerializer();
        String jsonString = jsonSerializer.serialize(employee);
        System.out.println(jsonString);
    }
}
