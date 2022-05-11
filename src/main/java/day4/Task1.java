package day4;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        int countMore8 = 0;
        int count1 = 0;
        int countEven = 0;
        int countNotEven = 0;
        int summ = 0;

        Random random = new Random();

        for (int number : numbers) {
            number = random.nextInt(11);
            System.out.printf("%d ", number);
            summ += number;

            if (number % 2 == 0) countEven++;
            else countNotEven++;

            if (number > 8) countMore8++;
            else if (number == 1) count1++;
        }

        System.out.println();
        System.out.printf("Длина массива: %d\n", numbers.length);
        System.out.printf("Количество чисел больше 8: %d\n", countMore8);
        System.out.printf("Количество чисел равных 1: %d\n", count1);
        System.out.printf("Количество четных чисел: %d\n", countEven);
        System.out.printf("Количество нечетных чисел: %d\n", countNotEven);
        System.out.printf("Сумма всех элементов массива: %d\n", summ);
    }
}
