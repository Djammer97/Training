package day11.task1;

import java.util.List;

public class Picker implements Worker {
    private final int wage = 80;
    private final int bonusLimit = 10000;
    private final int bonus = 70000;

    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        salary = 0;
        isPayed = false;
        this.warehouse = warehouse;
        warehouse.addPicker(this);
    }

    public int getSalary() {
        return salary;
    }

    public boolean getIsPayed() {
        return isPayed;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Override
    public String toString() {
        if (getIsPayed()) {
            return "Заработная плата сотрудника: " +
                    salary + "\nБонус выплачен\n";
        } else {
            return "Заработная плата сотрудника: " +
                    salary + "\nБонус не выплачен\n";
        }
    }

    @Override
    public boolean doWork() {
        warehouse.increaseCountPickedOrders();
        salary += wage;
        return (warehouse.getCountPickedOrders() == bonusLimit);
    }

    @Override
    public void bonus() {
        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
        } else {
            if (warehouse.getCountPickedOrders() == bonusLimit) {
                List<Picker> pickers = warehouse.getPickers();
                for (Picker picker : pickers) {
                    picker.giveBonus();
                }
            } else {
                System.out.println("Бонус пока не доступен");
            }
        }
    }

    public void giveBonus() {
        salary += bonus;
        isPayed = true;
    }
}
