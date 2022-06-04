package SeaBattleGUI;

public class Cell {
    //видимость - true, невидимость - false

    protected static final int EMPTY = 0; //пусто
    protected static final int SHIP = 1; //корабль
    protected static final int OREOL = 2; //ореол

    private Ship ship;
    private int condition;
    private boolean visible;

    public Cell() {
        condition = 0;
        visible = true;
    }

    public int getShot(Point point) {
        visible = true;
        if (condition != 1) {
            setCondition(OREOL);
            return Battlefield.MISS;
        } else {
            ship.fire(point);
            if (ship.isAlive()){
                return Battlefield.SHOT;
            } else {
                return Battlefield.KILL;
            }
        }
    }

    public void changeVisible() {
        visible = !visible;
    }

    public void addShip(Ship ship) {
        setCondition(1);
        setShip(ship);
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getCondition() {
        return condition;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isVisible() {
        return visible;
    }
}
