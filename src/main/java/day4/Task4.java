package day4;

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int amount = 100;
        int[] numbers = new int[amount];

        for (int i = 0; i < amount; i++) {
            Random random = new Random();
            numbers[i] = random.nextInt(10001);
        }

        int summ = numbers[0] + numbers[1] + numbers[2];
        int number = 0;

        for (int i = 3; i < amount; i++) {
            int temp=numbers[i - 2] + numbers[i - 1] + numbers[i];
            if (temp > summ) {
                summ = temp;
                number = i - 2;
            }
        }

        System.out.println(summ);
        System.out.println(number);
    }
}
