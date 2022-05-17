package day11.task2;

import java.util.Objects;

public abstract class Hero {
    protected int health;
    protected int physDef;
    protected int magicDef;
    protected int physAtt;

    public Hero() {
        health = 100;
    }

    protected void getDamage(int damage, String type) {
        if (Objects.equals(type, "physical")) {
            damage = damage * (100 - physDef) / 100;
        } else {
            damage = damage * (100 - magicDef) / 100;
        }
        if (damage > health) {
            health = 0;
        } else {
            health -= damage;
        }
    }

    protected void getHealed(int heal) {
        if ((health + heal) > 100) {
            health = 100;
        } else {
            health += heal;
        }
    }
}
