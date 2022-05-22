package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Numbers");
        printResult(file);
    }

    public static void printResult(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден исходный файл");
        }

        int amount = 0;
        int summ = 0;

        while (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            summ += temp;
            amount++;
        }

        scanner.close();
        double avg = (double) summ / amount;

        System.out.print(avg);
        System.out.printf(" --> %.3f", avg);
    }
}

