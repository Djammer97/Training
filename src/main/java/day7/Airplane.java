package day7;

public class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public Airplane(String manufacturer, int year, int length, int weight) {
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        fuel = 0;
    }

    public void info() {
        System.out.printf("Изготовитель: %s, год выпуска: %d, " +
                        "длина: %d, вес: %d, количество топлива в баке: %d\n",
                manufacturer, year, length, weight, fuel);
    }

    public void fillUp(int n) {
        fuel += n;
    }

    public static void compareAirplanes(Airplane firstAirplane, Airplane secondAirplane) {
        if (firstAirplane.length > secondAirplane.length) {
            System.out.println("Первый самолет длиннее");
        } else {
            if (secondAirplane.length > firstAirplane.length) {
                System.out.println("Второй самолет длиннее");
            } else
                System.out.println("Длины самолетов равны");
        }
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public double getFuel() {
        return fuel;
    }
}
