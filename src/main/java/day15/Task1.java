package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            String OldPath = "C:" + File.separator + "JavaMarathon2021" + File.separator +
                    "src" + File.separator + "main" + File.separator + "resources" + File.separator + "shoes.csv";
            File oldFile = new File(OldPath);

            String newPath = "C:" + File.separator + "JavaMarathon2021" + File.separator +
                    "src" + File.separator + "main" + File.separator + "resources" + File.separator + "missing_shoes.txt";
            File resultFile = new File(newPath);

            PrintWriter printWriter = new PrintWriter(resultFile);

            if (oldFile.length() == 0) throw new Exception();

            Scanner scanner = new Scanner(oldFile);
            while (scanner.hasNextLine()) {
                String tempLine = scanner.nextLine();

                String[] shoes = tempLine.split(";");

                if (shoes.length != 3) throw new Exception();

                if (Integer.parseInt(shoes[1]) <= 0) throw new Exception();

                if (Integer.parseInt(shoes[2]) == 0) {
                    printWriter.println(shoes[0] + ", " + shoes[1] + ", " + shoes[2]);
                }

                scanner.close();
                printWriter.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception ex) {
            System.out.println("Ошибка исходного файла");
        }
    }
}
