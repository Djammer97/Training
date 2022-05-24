package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237));
    }

    public static int count7(int number) {
        int amount = 0;
        if (number / 10 != 0) {
            amount += count7(number / 10);
            if (number % 10 == 7) {
                return ++amount;
            }
        } else {
            if (number % 10 == 7) {
                amount++;
            }
        }
        return amount;
    }
}
