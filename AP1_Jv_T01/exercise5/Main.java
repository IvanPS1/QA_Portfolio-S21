package org.example;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.UK);
        int size = inputSize(scanner);
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }
        double[] numbers = inputNumbers(scanner, size);
        selectionSort(numbers);
        printArray(numbers);
        scanner.close();
    }
    public static int inputSize(Scanner scanner) {
        int size;
        while(true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                continue;
            }
            size = scanner.nextInt();
            return size;
        }
    }
    public static double[] inputNumbers(Scanner scanner, int size){
        double[] numbers = new double[size];
        for (int i = 0; i < size; i++) {
            while (true) {
                if (!scanner.hasNextDouble()) {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.next();
                    continue;
                }
                numbers[i] = scanner.nextDouble();
                break;
            }
        }
        return numbers;
    }
    public static void selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}