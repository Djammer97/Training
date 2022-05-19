package day11.task1;

import java.util.List;

public class Courier implements Worker {
    private final int wage = 100;
    private final int bonusLimit = 10000;
    private final int bonus = 50000;

    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
        salary = 0;
        isPayed = false;
        this.warehouse = warehouse;
        warehouse.addCourier(this);
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
        warehouse.increaseDeliveredPickedOrders();
        salary += wage;
        return (warehouse.getCountDeliveredOrders() == bonusLimit);
    }

    @Override
    public void bonus() {
        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
        } else {
            if (warehouse.getCountDeliveredOrders() == bonusLimit) {
                List<Courier> couriers = warehouse.getCouriers();
                for (Courier courier : couriers) {
                    courier.giveBonus();
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
