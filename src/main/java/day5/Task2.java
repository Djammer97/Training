package day5;


import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите модель мотоцикла: ");
        String model = scanner.nextLine();
        System.out.print("Введите цвет мотоцикла: ");
        String colour = scanner.nextLine();
        System.out.print("Введите год выпуска мотоцикла: ");
        int year = scanner.nextInt();
        Motorbike motorbike = new Motorbike(model, colour, year);
        System.out.println();
        System.out.println("Заданы следующие параметры: ");
        System.out.printf("Модель мотоцикла - %s\n", motorbike.getModel());
        System.out.printf("Цвет мотоцикла - %s\n", motorbike.getColour());
        System.out.printf("Год выпуска иотоцикла - %d\n", motorbike.getYear());
    }
}
