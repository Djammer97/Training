package SeaBattleGUI;

import javax.swing.*;

public class CoordinateInputException extends Exception {
    private int number;

    public CoordinateInputException(int number) {
        this.number = number;
    }

    public void message() {

        if (number == 5){
            System.out.println("Введенные координаты лежат не на одной прямой");
            JOptionPane.showMessageDialog(null, "Введенные координаты лежат не на одной прямой");
        }

        if (number == 6){
            System.out.println("Введенные координаты лежат не друг за другом");
            JOptionPane.showMessageDialog(null, "Введенные координаты лежат не друг за другом");
        }


        if (number == 8) {
            System.out.println("По указанным координатам нельзя располагать корабль");
            JOptionPane.showMessageDialog(null, "По указанным координатам нельзя располагать корабль");
        }
    }
}
