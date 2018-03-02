package com.akruglov.chapter06;

import java.util.ArrayList;

public class ConcatArrays {

    public static <T> void concatArrays(ArrayList<? super T> dest, ArrayList<? extends T> source) {
        dest.addAll(source);
    }

    public static void main(String[] args) {
        class Employee {

        }

        class Manager extends Employee {

        }

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(new Manager());
        managers.add(new Manager());

        concatArrays(employees, managers);
    }
}
