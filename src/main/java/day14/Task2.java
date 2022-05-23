package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("people");
        List<String> peoples = parseFileToStringList(file);
        System.out.println(peoples);
    }

    public static List<String> parseFileToStringList(File file) {
        try {
            List<String> peoples = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String tempLine = scanner.nextLine();
                String[] people = tempLine.split(" ");
                tempLine = people[0];

                if (Integer.parseInt(people[1]) < 0) throw new DataFormatException();

                peoples.add(tempLine + " " + Integer.parseInt(people[1]));
            }
            return peoples;

        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден");
        } catch (DataFormatException ex) {
            System.out.println("Некорректный входной файл");
        }

        return null;
    }
}
