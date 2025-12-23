package practice.problems.customobjects;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
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

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    public String toString() { return name + ": " + salary; }
}

public class CustomObjects {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John Smith", "Engineering", 75000.0),
                new Employee("Emma Johnson", "HR", 65000.0),
                new Employee("Michael Brown", "Marketing", 70000.0),
                new Employee("Sarah Davis", "Finance", 80000.0),
                new Employee("James Wilson", "Engineering", 78000.0),
                new Employee("Emily Taylor", "HR", 62000.0),
                new Employee("William Anderson", "Marketing", 71000.0),
                new Employee("Olivia Martinez", "Finance", 82000.0),
                new Employee("Daniel Thomas", "Engineering", 76000.0),
                new Employee("Sophia Garcia", "HR", 63000.0),
                new Employee("David Rodriguez", "Marketing", 72000.0),
                new Employee("Isabella Lopez", "Finance", 81000.0),
                new Employee("Joseph Lee", "Engineering", 77000.0),
                new Employee("Mia Hernandez", "HR", 64000.0),
                new Employee("Christopher King", "Marketing", 73000.0),
                new Employee("Ava Wright", "Finance", 83000.0),
                new Employee("Andrew Scott", "Engineering", 79000.0),
                new Employee("Charlotte Green", "HR", 66000.0),
                new Employee("Matthew Baker", "Marketing", 74000.0),
                new Employee("Amelia Nelson", "Finance", 84000.0)
        );
        // Get names of employees with salary > X.
        double salaryCutoff = 70000;
        Predicate<Employee> salaryCutoffCheck = emp -> emp.getSalary() > salaryCutoff;
        employees.stream()
                .filter(salaryCutoffCheck)
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Find highest paid employee.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        Employee highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("Highest paid employee: " + highestPaidEmployee);

        // Average salary per department.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((k, v)-> System.out.println(k + ": " + v));

        // Department → list of employee names.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((k, v)-> System.out.println(k + ": " + v));

        // Count employees per department.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.counting())))
                .forEach((k, v)-> System.out.println("Number of employees in department are -> " + k + ": " + v));

        // Sort employees by salary descending.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        System.out.println("Sorted employees by salary descending:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList()
                .forEach(System.out::println);

        // Find second highest salary.
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------\n\n");
        Employee secondHighestPaidEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .limit(1)
                .reduce(null, (e1, e2) -> e2);
        System.out.println("Second highest paid employee: " + secondHighestPaidEmployee);

    }
}
