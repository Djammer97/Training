package day11.task2;

public class Paladin extends Hero implements Healer, PhysAttack {

    public Paladin() {
        physDef = 50;
        magicDef = 20;
        physAtt = 15;
    }

    @Override
    public void healHimself() {
        getHealed(25);
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.getHealed(10);
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.getDamage(15, "physical");
    }

    @Override
    public String toString() {
        return "Paladin{health=" + health + '}';
    }
}
