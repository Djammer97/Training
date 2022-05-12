package day6;

import java.util.Random;

public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void evaluate(Student student) {
        String score;
        Random random = new Random();
        switch (random.nextInt(4) + 2) {
            case 5:
                score = "отлично";
                break;
            case 4:
                score="хорошо";
                break;
            case 3:
                score="удовлетворительно";
                break;
            default:
                score="неудовлетворительно";
        }

        System.out.printf("Преподаватель %s оценил" +
                " студента с именем %s по предмету %s " +
                "на оценку %s.\n",
                name, student.getName(), subject, score);
    }
}
