package day11.task2.classes;

import day11.task2.interfaces.Healer;

public class Paladin extends Hero implements Healer {

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
    public String toString() {
        return "Paladin{health=" + health + '}';
    }
}
