package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        try {
            String name = "C:" + File.separator + "JavaMarathon2021" + File.separator + "src" + File.separator +
                    "main" + File.separator + "resources" + File.separator + "taxi_cars.txt";
            Map<Integer, Point> cars = new HashMap<>();
            File file = new File(name);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                cars.put(Integer.parseInt(scanner.next()), new Point(Integer.parseInt(scanner.next()), Integer.parseInt(scanner.next())));
            }
            System.out.println("Введите координаты первой точки:");
            Scanner scannerConsole = new Scanner(System.in);
            Point point1 = pointIn(scannerConsole);
            System.out.println("Введите координаты второй точки:");
            Point point2 = pointIn(scannerConsole);
            if (point1.equals(point2)) {
                throw new Exception();
            }
            int amount=0;
            Set<Integer> id = new HashSet<>();
            for (Map.Entry<Integer, Point> car : cars.entrySet()) {
                if ((car.getValue().getX() < point1.getX() && car.getValue().getX() > point2.getX()) ||
                        (car.getValue().getX() > point1.getX() && car.getValue().getX() < point2.getX())) {
                    if ((car.getValue().getY() < point1.getY() && car.getValue().getY() > point2.getY()) ||
                            (car.getValue().getY() > point1.getY() && car.getValue().getY() < point2.getY())) {
                        amount++;
                        id.add(car.getKey());
                    }
                }
            }
            System.out.println(amount);
            System.out.println(id);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не неайден");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static Point pointIn(Scanner scanner) throws Exception {
        int x;
        System.out.print("x: ");
        x = scanner.nextInt();
        if (x < 0 || x > 99) {
            throw new Exception();
        }
        int y;
        System.out.print("y: ");
        y = scanner.nextInt();
        if (y < 0 || y > 99) {
            throw new Exception();
        }
        return new Point(x, y);
    }
}

