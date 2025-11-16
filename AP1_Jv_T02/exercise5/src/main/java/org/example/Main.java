package org.example;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static int initNumber(Scanner sc) {
        boolean flag = true;
        int result = -1;
        while (flag) {
            try {
                result = sc.nextInt();
                flag = false;
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                sc.next();
            }
        }
        sc.nextLine();
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int sizeArray = initNumber(sc);
        ArrayList<Animal> pets = new ArrayList<>();
        Animal type;
        String name;
        int age;
        String typeOfAnimal;
        for (int i = 0; i < sizeArray; i++) {
            typeOfAnimal = sc.nextLine();
            if (typeOfAnimal.equals("dog")) {
                name = sc.nextLine();
                age = initNumber(sc);
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    continue;
                }
                type = new Dog(name, age);
                pets.add(type);
            } else if (typeOfAnimal.equals("cat")) {
                name = sc.nextLine();
                age = initNumber(sc);
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    continue;
                }
                type = new Cat(name, age);
                pets.add(type);
            } else {
                System.out.println("Incorrect input. Unsupported pet type");
            }
        }
        AnimalIterator animalIterator = new AnimalIterator(pets);
        while (animalIterator.hasNext()) {
            System.out.println(animalIterator.next().toString());
        }
    }
}