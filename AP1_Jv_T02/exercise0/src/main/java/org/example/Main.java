package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count_of_animals = 0;
        boolean validCount = false;

        while (!validCount) {
            try {
                count_of_animals = Integer.parseInt(in.nextLine());
                if (count_of_animals > 0) {
                    validCount = true;
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
            if (!in.hasNextLine()) break;

            String type_of_animal = in.nextLine();

            if (type_of_animal.equals("dog") || type_of_animal.equals("cat")) {
                if (!in.hasNextLine()) break;
                String name = in.nextLine();

                Integer age = null;
                boolean validAge = false;
                while (!validAge && in.hasNextLine()) {
                    try {
                        String ageInput = in.nextLine();
                        age = Integer.parseInt(ageInput);
                        if (age > 0) {
                            validAge = true;
                        } else {
                            System.out.println("Incorrect input. Age <= 0");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Could not parse a number. Please, try again");
                    }
                }

                if (validAge) {
                    if (type_of_animal.equals("dog")) {
                        Dog dog = new Dog(name, age);
                        pets.add(dog);
                    } else {
                        Cat cat = new Cat(name, age);
                        pets.add(cat);
                    }
                }

            } else {
                System.out.println("Incorrect input. Unsupported pet type");
            }
        }
        for (Animal pet : pets) {
            System.out.println(pet.toString());
        }

        in.close();
    }
}