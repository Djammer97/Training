package day11.task2;

public class Warrior extends Hero implements PhysAttack {

    public Warrior() {
        physDef = 80;
        magicDef = 0;
        physAtt = 30;
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.getDamage(physAtt, "physical");
    }

    @Override
    public String toString() {
        return "Warrior{health=" + health + '}';
    }
}
