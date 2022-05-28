package SeaBattle;

public class Player {
    private String name;
    private Battlefield battlefield;

    public Player(String name, Battlefield battlefield) {
        this.name = name;
        this.battlefield = battlefield;
    }

    public String getName(){
        return name;
    }

    public Battlefield getBattlefield(){
        return battlefield;
    }

    public void resetBattlefield(){
        battlefield = new Battlefield();
    }
}
