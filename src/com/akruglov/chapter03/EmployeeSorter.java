package com.akruglov.chapter03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by akruglov on 26.03.17.
 */
public class EmployeeSorter {

    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee("gggg", 23),
                new Employee("aaa", 54),
                new Employee("nnn", 88),
                new Employee("mmm", 12),
                new Employee("ggg", 12),
                new Employee("eee", 88)
        };

//        Arrays.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return Double.compare(o1.getSalary(), o2.getSalary());
//            }
//        }.thenComparing(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        }));

        Arrays.sort(employees, Comparator.comparing(Employee::getSalary)
                .thenComparing(Comparator.comparing(Employee::getName)));

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
