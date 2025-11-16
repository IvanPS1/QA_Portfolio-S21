package org.example;

public class Cat extends Animal {
    Cat(String name, int age) { super (name, age); }

    @Override
    public String toString() { return "Cat name = "
            + getName() + ", age = " + getAge(); }

    @Override
    public Animal setAge(int newAge) {
        return new Cat(getName(), newAge);
    }
}
