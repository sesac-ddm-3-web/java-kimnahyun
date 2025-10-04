package exam.part16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class Practice7 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("James", "개발팀", 5500),
                new Employee("Robert", "개발팀", 6000),
                new Employee("Maria", "기획팀", 5800),
                new Employee("Linda", "기획팀", 6200),
                new Employee("David", "인사팀", 5300)
        );

        // 1. 부서별로 급여 리스트를 만든다.
//        for (Employee e : employees) {
//            salariesByDept
//                    .computeIfAbsent(e.getDepartment(), k -> new ArrayList<>())
//                    .add(e.getSalary());
//        }

        // 2. 부서별 급여 리스트를 가지고 평균을 계산한다.
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(n -> n.getDepartment(), Collectors.averagingDouble(n -> n.getSalary())));

//        for (Map.Entry<String, List<Double>> entry : salariesByDept.entrySet()) {
//            double sum = 0;
//            for (double salary : entry.getValue()) {
//                sum += salary;
//            }
//            avgSalaryByDept.put(entry.getKey(), sum / entry.getValue().size());
//        }


        System.out.println(avgSalaryByDept);
        // {인사팀=5300.0, 개발팀=5750.0, 기획팀=6000.0}
    }
}
