package org.example;
import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.25;
        try {
            TimeUnit.MILLISECONDS.sleep((long) (walkTime * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return walkTime;
    }
}
