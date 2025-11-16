package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = inputSize(scanner);
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }
        int[] numbers = inputNumbers(scanner, size);
        searchAndPrintMatches(numbers);
        scanner.close();
    }
    public static int inputSize(Scanner scanner) {
        int size;
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                continue;
            }
            size = scanner.nextInt();
            return size;
        }
    }
    public static int[] inputNumbers(Scanner scanner, int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                    continue;
                }
                numbers[i] = scanner.nextInt();
                break;
            }
        }
        return numbers;
    }
    public static boolean hasMatchingDigits(int number) {
        if (number == 0) return true;
        int absNum = Math.abs(number);
        int lastDigit = absNum % 10;
        int firstDigit = absNum;
        while (firstDigit >= 10) firstDigit /= 10;
        return firstDigit == lastDigit;
    }
    public static void searchAndPrintMatches(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (hasMatchingDigits(num)) count++;
        }
        if (count == 0) {
            System.out.println("There are no such elements");
            return;
        }
        int[] matches = new int[count];
        int index = 0;
        for (int num : numbers) {
            if (hasMatchingDigits(num)) matches[index++] = num;
        }
        for (int match : matches) {
            System.out.println(match);
        }
    }
}