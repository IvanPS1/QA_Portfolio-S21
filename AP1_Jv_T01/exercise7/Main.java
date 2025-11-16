package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checkSequenceOrder(scanner);
        scanner.close();
    }
    public static void checkSequenceOrder(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Input error");
            return;
        }
        int previousNumber = scanner.nextInt();
        int count = 1;
        int currentNumber;
        int breakingNumber = 0;
        boolean isOrdered = true;
        while (scanner.hasNextInt()) {
            currentNumber = scanner.nextInt();
            count++;
            if (currentNumber <= previousNumber) {
                isOrdered = false;
                breakingNumber = currentNumber;
                break;
            }
            previousNumber = currentNumber;
        }
        if (count == 1) {
            System.out.println("The sequence is ordered in ascending order");
        } else if (isOrdered) {
            System.out.println("The sequence is ordered in ascending order");
        } else {
            System.out.println("The sequence is not ordered from the ordinal number of the number " + breakingNumber);
        }
        if (scanner.hasNext()) {
            scanner.next();
        }
    }
}