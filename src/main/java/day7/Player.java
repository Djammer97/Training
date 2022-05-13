package day7;

public class Player {
    private static final int MAX_STAMINA = 100;
    private static final int MIN_STAMINA = 0;
    private int stamina;
    private static int countPlayers;

    public Player(int stamina) {
        this.stamina = stamina;
        if (countPlayers < 6)
            countPlayers++;
    }

    public int getStamina() {
        return stamina;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public void run() {
        if (stamina > MIN_STAMINA) {
            stamina--;
            if (stamina == MIN_STAMINA)
                countPlayers--;
        }
        if (stamina == MIN_STAMINA)
            System.out.println("Игроку нужен отдых. Вне игры.");
    }

    public static void info() {
        switch (countPlayers) {
            case 0:
            case 1:
                System.out.printf("Команды неполные. На поле еще есть %d свободных мест\n", (6 - countPlayers));
                break;
            case 5:
                System.out.println("Команды неполные. На поле еще есть 1 свободное место");
                break;
            case 6:
                System.out.println("На поле нет свободных мест");
                break;
            default:
                System.out.printf("Команды неполные. На поле еще есть %d свободных места\n", (6 - countPlayers));
        }
    }
}
