package com.ada.nflow.annotation;

@JsonSerializable
public class Employee {

    public Employee() {
    }

    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement(key = "personAge")
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Init
    private void init() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() +
                this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() +
                this.lastName.substring(1);
        System.out.println(this.firstName + " " + this.lastName + " " + this.age);
    }
}
