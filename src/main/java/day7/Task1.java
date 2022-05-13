package day7;

import static day7.Airplane.compareAirplanes;

public class Task1 {
    public static void main(String[] args) {
        Airplane firstAirplane = new Airplane("Boeing",1993,63700, 139225);
        Airplane secondAirplane = new Airplane("Airbus", 2013, 60540, 248000);
        compareAirplanes(firstAirplane, secondAirplane);
        System.out.println();
        compareAirplanes(secondAirplane, firstAirplane);
    }
}