package day9.Task2;

import java.util.Objects;

public class TestFigures {
    public static void main(String[] args) {
        Figure[] figures = {
                new Triangle(10, 10, 10, "Red"),
                new Triangle(10, 20, 30, "Green"),
                new Triangle(10, 20, 15, "Red"),
                new Rectangle(5, 10, "Red"),
                new Rectangle(40, 15, "Orange"),
                new Circle(4, "Red"),
                new Circle(10, "Red"),
                new Circle(5, "Blue")
        };
        System.out.println("Периметр всех красных фигур: " + calculateRedPerimeter(figures));
        System.out.println("Площадь всех красных фигур: " + calculateRedArea(figures));
    }

    public static double calculateRedPerimeter(Figure[] figures) {
        double summPerimeter = 0;
        for (Figure figure : figures) {
            if (Objects.equals(figure.getColor(), "Red")) {
                summPerimeter += figure.perimeter();
            }
        }
        return summPerimeter;
    }

    public static double calculateRedArea(Figure[] figures) {
        double summArea = 0;
        for (Figure figure : figures) {
            if (Objects.equals(figure.getColor(), "Red")) {
                summArea += figure.area();
            }
        }
        return summArea;
    }
}
