package org.example;

public class Cat extends Animal {
    public Cat (String name, Integer age, Double mass) { super (name, age, mass); }
    @Override
    public Double getFeedInfoKg() { return getMass() * 0.1; }
    @Override
    public String toString(){
        return "Cat name = " + getName() + ", age = " + getAge() + ", mass = " + String.format("%.2f", getMass()) + ", feed = " + String.format("%.2f", getFeedInfoKg());
    }
}
