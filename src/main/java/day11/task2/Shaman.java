package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack{
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
    public void physicalAttack(Hero hero) {
        hero.getDamage(10, "physical");
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + health +
                '}';
    }
}
