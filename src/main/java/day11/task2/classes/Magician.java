package day11.task2.classes;

import day11.task2.interfaces.MagicAttack;

public class Magician extends Hero implements MagicAttack {
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
    public String toString() {
        return "Magician{" +
                "health=" + health +
                '}';
    }
}
