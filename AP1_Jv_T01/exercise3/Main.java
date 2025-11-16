package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = inputSize(scanner);
        int[] numbers = inputNumbers(scanner, size);
        calculateAndPrintAverage(numbers);
        scanner.close();
    }
    public static int inputSize(Scanner scanner) {
        int size = -1;
        while (size < 0) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                continue;
            }
            size = scanner.nextInt();
            if (size < 0) {
                System.out.println("Input error. Size <= 0");
            }
        }
        return size;
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
    public static void calculateAndPrintAverage(int[] numbers) {
        int negativeCount = 0;
        int negativeSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeCount++;
                negativeSum += numbers[i];
            }
        }
        if (negativeCount == 0) {
            System.out.println("There are no negative elements");
        } else {
            double average = (double) negativeSum / negativeCount;
            System.out.println((int) average);
        }
    }
}