package day11.task1;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private int countPickedOrders;
    private int countDeliveredOrders;
    private List<Courier> couriers = new ArrayList<>();
    private List<Picker> pickers = new ArrayList<>();

    public int getCountPickedOrders() {
        return countPickedOrders;
    }

    public int getCountDeliveredOrders() {
        return countDeliveredOrders;
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public List<Picker> getPickers() {
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
