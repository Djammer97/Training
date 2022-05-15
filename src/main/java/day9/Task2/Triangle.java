package day9.Task2;

import static java.lang.Math.sqrt;

public class Triangle extends Figure {
    private double lineA;
    private double lineB;
    private double lineC;

    public Triangle(double lineA, double lineB, double lineC, String color) {
        super(color);
        this.lineA = lineA;
        this.lineB = lineB;
        this.lineC = lineC;
    }

    @Override
    public double area() {
        return sqrt((perimeter() / 2 - lineC) * (perimeter() / 2 - lineB) * (perimeter() / 2 - lineA) * perimeter() / 2);
    }

    @Override
    public double perimeter() {
        return lineA + lineB + lineC;
    }
}
