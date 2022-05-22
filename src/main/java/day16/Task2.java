package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        final int sizeFile1 = 1000;
        final int amountForFile2 = 20;
        final int maxRandom = 101;

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        PrintWriter printWriterFile1 = null;
        try {
            printWriterFile1 = new PrintWriter(file1);
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла file1");
        }

        PrintWriter printWriterFile2 = null;
        try {
            printWriterFile2 = new PrintWriter(file2);
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла file2");
        }

        Random random = new Random();
        for (int i = 0; i < sizeFile1; i++) {
            printWriterFile1.print(random.nextInt(maxRandom) + " ");
        }
        printWriterFile1.close();

        Scanner scanner = null;
        try {
            scanner = new Scanner(file1);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл с целыми числами");
        }

        for (int i = 0; i < sizeFile1; i += amountForFile2) {
            int summ = 0;
            for (int j = 0; j < amountForFile2; j++) {
                summ += scanner.nextInt();
            }
            printWriterFile2.print((double) summ / amountForFile2 + " ");
        }
        scanner.close();
        printWriterFile2.close();
        printResult(file2);
    }

    public static void printResult(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Не найден исходный файл");
        }

        double summ = 0;
        while (scanner.hasNext()) {
            summ += Double.parseDouble(scanner.next());
        }
        scanner.close();
        System.out.println((int) summ);
    }
}
