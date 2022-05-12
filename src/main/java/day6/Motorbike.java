package day6;

public class Motorbike {
    private String model;
    private String colour;
    private int year;

    public Motorbike(String model, String colour, int year) {
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public int yearDifference(int inputYear) {
        if (inputYear > year)
            return (inputYear - year);
        else return (year - inputYear);
    }
}