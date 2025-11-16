package org.example;

public abstract class Animal {
    private String name;
    private Integer age;
    private Double mass;
    public Animal(String name, Integer age, Double mass){
        this.name = name;
        this.age = age;
        this.mass = mass;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getMass(){
        return mass;
    }
    public abstract Double getFeedInfoKg();
}
