import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Teacher {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TeacherComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher teacher1, Teacher teacher2) {
        // Compare teachers based on their age
        return teacher1.getAge() - teacher2.getAge();
    }
}

class TeacherService {
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    public void createTeacher(String name, int age) {
        Teacher teacher = new Teacher(name, age);
        teachers.add(teacher);
    }

    public void editTeacher(int index, String name, int age) {
        Teacher teacher = teachers.get(index);
        teacher.setName(name);
        teacher.setAge(age);
    }

    public void displayTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}

class TeacherView {
    private TeacherService teacherService;

    public TeacherView() {
        this.teacherService = new TeacherService();
    }

    public void start() {
        teacherService.createTeacher("John", 30);
        teacherService.createTeacher("Mary", 35);

        teacherService.displayTeachers();

        teacherService.editTeacher(0, "John Smith", 32);

        teacherService.displayTeachers();
    }
}

public class Main {
    public static void main(String[] args) {
        TeacherView teacherView = new TeacherView();
        teacherView.start();
    }
}