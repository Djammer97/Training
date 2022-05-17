package day11.task1;

import java.util.ArrayList;

public class Warehouse {
    private int countPickedOrders;
    private int countDeliveredOrders;
    private ArrayList<Courier> couriers = new ArrayList<>();
    private ArrayList<Picker> pickers = new ArrayList<>();

    public int getCountPickedOrders() {
        return countPickedOrders;
    }

    public int getCountDeliveredOrders() {
        return countDeliveredOrders;
    }

    public ArrayList<Courier> getCouriers() {
        return couriers;
    }

    public ArrayList<Picker> getPickers() {
        return pickers;
    }

    public void increaseCountPickedOrders() {
        countPickedOrders++;
    }

    public void increaseDeliveredPickedOrders() {
        countDeliveredOrders++;
    }

    @Override
    public String toString() {
        return "Количество собранных заказов: "
                + countPickedOrders
                + "\nКоличество доставленных заказов: "
                + countDeliveredOrders + "\n";
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public void addPicker(Picker picker) {
        pickers.add(picker);
    }
}
