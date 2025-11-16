package org.example;
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static class TrianglePerimeter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
            double x1, y1, x2, y2, x3, y3;
            while (true) {
                try {
                    x1 = scanner.nextDouble();
                    y1 = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.nextLine();
                }
            }
            while (true) {
                try {
                    x2 = scanner.nextDouble();
                    y2 = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.nextLine();
                }
            }

            while (true) {
                try {
                    x3 = scanner.nextDouble();
                    y3 = scanner.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Could not parse a number. Please, try again");
                    scanner.nextLine();
                }
            }

            double a = calculateDistance(x1, y1, x2, y2);
            double b = calculateDistance(x2, y2, x3, y3);
            double c = calculateDistance(x1, y1, x3, y3);

            if (isTriangle(a, b, c)) {
                double perimeter = a + b + c;
                System.out.printf("%.3f", perimeter);
            } else {
                System.out.println("It's not a triangle");
            }
            scanner.close();
        }

        public static double calculateDistance(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        public static boolean isTriangle(double a, double b, double c) {
            return (a + b > c) && (a + c > b) && (b + c > a);
        }
    }
}