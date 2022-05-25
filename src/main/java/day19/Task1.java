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
            Map<String, Integer> copyMap = new HashMap<>(words);
            Map<String, Integer> top = new HashMap<>();
            while (true) {
                Map<String, Integer> tempMap = new HashMap<>();
                for (Map.Entry<String, Integer> number : copyMap.entrySet()) {
                    if (number.getValue() == Collections.max(copyMap.values())) {
                        tempMap.put(number.getKey(), number.getValue());
                    }
                }
                for (Map.Entry<String, Integer> delete : tempMap.entrySet()) {
                    copyMap.remove(delete.getKey());
                }
                for (Map.Entry<String, Integer> maxNumber : tempMap.entrySet()) {
                    top.put(maxNumber.getKey(), maxNumber.getValue());
                    if (top.size() == size) {
                        break;
                    }
                }
                if (top.size() == size) {
                    break;
                }
            }
            System.out.println(top);
            //Чичиков - 601
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
