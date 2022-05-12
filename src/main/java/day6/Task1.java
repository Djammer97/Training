package day6;

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
        car.info();
        System.out.printf("Модель - %s\n", car.getModel());
        System.out.printf("Цвет - %s\n", car.getColour());
        System.out.printf("Год выпуска - %d\n", car.getYear());
        System.out.printf("Разница с %d годом - %d\n", car.getYear()-10,car.yearDifference(car.getYear() - 10));
        System.out.printf("Разница с %d годом - %d\n", car.getYear()+10,car.yearDifference(car.getYear() + 10));
    }
}
