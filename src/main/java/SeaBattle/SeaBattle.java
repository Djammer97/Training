package SeaBattle;

import java.util.*;

public class SeaBattle {
    public static void main(String[] args) {
        //System.out.println("\uD83C\uDF2B\uFE0F"); //туман
        //System.out.println("\uD83D\uDFE6"); // пустая клетка (синий квадрат)
        //System.out.println("\uD83D\uDFE5"); //подбит (красная клетка)
        //System.out.println("\uD83D\uDEE5\uFE0F");//корабль
        //System.out.println("\uD83D\uDFE2");//мимо+ореол (зеленый круг)
        //System.out.println("\u2005"+Character.toString(ch)+"\u00A0"); выражение для цифр
        Battlefield battlefield1 = new Battlefield();
        System.out.print("Введите имя первого игрока: ");
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player(scanner.nextLine(), battlefield1);
        Battlefield battlefield2 = new Battlefield();
        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(scanner.nextLine(), battlefield2);
        while (!player1.getBattlefield().isReady()) {
            fillBattlefield(player1, player2);
        }

        while (!player2.getBattlefield().isReady()) {
            fillBattlefield(player2, player1);
        }

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
        }

        while (activePlayer.getBattlefield().isAlive() && passivePlayer.getBattlefield().isAlive()) {
            try {
                System.out.println("Ход игрока - " + activePlayer.getName());
                System.out.println("\tПоле игрока " + player1.getName() + "\t\t\tПоле игрока " + player2.getName());
                player1.getBattlefield().printBothFields(player2.getBattlefield());
                System.out.println("Введите координаты в формате x,y");
                String string = scanner.nextLine();
                String[] strings = string.split(";");
                if (strings.length != 1) {
                    throw new CoordinateInputException(7); //Проверка на введение првильного количества координат
                }
                int status = passivePlayer.getBattlefield().shot(strings);
                switch (status) {
                    case Battlefield.MISS:
                        Player temp = activePlayer;
                        activePlayer = passivePlayer;
                        passivePlayer = temp;
                        System.out.println("Мимо! Передача хода!");
                        break;
                    case Battlefield.SHOT:
                        System.out.println("Ранил!");
                        break;
                    case Battlefield.KILL:
                        System.out.println("Корабль уничтожен!");
                        break;
                    case Battlefield.ITERATION:
                        System.out.println("Выстрел в эту точку уже производился. Введите другие координаты");
                        break;
                    default:
                        System.out.println("Ошибка. Пропробуй еще раз!");
                }
            } catch (CoordinateInputException e) {
                e.message();
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число");
            }
        }
        if (player1.getBattlefield().isAlive()) {
            System.out.println("Победил игрок " + player1.getName());
        } else {
            System.out.println("Победил игрок " + player2.getName());
        }
        player1.getBattlefield().answer(player2.getBattlefield());
        System.out.println("\tПоле игрока " + player1.getName() + "\t\t\tПоле игрока " + player2.getName());
        player1.getBattlefield().printBothFields(player2.getBattlefield());
    }

    private static void fillBattlefield(Player player1, Player player2) {
        System.out.println();
        System.out.print("Начнем расставлять корабли на поле игрока " + player1.getName());
        System.out.println(". " + player2.getName() + ", не смотри!");
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> words = new HashMap<>();
        words.put(1, "первого");
        words.put(2, "второго");
        words.put(3, "третьего");
        words.put(4, "четвертого");
        while (player1.getBattlefield().getAmountShips4() != Battlefield.AMOUNT_SHIPS_4) {
            try {
                player1.getBattlefield().printField();
                System.out.println("Введи координаты четырехпалубного корабля (формат: x,y;x,y;x,y;x,y)");
                String string = scanner.nextLine();
                String[] strings = string.split(";");
                if (strings.length != 4)
                    throw new CoordinateInputException(7); //Проверка на введение првильного количества координат
                player1.getBattlefield().add(strings);
            } catch (CoordinateInputException e) {
                e.message();
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число");
            }
        }
        while (player1.getBattlefield().getAmountShips3() != Battlefield.AMOUNT_SHIPS_3) {
            try {
                player1.getBattlefield().printField();
                System.out.println("Введи координаты " + words.get(player1.getBattlefield().getAmountShips3() + 1) + " трехпалубного корабля (формат: x,y;x,y;x,y)");
                String string = scanner.nextLine();
                String[] strings = string.split(";");
                if (strings.length != 3) throw new CoordinateInputException(7);
                player1.getBattlefield().add(strings);
            } catch (CoordinateInputException e) {
                e.message();
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число");
            }
        }
        while (player1.getBattlefield().getAmountShips2() != Battlefield.AMOUNT_SHIPS_2) {
            try {
                player1.getBattlefield().printField();
                System.out.println("Введи координаты " + words.get(player1.getBattlefield().getAmountShips2() + 1) + " двухпалубного корабля (формат: x,y;x,y)");
                String string = scanner.nextLine();
                String[] strings = string.split(";");
                if (strings.length != 2) throw new CoordinateInputException(7);
                player1.getBattlefield().add(strings);
            } catch (CoordinateInputException e) {
                e.message();
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число");
            }
        }
        while (player1.getBattlefield().getAmountShips1() != Battlefield.AMOUNT_SHIPS_1) {
            try {
                player1.getBattlefield().printField();
                System.out.println("Введи координаты " + words.get(player1.getBattlefield().getAmountShips1() + 1) + " однопалубного корабля (формат: x,y)");
                String string = scanner.nextLine();
                String[] strings = string.split(";");
                if (strings.length != 1) throw new CoordinateInputException(7);
                player1.getBattlefield().add(strings);
            } catch (CoordinateInputException e) {
                e.message();
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число");
            }
        }
        player1.getBattlefield().printField();
        boolean turn = false;
        System.out.println("Закончить заполнение поля или перезаполнить поле? " +
                "(1 - закончить, 0 - перезаполнить)");
        while (!turn) {
            String choice = scanner.next();
            switch (choice) {
                case "0":
                    player1.resetBattlefield();
                    turn = !turn;
                    break;
                case "1":
                    player1.getBattlefield().changeReady();
                    player1.getBattlefield().hideBattlefield();
                    turn = !turn;
                    break;
                default:
                    System.out.println("Введите 0 для перезаполнения, 1 для окончания заполнения");
            }
        }
    }
}
