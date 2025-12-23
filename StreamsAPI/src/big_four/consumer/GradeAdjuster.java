package big_four.consumer;

/*
Problem 2: The Grade Adjuster (Object Mutation)
Goal: Prove that Consumers can modify the state of an object (Shared Reference).
Setup: Create a Student class with name (String) and grade (double).
Task: Create two consumers:
addBonus: Adds 5.0 points to the student's grade.
printReport: Prints "Student: [Name], Grade: [Grade]".
Execution:
Create a Student with a grade of 90.0.
Chain addBonus.andThen(printReport).
Check: Does the report print 90.0 or 95.0? (It should be 95.0, proving the mutation happened before the print).
 */

import java.util.function.Consumer;

class Student{
    String name;
    double grade;
    public Student(String name, double grade){
        this.name = name;
        this.grade = grade;
    }
    public String getName(){
        return this.name;
    }
    public double getGrade(){
        return this.grade;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }
    public String toString(){
        return String.format("Student: %s, Grade: %.2f", this.name, this.grade);
    }
}
public class GradeAdjuster {
    public static void main(String[] args){
        Consumer<Student> addBonus = student -> student.setGrade(student.getGrade()+5);
        Consumer<Student> printReport = System.out::println;
        Student student = new Student("John", 90.0);
        addBonus.andThen(printReport).accept(student);
    }
}
