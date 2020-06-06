package com.ada.nflow.annotation;

public class Fruit {
    private String colour;
    private String name;
    private int count;

    public Fruit() {
    }

    public Fruit(String name, String colour, int count) {
        this.colour = colour;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "colour='" + colour + '\'' +
                ", name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
