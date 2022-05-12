package day5;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите модель машины: ");
        car.setModel(scanner.nextLine());
        System.out.print("Введите цвет машины: ");
        car.setColour(scanner.nextLine());
        System.out.print("Введите год выпуска машины: ");
        car.setYear(scanner.nextInt());
        System.out.println();
        System.out.println("Заданы следующие параметры: ");
        System.out.printf("Модель машины - %s\n", car.getModel());
        System.out.printf("Цвет машины - %s\n", car.getColour());
        System.out.printf("Год выпуска машины - %d\n", car.getYear());
    }
}
