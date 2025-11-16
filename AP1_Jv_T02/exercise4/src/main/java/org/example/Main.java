package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        int petCount = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                petCount = Integer.parseInt(scanner.nextLine());
                if (petCount > 0) {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }

        for (int i = 0; i < petCount; i++) {
            if (!scanner.hasNextLine()) break;

            String petType = scanner.nextLine().toLowerCase().trim();

            if (!petType.equals("dog") && !petType.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            if (!scanner.hasNextLine()) break;
            String name = scanner.nextLine().trim();

            int age = 0;
            boolean validAge = false;

            if (scanner.hasNextLine()) {
                try {
                    String ageInput = scanner.nextLine();
                    age = Integer.parseInt(ageInput);
                    if (age > 0) {
                        validAge = true;
                    } else {
                        System.out.println("Incorrect input. Age <= 0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    if (scanner.hasNextLine()) {
                        try {
                            String ageInput = scanner.nextLine();
                            age = Integer.parseInt(ageInput);
                            if (age > 0) {
                                validAge = true;
                            } else {
                                System.out.println("Incorrect input. Age <= 0");
                            }
                        } catch (NumberFormatException e2) {
                            System.out.println("Could not parse a number. Please, try again");
                        }
                    }
                }
            }

            if (validAge) {
                Animal pet = petType.equals("dog") ? new Dog(name, age) : new Cat(name, age);
                pets.add(pet);
            }
        }
        scanner.close();

        if (!pets.isEmpty()) {
            long programStartTime = System.currentTimeMillis();
            ExecutorService executor = Executors.newFixedThreadPool(pets.size());
            List<CompletableFuture<Void>> futures = new ArrayList<>();

            for (Animal pet : pets) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    long startTime = System.currentTimeMillis() - programStartTime;
                    double startTimeSec = startTime / 1000.0;
                    double walkDuration = pet.goToWalk();
                    long endTime = System.currentTimeMillis() - programStartTime;
                    double endTimeSec = endTime / 1000.0;
                    System.out.printf("%s, start time = %.2f, end time = %.2f%n",
                            pet.toString(), startTimeSec, endTimeSec);
                }, executor);
                futures.add(future);
            }

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            executor.shutdown();
        }
    }
}
