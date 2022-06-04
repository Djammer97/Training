package SeaBattleGUI;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SeaBattle {
    public static void main(String[] args) {
        Battlefield battlefield1 = new Battlefield();
        Player player1 = new Player(JOptionPane.showInputDialog("Имя первого игрока"), battlefield1);
        Battlefield battlefield2 = new Battlefield();
        Player player2 = new Player(JOptionPane.showInputDialog("Имя второго игрока"), battlefield2);
        while (!player1.getBattlefield().isReady()) {
            fillBattlefield(player1, player2);
        }

        while (!player2.getBattlefield().isReady()) {
            fillBattlefield(player2, player1);
        }

        ButtonStylesPlay buttonStylesPlay = new ButtonStylesPlay(player1, player2);

        Random random = new Random();
        int turn = random.nextInt(2);
        Player activePlayer;
        Player passivePlayer;
        if (turn == 0) {
            activePlayer = player1;
            passivePlayer = player2;
        } else {
            activePlayer = player2;
            passivePlayer = player1;
            buttonStylesPlay.changeTurn();
            buttonStylesPlay.reBuild();
        }

        while (activePlayer.getBattlefield().isAlive() && passivePlayer.getBattlefield().isAlive()) {
            if (!Battlefield.insertShip.toString().equals("")) {
                int status = passivePlayer.getBattlefield().shot(Battlefield.insertShip.toString().split(";"));
                Battlefield.insertShip = new StringBuilder("");
                switch (status) {
                    case Battlefield.MISS:
                        Player temp = activePlayer;
                        activePlayer = passivePlayer;
                        passivePlayer = temp;
                        JOptionPane.showMessageDialog(null, "Мимо! Передача хода!");
                        buttonStylesPlay.changeTurn();
                        buttonStylesPlay.reBuild();
                        break;
                    case Battlefield.ITERATION:
                        JOptionPane.showMessageDialog(null, "Выстрел в эту точку уже производился. Введите другие координаты");
                        break;
                    default:
                        buttonStylesPlay.reBuild();;
                }
            }
        }
        if (player1.getBattlefield().isAlive()) {
            JOptionPane.showMessageDialog(null, "Победил игрок " + player1.getName());
        } else {
            JOptionPane.showMessageDialog(null, "Победил игрок " + player2.getName());
        }
        player1.getBattlefield().answer(player2.getBattlefield());
        buttonStylesPlay.reBuild();
    }

    private static void fillBattlefield(Player player1, Player player2) {
        ButtonStylesInsert buttonStylesInsert = new ButtonStylesInsert(player1);
        JOptionPane.showMessageDialog(null, "Начнем расставлять корабли на поле игрока " + player1.getName());
        JOptionPane.showMessageDialog(null, player2.getName() + ", не смотри!");
        Map<Integer, String> words = new HashMap<>();
        words.put(1, "первого");
        words.put(2, "второго");
        words.put(3, "третьего");
        words.put(4, "четвертого");
        String[] strings = new String[0];
        String string;
        JOptionPane.showMessageDialog(null, "Введи координаты четырехпалубного корабля");
        while (player1.getBattlefield().getAmountShips4() != Battlefield.AMOUNT_SHIPS_4) {
            string = Battlefield.insertShip.toString();
            strings = string.split(";");
            if (strings.length == 4) {
                player1.getBattlefield().add(strings);
                Battlefield.insertShip = new StringBuilder("");
                buttonStylesInsert.reBuild();
            }
        }
        JOptionPane.showMessageDialog(null, "Введи координаты двух трехпалубных кораблей");
        while (player1.getBattlefield().getAmountShips3() != Battlefield.AMOUNT_SHIPS_3) {
            string = Battlefield.insertShip.toString();
            strings = string.split(";");
            if (strings.length == 3) {
                player1.getBattlefield().add(strings);
                Battlefield.insertShip = new StringBuilder("");
                buttonStylesInsert.reBuild();
            }

        }
        JOptionPane.showMessageDialog(null, "Введи координаты трех двухпалубных кораблей");
        while (player1.getBattlefield().getAmountShips2() != Battlefield.AMOUNT_SHIPS_2) {
            string = Battlefield.insertShip.toString();
            strings = string.split(";");
            if (strings.length == 2) {
                player1.getBattlefield().add(strings);
                Battlefield.insertShip = new StringBuilder("");
                buttonStylesInsert.reBuild();
            }

        }

        JOptionPane.showMessageDialog(null, "Введи координаты четырех однопалубных кораблей");
        while (player1.getBattlefield().getAmountShips1() != Battlefield.AMOUNT_SHIPS_1) {
            string = Battlefield.insertShip.toString();
            strings = string.split(";");
            if (strings.length == 1 && !string.equals("")) {
                player1.getBattlefield().add(strings);
                Battlefield.insertShip = new StringBuilder("");
                buttonStylesInsert.reBuild();
            }

        }
        boolean turn = false;

        while (!turn) {
            Object[] options = {"Перезаписать",
                    "Закончить"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Закончить заполнение поля или перезаполнить поле?",
                    "Закончить",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            switch (choice) {
                case 0:
                    player1.resetBattlefield();
                    turn = !turn;
                    break;
                case 1:
                    player1.getBattlefield().changeReady();
                    player1.getBattlefield().hideBattlefield();
                    turn = !turn;
                    break;
            }
        }
        buttonStylesInsert.dispose();
    }
}
