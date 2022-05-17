package day11.task2;

public class Magician extends Hero implements PhysAttack, MagicAttack {
    private int magicAtt;

    public Magician(){
        physDef = 0;
        magicDef = 80;
        physAtt = 5;
        magicAtt = 20;
    }

    @Override
    public void magicalAttack(Hero hero) {
        hero.getDamage(magicAtt, "magic");
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.getDamage(physAtt, "physical");
    }

    @Override
    public String toString() {
        return "Magician{" +
                "health=" + health +
                '}';
    }
}
