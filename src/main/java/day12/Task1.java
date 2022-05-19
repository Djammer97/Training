package day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Audi");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Honda");
        cars.add("Hyundai");
        System.out.println(cars);
        cars.add(2,"Kia");
        cars.remove(0);
        System.out.println(cars);
    }
}
