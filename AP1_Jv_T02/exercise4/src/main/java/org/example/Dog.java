package org.example;
import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.5;
        try {
            TimeUnit.MILLISECONDS.sleep((long) (walkTime * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return walkTime;
    }
}
