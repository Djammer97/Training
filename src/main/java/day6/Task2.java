package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplane=new Airplane("Airbus", 1950, 20000, 68000);
        airplane.info();
        airplane.setYear(2002);
        airplane.setLength(31000);
        airplane.fillUp(10000);
        airplane.info();
        airplane.fillUp(12000);
        airplane.info();
    }
}
