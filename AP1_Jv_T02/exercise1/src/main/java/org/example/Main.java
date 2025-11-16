package org.example;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int count_of_animals = 0;
        boolean flag = true;
        while (flag) {
            try {
                count_of_animals = Integer.parseInt(in.nextLine());
                if (count_of_animals > 0) {
                    flag = false;
                } else {
                    System.out.println("Incorrect input. Number of animals should be positive");
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
                in.nextLine();
            }
        }
        ArrayList<Animal> pets = new ArrayList<Animal>();
        for (int i = 0; i < count_of_animals; i++) {
            String type_of_animal = in.nextLine();
            if (type_of_animal.equals("dog")) {
                String name = in.nextLine();
                Integer age = Integer.parseInt(in.nextLine());
                if (age > 0) {
                    Double weight = Double.parseDouble(in.nextLine());
                    if (weight > 0){
                        Dog dog = new Dog(name, age, weight);
                        pets.add(dog);
                        System.out.println(dog.toString());
                    } else {
                        System.out.println("Incorrect input. Mass <= 0");
                    }
                } else {
                    System.out.println("Incorrect input. Age <= 0");
                }
            } else if (type_of_animal.equals("cat")) {
                String name = in.nextLine();
                Integer age = Integer.parseInt(in.nextLine());
                if (age > 0) {
                    Double weight = Double.parseDouble(in.nextLine());
                    if (weight > 0){
                        Cat cat = new Cat(name, age, weight);
                        pets.add(cat);
                        System.out.println(cat.toString());
                    } else {
                        System.out.println("Incorrect input. Mass <= 0");
                    }
                } else {
                    System.out.println("Incorrect input. Age <= 0");
                }
            } else {
                System.out.println("Incorrect input. Unsupported pet type");
            }
        }
    }
}