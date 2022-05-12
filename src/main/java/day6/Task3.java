package day6;

public class Task3 {
    public static void main(String[] args) {
        Student student = new Student("Дмитрий");
        Teacher teacher = new Teacher("Светлана Анатольевна", "русский язык");
        teacher.evaluate(student);
    }
}
