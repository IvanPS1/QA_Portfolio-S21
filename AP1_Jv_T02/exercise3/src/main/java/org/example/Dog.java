package org.example;

public class Dog extends Animal {
    Dog(String name, int age) { super (name, age); }

    @Override
    public String toString() { return "Dog name = "
            + getName() + ", age = " + getAge(); }

    @Override
    public Animal setAge(int newAge) {
        return new Dog(getName(), newAge);
    }
}
