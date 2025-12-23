package practice.problems.groupingandpartitioning;

import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
public class GroupEmployeesByDepartment {


    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John Doe", "Engineering"),
                new Employee("Jane Smith", "HR"),
                new Employee("Mike Johnson", "Engineering"),
                new Employee("Sarah Williams", "Finance"),
                new Employee("Tom Brown", "Marketing"),
                new Employee("Lisa Davis", "HR"),
                new Employee("David Wilson", "Engineering"),
                new Employee("Emma Taylor", "Finance"),
                new Employee("James Anderson", "Marketing"),
                new Employee("Mary Martin", "HR"),
                new Employee("Robert Lewis", "Engineering"),
                new Employee("Patricia Moore", "Finance")
        );
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.joining(", "))))
                .forEach((department, employeesInDepartment) -> System.out.println(department + ": " + employeesInDepartment));
    }
}
