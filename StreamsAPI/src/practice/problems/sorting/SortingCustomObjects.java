package practice.problems.sorting;

// Sort custom objects by one field.

import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() { return name + ": " + salary; }


    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
public class SortingCustomObjects {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("John", 1000),
                new Employee("Alice", 500),
                new Employee("Dave", 500),
                new Employee("Bob", 1500));

        employees.stream()
                .sorted((emp1, emp2) -> emp1.getSalary() - emp2.getSalary())
                .forEach(System.out::println);
        // Sort by multiple fields (thenComparing)
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName))
                .forEach(System.out::println);
    }
}
