package exam.part16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private List<String> courses; // 수강하는 과목 리스트

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<String> getCourses() {
        return courses;
    }
}

public class Practice6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", Arrays.asList("Java", "Math")),
                new Student("Bob", Arrays.asList("Math", "English")),
                new Student("Charlie", Arrays.asList("Java", "History"))
        );

//        for (Student student : students) {
//            for (String course : student.getCourses()) {
//                allCourses.add(course);
//            }
//        }

        List<String> allCourses = students
                .stream()
                .flatMap(n -> n.getCourses().stream())
                .collect(Collectors.toList());

        List<String> allDistinctCourses = students
                .stream()
                .flatMap(n -> n.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());

        // 중복을 제거하지 않은 전체 수강 과목 리스트
        System.out.println(allCourses); // [Java, Math, Math, English, Java, History]
        // 중복을 제거한 전체 수강 과목 리스트
        System.out.println(allDistinctCourses); // [Java, Math, English, History]
    }
}
