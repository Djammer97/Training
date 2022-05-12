package day5;

public class Car {
    private String model;
    private String colour;
    private int year;

    public void setModel(String model) {
        if (model.isEmpty())
            System.out.println("Некорректный ввод. Введена пустая строка");
        else this.model = model;
    }

    public void setColour(String colour) {
        if (colour.isEmpty())
            System.out.println("Некорректный ввод. Введена пустая строка");
        else this.colour = colour;
    }

    public void setYear(int year) {
        if (year < 0)
            System.out.println("Некорректный ввод. Число должно быть больше нуля");
        else this.year = year;
    }

    public String getModel(){
        return model;
    }

    public String getColour(){
        return colour;
    }

    public int getYear(){
        return year;
    }
}
