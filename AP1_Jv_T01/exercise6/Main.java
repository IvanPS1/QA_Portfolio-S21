package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        String filePath = consoleScanner.nextLine();
        processFile(filePath);
        consoleScanner.close();
    }

    public static void processFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Input error. File doesn't exist");
            return;
        }
        try (Scanner fileScanner = new Scanner(file)) {
            if (!fileScanner.hasNextInt()) {
                System.out.println("Input error. Invalid size format");
                return;
            }
            int size = fileScanner.nextInt();
            if (size <= 0) {
                System.out.println("Input error. Size <= 0");
                return;
            }
            double[] numbers = new double[size];
            int actualCount = 0;

            for (int i = 0; i < size; i++) {
                while (fileScanner.hasNext()) {
                    if (fileScanner.hasNextDouble()) {
                        numbers[actualCount] = fileScanner.nextDouble();
                        actualCount++;
                        break;
                    } else {
                        fileScanner.next();
                    }
                }
            }

            if (actualCount < size) {
                System.out.println("Input error. Insufficient number of elements");
                return;
            }

            System.out.println(actualCount);
            for (int i = 0; i < actualCount; i++) {
                System.out.println(numbers[i]);
            }
            double min = findMin(numbers);
            double max = findMax(numbers);
            saveResultsToFile(min, max);
            System.out.println("Saving min and max values in file");

        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
        }
    }

    public static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void saveResultsToFile(double min, double max) {
        try (PrintWriter writer = new PrintWriter("result.txt")) {
            writer.println(min);
            writer.println(max);
        } catch (FileNotFoundException e) {
            System.out.println("Error creating result file");
        }
    }
}