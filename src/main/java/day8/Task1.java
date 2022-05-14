package day8;

public class Task1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String string1 = "0";
        for (int i = 1; i <= 20000; i++)
            string1 = string1 + " " + i;
        long stopTime = System.currentTimeMillis();
        System.out.println(string1);
        System.out.println();
        System.out.println("Время при конкатенации: " + (stopTime - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder string2 = new StringBuilder("0");
        for (int i = 0; i <= 20000; i++)
            string2.append(" ").append(i);
        stopTime = System.currentTimeMillis();
        System.out.println();
        System.out.println(string2);
        System.out.println();
        System.out.println("Время при StringBuilder: " + (stopTime - startTime));
    }
}
