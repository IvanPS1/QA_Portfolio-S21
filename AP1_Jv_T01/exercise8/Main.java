package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = inputSize(scanner);
        if (size <= 0) {
            return;
        }
        List<String> strings = inputStrings(scanner, size);
        String substring = scanner.next();
        List<String> filteredStrings = filterStringsBySubstring(strings, substring);
        printFilteredResult(filteredStrings);
        scanner.close();
    }
    public static int inputSize(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }
        int size = scanner.nextInt();
        scanner.nextLine();

        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
        }
        return size;
    }
    public static List<String> inputStrings(Scanner scanner, int size) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            strings.add(line);
        }
        return strings;
    }
    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();

        for (String str : strings) {
            if (containsSubstring(str, substring)) {
                result.add(str);
            }
        }
        return result;
    }
    public static boolean containsSubstring(String str, String substring) {
        if (substring.isEmpty()) {
            return true;
        }
        for (int i = 0; i <= str.length() - substring.length(); i++) {
            boolean found = true;

            for (int j = 0; j < substring.length(); j++) {
                if (str.charAt(i + j) != substring.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return true;
            }
        }
        return false;
    }
    public static void printFilteredResult(List<String> filteredStrings) {
        for (int i = 0; i < filteredStrings.size(); i++) {
            System.out.print(filteredStrings.get(i));
            if (i < filteredStrings.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}