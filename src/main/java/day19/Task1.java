package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Task1 {
    public static void main(String[] args) {
        try {
            final int size = 100;
            String text = "C:" + File.separator + "JavaMarathon2021" + File.separator +
                    "src" + File.separator + "main" + File.separator + "resources" +
                    File.separator + "dushi.txt";
            File file = new File(text);
            Scanner scanner = new Scanner(file);
            Map<String, Integer> words = new HashMap<>();
            scanner.useDelimiter("[.,:;()?!\"\\s-]+");
            while (scanner.hasNext()) {
                String temp = scanner.next();
                if (!words.containsKey(temp)) {
                    words.put(temp, 1);
                } else {
                    words.put(temp, words.get(temp) + 1);
                }
            }
            for (int i = 0; i < size; i++) {
                int tempNumber = 0;
                String tempString = null;
                for (Map.Entry<String, Integer> word : words.entrySet()) {
                    if (word.getValue() > tempNumber) {
                        tempNumber = word.getValue();
                        tempString = word.getKey();
                    }
                }
                words.remove(tempString);
                System.out.println(tempString + " - " + tempNumber);
            }
            //Чичиков - 601
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
