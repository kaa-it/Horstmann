package com.akruglov.chapter03;

/**
 * Created by akruglov on 26.03.17.
 */
interface Measurable {
    double getMeasure();
}

public class Employee implements Measurable {

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects) {
        double result = 0;

        for (Measurable object : objects) {
            result += object.getMeasure();
        }

        if (objects.length != 0) {
            result /= objects.length;
        }

        return result;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) {
            return null;
        }

        Measurable result = objects[0];

        for (Measurable object : objects) {
            if (object.getMeasure() > result.getMeasure()) {
                result = object;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee("ddd", 56),
                new Employee("ppp", 64),
                new Employee("kkk", 89)
        };

        System.out.println("Average salary: " + average(employees));

        Measurable boss = largest(employees);

        if (boss != null) {
            System.out.println("Boss: " + ((Employee)boss).getName());
        }
    }
}
