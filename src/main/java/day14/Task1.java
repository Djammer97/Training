package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("Numbers");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        List<Integer> numbers = new ArrayList<>();
        final int amount = 10;
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] lines = temp.split(" ");
            for (String line : lines) {
                numbers.add(Integer.parseInt(line));

                if (numbers.size() > amount) try {
                    throw new DataFormatException();
                } catch (DataFormatException e) {
                    System.out.println("Некорректный входной файл");
                }

            }
        }
        scanner.close();

        if (numbers.size() < amount) try {
            throw new DataFormatException();
        } catch (DataFormatException e) {
            System.out.println("Некорректный входной файл");
        }

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
