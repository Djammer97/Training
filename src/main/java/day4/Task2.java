package day4;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        int amount0 = 0;
        int summ0 = 0;

        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(10001);
            if (numbers[i] % 10 == 0) {
                amount0++;
                summ0 += numbers[i];
            }
        }

        int max = numbers[0];
        int min = numbers[0];

        for (int number : numbers) {
            if (max < number) max = number;
            else if (min > number) min = number;
        }


        System.out.printf("Наибольший элемент массива: %d\n", max);
        System.out.printf("Наименьший элемент массива: %d\n", min);
        System.out.printf("Элементов, оканчивающихся на 0: %d\n", amount0);
        System.out.printf("Сумма элементов, оканчивающихся на 0: %d\n", summ0);
    }
}
