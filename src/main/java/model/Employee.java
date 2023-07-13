package model;

public class Employee {

    private String name;
    private String position;
    private String office;
    private int age;
    private int salary;


    public Employee(String name, String position, String office, int age, int salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
