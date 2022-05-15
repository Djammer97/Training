package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Дмитрий", "ПС4-01");
        Teacher teacher = new Teacher("Ольга Бухтияровна", "Математический анализ");
        System.out.println(student.getGroupName());
        System.out.println(teacher.getSubjectName());
        student.printInfo();
        teacher.printInfo();
    }
}
