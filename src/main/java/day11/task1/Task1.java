package day11.task1;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        Warehouse warehouse1 = new Warehouse();
        Courier courier1 = new Courier(warehouse1);
        Picker picker1 = new Picker(warehouse1);
        System.out.println("Начало работы первого склада");
        System.out.println(warehouse1);
        System.out.println(courier1);
        System.out.println(picker1);
        System.out.println();

        System.out.println("Работа сборщика первого склада");
        businessProcess(picker1);
        System.out.println(warehouse1);
        System.out.println(courier1);
        System.out.println(picker1);

        System.out.println("Работа доставщика первого склада");
        businessProcess(courier1);
        System.out.println(warehouse1);
        System.out.println(courier1);
        System.out.println(picker1);

        Warehouse warehouse2 = new Warehouse();
        Courier courier2 = new Courier(warehouse2);
        Courier courier3 = new Courier(warehouse2);
        Picker picker2 = new Picker(warehouse2);
        System.out.println("Начало работы второго склада");
        System.out.println(warehouse2);
        System.out.println(courier1);
        System.out.println(courier2);
        System.out.println(courier3);
        System.out.println();

        System.out.println("Работа сборщика второго склада");
        businessProcess(courier2);
        System.out.println(warehouse1);
        System.out.println(warehouse2);
        System.out.println(courier1);
        System.out.println(courier2);
        System.out.println(courier3);
    }

    static void businessProcess(Worker worker) {
        for (int i = 0; i < 10000; i++) {
            if (worker.doWork()) {
                worker.bonus();
            }
        }
    }
}
