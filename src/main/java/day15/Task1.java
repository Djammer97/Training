package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String OldPath = "C:" + File.separator + "JavaMarathon2021" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "shoes.csv";
        File oldFile = new File(OldPath);

        String newPath = "C:" + File.separator + "JavaMarathon2021" + File.separator +
                "src" + File.separator + "main" + File.separator + "resources" + File.separator + "missing_shoes.txt";
        File resultFile = new File(newPath);

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(resultFile);
        } catch (FileNotFoundException e) {
            System.out.println("Итоговый файл не найден");
        }

        Scanner scanner = null;

        if (oldFile.length() == 0) try {    //Проверка исходного файла на пустоту
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Исходный файл - пустой");
        }
        else {
            try {
                scanner = new Scanner(oldFile);
            } catch (
                    FileNotFoundException e) {
                System.out.println("Исходный файл не найден");
            }
        }

        if (scanner != null && printWriter != null) {
            while (scanner.hasNextLine()) {
                String tempLine = scanner.nextLine();

                try {
                    String[] shoes = tempLine.split(";");

                    if (shoes.length != 3) { //Проверка, что в файле 3 колонки
                        throw new Exception();
                    }

                    if (Integer.parseInt(shoes[1]) <= 0) { //Проверка, что вторая колонка - размер (положительное число)
                        throw new Exception();
                    }

                    if (Integer.parseInt(shoes[2]) == 0) {
                        printWriter.println(shoes[0] + ", " + shoes[1] + ", " + shoes[2]);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка формата данных");
                    break;
                }

            }
            scanner.close();
            printWriter.close();
        }
    }
}
