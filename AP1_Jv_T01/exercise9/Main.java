package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userCount = inputUserCount(scanner);
        if (userCount <= 0) {
            return;
        }
        List<User> users = inputUsers(scanner, userCount);
        printAdultUsers(users);
        scanner.close();
    }
    public static int inputUserCount(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }
        int count = scanner.nextInt();
        scanner.nextLine();
        if (count <= 0) {
            System.out.println("Input error. Size <= 0");
        }
        return count;
    }
    public static List<User> inputUsers(Scanner scanner, int userCount) {
        List<User> users = new ArrayList<>();
        int successfulInputs = 0;
        while (successfulInputs < userCount) {
            String name = scanner.nextLine();
            int age = inputUserAge(scanner);
            if (age <= 0) {
                continue;
            }
            users.add(new User(name, age));
            successfulInputs++;
        }
        return users;
    }
    public static int inputUserAge(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                scanner.nextLine();
                continue;
            }
            int age = scanner.nextInt();
            scanner.nextLine();

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return age;
            }
            return age;
        }
    }
    public static void printAdultUsers(List<User> users) {
        List<String> adultNames = users.stream()
                .filter(User::isAdult)
                .map(User::getName)
                .collect(Collectors.toList());
            if (!adultNames.isEmpty()) {
            System.out.println(String.join(", ", adultNames));
        }
    }
}