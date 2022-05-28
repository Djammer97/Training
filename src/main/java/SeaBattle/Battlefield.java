package SeaBattle;

import java.util.HashSet;
import java.util.Set;

public class Battlefield {
    private static final byte SIZE = 10;
    private static final byte NUMBER = 2;
    protected static final int AMOUNT_SHIPS_1 = 4;
    protected static final int AMOUNT_SHIPS_2 = 3;
    protected static final int AMOUNT_SHIPS_3 = 2;
    protected static final int AMOUNT_SHIPS_4 = 1;
    protected static final int MISS = 0;
    protected static final int SHOT = 1;
    protected static final int KILL = 2;
    protected static final int ITERATION = 3;
    protected static final int MISTAKE = 4;


    private Cell[][] cells;
    private Set<Ship> ships = new HashSet<>();
    private int amountShips1;
    private int amountShips2;
    private int amountShips3;
    private int amountShips4;
    private boolean ready;

    public Battlefield() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
        ready = false;
    }

    public void add(String[] coordinates) {
        try {
            Point[] points = new Point[coordinates.length];
            boolean horizontal = true;
            checkFire(coordinates);

            for (int i = 0; i < coordinates.length; i++) {
                String[] temp = coordinates[i].split(",");
                points[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }

            int min = points[0].getY();
            int max = points[0].getY();

            if (points.length > 1) { //Проверка на введение одинаковых координат
                for (int i = 0; i < points.length - 1; i++) {
                    for (int j = i + 1; j < points.length; j++) {
                        if (points[i].getX() == points[j].getX() && points[i].getY() == points[j].getY()) {
                            throw new CoordinateInputException(4);
                        }
                    }
                }

                int count = 0; //Проверка на введение координат, лежащих не на одной прямой
                for (int i = 0; i < points.length - 1; ) {
                    if (points[i].getX() == points[++i].getX()) {
                        count++;
                    }
                }
                if (count != points.length - 1) {
                    count = 0;
                    for (int i = 0; i < points.length - 1; ) {
                        if (points[i].getY() == points[++i].getY()) {
                            count++;
                            horizontal = false;
                        }
                    }
                }

                if (count != points.length - 1) throw new CoordinateInputException(5);

                if (horizontal) {
                    for (int i = 1; i < points.length; i++) {
                        if (points[i].getY() > max) {
                            max = points[i].getY();
                        } else {
                            if (points[i].getY() < min) {
                                min = points[i].getY();
                            }
                        }
                    }
                } else {
                    max = points[0].getX();
                    min = points[0].getX();
                    for (int i = 1; i < points.length; i++) {
                        if (points[i].getX() > max) {
                            max = points[i].getX();
                        } else {
                            if (points[i].getX() < min) {
                                min = points[i].getX();
                            }
                        }
                    }
                }

                if ((max - min) != (points.length - 1)) { //Проверка на введение цельного корабля
                    throw new CoordinateInputException(6);
                }
            }

            for (int i = 0; i < points.length; i++) { //Проверка на размещение корабля в ореол или на другой корабль
                if (cells[points[i].getX()][points[i].getY()].getCondition() != 0) {
                    throw new CoordinateInputException(8);
                }
            }

            Ship tempShip = new Ship(points);

            switch (points.length) {
                case 4:
                    ships.add(tempShip);
                    amountShips4++;
                    break;
                case 3:
                    ships.add(tempShip);
                    amountShips3++;
                    break;
                case 2:
                    ships.add(tempShip);
                    amountShips2++;
                    break;
                default:
                    ships.add(tempShip);
                    amountShips1++;
            }

            for (Point coordinate : points) {
                cells[coordinate.getX()][coordinate.getY()].addShip(tempShip);
            }

            if (horizontal) {
                tempShip.setUpOreol(Math.max((points[0].getX() - 1), 0));
                tempShip.setDownOreol(Math.min((points[0].getX() + 1), 9));
                tempShip.setLeftOreol(Math.max(min - 1, 0));
                tempShip.setRightOreol(Math.min(max + 1, 9));
            } else {
                tempShip.setUpOreol(Math.max(min - 1, 0));
                tempShip.setDownOreol(Math.min(max + 1, 9));
                tempShip.setLeftOreol(Math.max((points[0].getY() - 1), 0));
                tempShip.setRightOreol(Math.min((points[0].getY() + 1), 9));
            }

            setOreol(points[0]);

        } catch (CoordinateInputException e) {
            e.message();
        }
    }

    public void setOreol(Point point) {
        Ship ship = cells[point.getX()][point.getY()].getShip();
        for (int i = ship.getUpOreol(); i <= ship.getDownOreol(); i++) {
            for (int j = ship.getLeftOreol(); j <= ship.getRightOreol(); j++) {
                if (cells[i][j].getCondition() == Cell.EMPTY) {
                    cells[i][j].setCondition(Cell.OREOL);
                }
                if (ready) {
                    if (!cells[i][j].isVisible()) {
                        cells[i][j].changeVisible();
                    }
                }
            }
        }
    }

    public int shot(String[] coordinate) {
        try {
            checkFire(coordinate);
            String[] temp = coordinate[0].split(",");
            Point point = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            if (cells[point.getX()][point.getY()].isVisible()) {
                return ITERATION;
            }
            if (cells[point.getX()][point.getY()].getShot(point) == KILL) {
                setOreol(point);
            }
            return cells[point.getX()][point.getY()].getShot(point);
        } catch (CoordinateInputException e) {
            e.message();
            return MISTAKE;
        }
    }

    public void hideBattlefield() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].changeVisible();
                if (cells[i][j].getCondition() == Cell.OREOL) {
                    cells[i][j].setCondition(Cell.EMPTY);
                }
            }
        }
    }

    public void printField() {
        System.out.print(" ");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("\u2005" + i + "\u00A0");
        }
        System.out.println();
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i);
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getCondition() == Cell.SHIP) {
                    System.out.print("\uD83D\uDEE5\uFE0F");
                } else {
                    if (cells[i][j].getCondition() == Cell.OREOL) {
                        System.out.print("\uD83D\uDFE2");
                    } else {
                        System.out.print("\uD83D\uDFE6");
                    }
                }
            }
            System.out.println();
        }
    }

    public void printBothFields(Battlefield battlefield) {
        System.out.print(" ");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("\u2005" + i + "\u00A0");
        }
        System.out.print("\t");
        System.out.print(" ");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("\u2005" + i + "\u00A0");
        }
        System.out.println();
        for (int i = 0; i < cells.length; i++) {
            System.out.print(i);
            for (int j = 0; j < cells[i].length; j++) {
                if (!cells[i][j].isVisible()) {
                    System.out.print("\uD83C\uDF2B\uFE0F");
                } else {
                    if (cells[i][j].getCondition() == Cell.SHIP) {
                        if (cells[i][j].getShip().conditionOfShip(new Point(i, j))) {
                            System.out.print("\uD83D\uDEE5\uFE0F");
                        } else {
                            System.out.print("\uD83D\uDFE5");
                        }
                    } else {
                        if (cells[i][j].getCondition() == Cell.EMPTY) {
                            System.out.print("\uD83D\uDFE6");
                        } else {
                            System.out.print("\uD83D\uDFE2");
                        }
                    }
                }
            }
            System.out.print("\t");
            System.out.print(i);
            for (int j = 0; j < cells[i].length; j++) {
                if (!battlefield.getCell(i,j).isVisible()) {
                    System.out.print("\uD83C\uDF2B\uFE0F");
                } else {
                    if (battlefield.getCell(i,j).getCondition() == Cell.SHIP) {
                        if (battlefield.getCell(i,j).getShip().conditionOfShip(new Point(i, j))) {
                            System.out.print("\uD83D\uDEE5\uFE0F");
                        } else {
                            System.out.print("\uD83D\uDFE5");
                        }
                    } else {
                        if (battlefield.getCell(i,j).getCondition() == Cell.EMPTY) {
                            System.out.print("\uD83D\uDFE6");
                        } else {
                            System.out.print("\uD83D\uDFE2");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static void checkFire(String[] coordinates) throws CoordinateInputException {
        Integer[][] strings = new Integer[coordinates.length][NUMBER];
        for (int i = 0; i < coordinates.length; i++) {
            String[] temp = coordinates[i].split(",");
            if (temp.length > NUMBER) { //Проверка на введение большего количества координат в точку
                throw new CoordinateInputException(1);
            }

            if (temp.length < NUMBER) { //Проверка на введение меньшего количества координат в точку
                throw new CoordinateInputException(2);
            }

            for (int j = 0; j < temp.length; j++) {
                strings[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for (Integer[] coordinate : strings) { //Проверка на введение координат вне поля
            if (coordinate[0] < 0 || coordinate[0] > 9 ||
                    coordinate[1] < 0 || coordinate[1] > 9) {
                throw new CoordinateInputException(3);
            }
        }
    }

    public void answer(Battlefield battlefield) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (!cells[i][j].isVisible()) {
                    cells[i][j].changeVisible();
                    if (cells[i][j].getCondition() == Cell.OREOL) {
                        cells[i][j].setCondition(Cell.EMPTY);
                    }
                }
                if (!battlefield.getCell(i,j).isVisible()) {
                    battlefield.getCell(i,j).changeVisible();
                    if (battlefield.getCell(i,j).getCondition() == Cell.OREOL) {
                        battlefield.getCell(i,j).setCondition(Cell.EMPTY);
                    }
                }
            }
        }
    }

    public boolean isAlive() {
        boolean alive = false;
        for (Ship ship : ships) {
            if (ship.isAlive()) {
                alive = true;
            }
        }
        return alive;
    }

    public void changeReady() {
        ready = !ready;
    }

    public int getAmountShips1() {
        return amountShips1;
    }

    public int getAmountShips2() {
        return amountShips2;
    }

    public int getAmountShips3() {
        return amountShips3;
    }

    public int getAmountShips4() {
        return amountShips4;
    }

    public boolean isReady() {
        return ready;
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
