package org.example;

import java.util.*;
import java.util.stream.*;

public class Main {
    private static int readPetCount(Scanner scanner) {
        return IntStream.generate(() -> 0)
                .mapToObj(i -> {
                    try {
                        String input = scanner.nextLine();
                        int count = Integer.parseInt(input);
                        if (count > 0) {
                            return Optional.of(count);
                        } else {
                            System.out.println("Incorrect input. Number of animals should be positive");
                            return Optional.<Integer>empty();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Could not parse a number. Please, try again");
                        return Optional.<Integer>empty();
                    }
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(0);
    }

    private static Optional<Animal> readAnimal(Scanner scanner, int index, int total) {
        if (!scanner.hasNextLine()) {
            return Optional.empty();
        }

        String petType = scanner.nextLine().toLowerCase().trim();

        if (!petType.equals("dog") && !petType.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return Optional.empty();
        }

        if (!scanner.hasNextLine()) {
            return Optional.empty();
        }
        String name = scanner.nextLine().trim();

        if (!scanner.hasNextLine()) {
            return Optional.empty();
        }

        Optional<Integer> ageOpt = readAge(scanner);

        return ageOpt.map(age ->
                petType.equals("dog") ? new Dog(name, age) : new Cat(name, age)
        );
    }

    private static Optional<Integer> readAge(Scanner scanner) {
        try {
            String ageInput = scanner.nextLine();
            int age = Integer.parseInt(ageInput);
            if (age > 0) {
                return Optional.of(age);
            } else {
                System.out.println("Incorrect input. Age <= 0");
                return Optional.empty();
            }
        } catch (NumberFormatException e) {
            System.out.println("Could not parse a number. Please, try again");
            try {
                String ageInput = scanner.nextLine();
                int age = Integer.parseInt(ageInput);
                if (age > 0) {
                    return Optional.of(age);
                } else {
                    System.out.println("Incorrect input. Age <= 0");
                    return Optional.empty();
                }
            } catch (NumberFormatException e2) {
                System.out.println("Could not parse a number. Please, try again");
                return Optional.empty();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int petCount = readPetCount(scanner);

        List<Animal> pets = IntStream.range(0, petCount)
                .mapToObj(i -> readAnimal(scanner, i, petCount))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        scanner.close();

        List<Animal> updatedPets = pets.stream()
                .map(animal -> animal.getAge() > 10 ? animal.setAge(animal.getAge() + 1) : animal)
                .collect(Collectors.toList());
        updatedPets.forEach(animal -> System.out.println(animal.toString()));
    }
}