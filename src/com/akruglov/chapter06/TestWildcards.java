package com.akruglov.chapter06;

import java.util.ArrayList;
import java.util.function.Predicate;

public class TestWildcards {

    private static class Employee {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return getClass().getName() + "{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static <T extends Employee> void printAll(ArrayList<? extends T> staff,
                                    Predicate<? super T> filter) {
        for (T e : staff) {
            if (filter.test(e)) {
                System.out.println(e.getName());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> array = new ArrayList<>();
        array.add(new Employee("test", 15));
        array.add(new Employee("test1", 86));

        printAll(array, x -> x.getSalary() < 90);
    }
}
