package com.akruglov.chapter06;

public class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee o) {
        return 0;
    }

    /*
    Bridge method:
    public int compareTo(Object o)
     */

    // javap -c com.akruglov.chapter06.Employee
}
