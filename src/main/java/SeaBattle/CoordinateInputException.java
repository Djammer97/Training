package SeaBattle;

public class CoordinateInputException extends Exception {
    private int number;

    public CoordinateInputException(int number) {
        this.number = number;
    }

    public void message() {
        if (number == 1) {
            System.out.println("Попытка ввести больше двух координат в одну точку");
        }

        if (number == 2) {
            System.out.println("Попытка ввести меньше двух координат в одну точку");
        }

        if (number == 3){
            System.out.println("Введенные координаты находятся вне игрового поля");
        }

        if (number == 4){
            System.out.println("Введены повторяющиеся координаты");
        }

        if (number == 5){
            System.out.println("Введенные координаты лежат не на одной прямой");
        }

        if (number == 6){
            System.out.println("Введенные координаты лежат не друг за другом");
        }

        if (number == 7){
            System.out.println("Введено неправильное количество координат");
        }

        if (number == 8) {
            System.out.println("По указанным координатам нельзя располагать корабль");
        }
    }
}
