package day4;

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int amount = 100;
        int[] numbers = new int[amount];
        int quantity = 3; //Количество чисел, который будут суммироваться
        int summ = 0;

        for (int i = 0; i < amount; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(10001);
        }

        for (int i = 0; i < quantity; i++) {
            summ += numbers[i];
        }

        int number = 0;

        for (int i = quantity; i < amount; i++) {
            int temp = 0;

            for (int j = i - quantity + 1; j <= i; j++) {
                temp += numbers[j];
            }

            if (temp > summ) {
                summ = temp;
                number = i - quantity + 1;
            }
        }

        System.out.println(summ);
        System.out.println(number);
    }
}
