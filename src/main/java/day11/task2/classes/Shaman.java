package day11.task2.classes;

import day11.task2.interfaces.Healer;
import day11.task2.interfaces.MagicAttack;

public class Shaman extends Hero implements Healer, MagicAttack {
    private int magicAtt;

    public Shaman(){
        physDef = 20;
        magicDef = 20;
        physAtt = 10;
        magicAtt = 15;
    }

    @Override
    public void healHimself() {
        getHealed(50);
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.getHealed(30);
    }

    @Override
    public void magicalAttack(Hero hero) {
        hero.getDamage(15, "magic");
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + health +
                '}';
    }
}
