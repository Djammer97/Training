package day5;

public class Motorbike {
    private String model;
    private String colour;
    private int year;

    public Motorbike(String model, String colour, int year){
        this.model=model;
        this.colour=colour;
        this.year=year;
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