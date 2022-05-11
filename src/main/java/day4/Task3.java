package day4;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int m = 12;
        int n = 8;
        int[][] numbers = new int[m][n];
        int summ1 = 0;
        int summ2 = 0;
        int line = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Random random = new Random();
                numbers[i][j] = random.nextInt(51);
            }
        }

        for (int number : numbers[0]) {
            summ1 += number;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                summ2 += numbers[i][j];
            }
            if (summ2 >= summ1) {
                line = i;
                summ1 = summ2;
            }
            summ2 = 0;
        }
        System.out.println(line + 1);
    }
}
