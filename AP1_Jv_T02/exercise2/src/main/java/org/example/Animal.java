package org.example;

public abstract class Animal {
    private String name;
    private Integer age;
    Animal(String name, Integer age){
        this.age = age;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public Integer getAge() {
        return age;
    }
}
