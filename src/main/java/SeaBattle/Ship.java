package SeaBattle;

import java.util.HashMap;
import java.util.Map;

public class Ship {
    Map<Point, Boolean> coordinates = new HashMap<>();
    private int leftOreol;
    private int rightOreol;
    private int downOreol;
    private int upOreol;

    public Ship(Point[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            this.coordinates.put(new Point(coordinates[i].getX(), coordinates[i].getY()), true);
        }
    }

    public void fire(Point point) {
        Point temp = null;
        for (Map.Entry<Point, Boolean> coordinate : coordinates.entrySet()) {
            if (coordinate.getKey().getX() == point.getX() && coordinate.getKey().getY() == point.getY()) {
                temp = coordinate.getKey();
            }
        }
        coordinates.replace(temp, false);
    }

    public boolean isAlive() {
        boolean alive = false;
        for (Map.Entry<Point, Boolean> coordinate : coordinates.entrySet()) {
            if (coordinate.getValue()) {
                alive = true;
            }
        }
        return alive;
    }

    public boolean conditionOfShip(Point point) {
        Point temp = null;
        for (Map.Entry<Point, Boolean> coordinate : coordinates.entrySet()) {
            if (coordinate.getKey().getX() == point.getX() && coordinate.getKey().getY() == point.getY()) {
                temp = coordinate.getKey();
            }
        }
        return coordinates.get(temp);
    }

    public int getLeftOreol() {
        return leftOreol;
    }

    public void setLeftOreol(int leftOreol) {
        this.leftOreol = leftOreol;
    }

    public int getRightOreol() {
        return rightOreol;
    }

    public void setRightOreol(int rightOreol) {
        this.rightOreol = rightOreol;
    }

    public int getDownOreol() {
        return downOreol;
    }

    public void setDownOreol(int downOreol) {
        this.downOreol = downOreol;
    }

    public int getUpOreol() {
        return upOreol;
    }

    public void setUpOreol(int upOreol) {
        this.upOreol = upOreol;
    }
}
