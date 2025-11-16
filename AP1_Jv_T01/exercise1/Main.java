package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int seconds = inputSeconds();
        int hours = calculateHours(seconds);
        int minutes = calculateMinutes(seconds);
        int remainingSeconds = calculateSeconds(seconds);
        outputResult(hours, minutes, remainingSeconds);
    }
    public static int inputSeconds() {
        Scanner scanner = new Scanner(System.in);
        int seconds = -1;

        while (seconds < 0) {
            if (!scanner.hasNextInt()) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
                continue;
            }
            seconds = scanner.nextInt();

            if (seconds < 0) {
                System.out.println("Incorrect time");
            }
        }
        return seconds;
    }
    public static int calculateHours(int totalSeconds) {
        return totalSeconds / 3600;
    }
    public static int calculateMinutes(int totalSeconds) {
        return (totalSeconds % 3600) / 60;
    }
    public static int calculateSeconds(int totalSeconds) {
        return totalSeconds % 60;
    }
    public static void outputResult(int hours, int minutes, int seconds) {
        System.out.println(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}