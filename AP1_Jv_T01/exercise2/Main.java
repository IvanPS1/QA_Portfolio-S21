package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = inputFibonacciIndex();
        if (n > 45) {
            System.out.println("Too large n");
            return;
        }
        long fibonacciNumber = calculateFibonacci(n);
        System.out.println(fibonacciNumber);
    }

    public static int inputFibonacciIndex() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        while (number < 0) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                continue;
            }

            number = scanner.nextInt();

            if (number < 0) {
                System.out.println("Index cannot be negative. Please, try again");
            }
        }

        return number;
    }

    public static long calculateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}