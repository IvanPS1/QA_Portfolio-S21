package org.example;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double goToWalk();

    public abstract String toString();
}
