package day8;

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

    public void setManufacturer(String manufacturer) {
        if (manufacturer.isEmpty())
            System.out.println("Некорректный ввод. Пустая строка");
        else
            this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        if (year < 0)
            System.out.println("Некорректный ввод. Число должно быть больше 0");
        this.year = year;
    }

    public void setLength(int length) {
        if (length < 0)
            System.out.println("Некорректный ввод. Число должо быть больше 0");
        this.length = length;
    }

    public void setWeight(int weight) {
        if (weight < 0)
            System.out.println("Некорректный ввод. Число должно быть больше 0");
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        if (fuel < 0)
            System.out.println("Некорреткный ввод. Число должно быть быльше 0");
        this.fuel = fuel;
    }

    public double getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Изготовитель: ").append(manufacturer).append(", год выпуска: ").append(year);
        string.append(", длина: ").append(length).append(", вес: ").append(weight).append(", количество топлива в баке: ").append(fuel);
        return string.toString();
    }
}
